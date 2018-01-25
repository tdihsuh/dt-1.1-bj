package cn.com.cycredit.hadoop.score

import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, HConstants}
import org.apache.hadoop.mapred.JobConf
import org.apache.spark.util.StatCounter
import org.apache.spark.{SparkConf, SparkContext}

object ComputeScore {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("ScoreCompute").setMaster("local[2]")
    val sc = new SparkContext(sparkConf)
    val conf = HBaseConfiguration.create();
    val zookeeper = "10.2.30.241:2181"
    val tableName = "test_now"
    conf.set(HConstants.ZOOKEEPER_QUORUM, zookeeper)
    conf.set(TableInputFormat.INPUT_TABLE, tableName)

    val hBaseRDD = sc.newAPIHadoopRDD(conf,classOf[TableInputFormat],
      classOf[org.apache.hadoop.hbase.io.ImmutableBytesWritable],
      classOf[org.apache.hadoop.hbase.client.Result])
    hBaseRDD.count()

    val rowKeyRDD = hBaseRDD.map(tuple=>tuple._1).map(item => Bytes.toString(item.get()))
    rowKeyRDD.take(3).foreach(println)

    val resultRDD = hBaseRDD.map(tuple=>tuple._2)
    resultRDD.count()

    val keyValueRDD = resultRDD.map(result => (Bytes.toString(result.getRow()).split(" ")(0),Bytes.toDouble(result.value)))
    keyValueRDD.take(3).foreach(kv => println(kv))

    val keyStatsRDD = keyValueRDD.groupByKey().mapValues(list => StatCounter(list))
    keyStatsRDD.take(5).foreach(println)

    val jobConfig:JobConf = new JobConf(conf,this.getClass)
    jobConfig.setOutputFormat(classOf[TableOutputFormat])
    jobConfig.set(TableOutputFormat.OUTPUT_TABLE,tableName)
    keyStatsRDD.saveAsHadoopDataset(jobConfig)

    sc.stop()
  }

}
