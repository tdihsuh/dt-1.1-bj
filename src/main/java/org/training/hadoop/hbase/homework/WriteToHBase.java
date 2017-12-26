package org.training.hadoop.hbase.homework;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class WriteToHBase {

  public static void put(Configuration conf) throws IOException {

    //Connection to the cluster.
    Connection connection = null;
    //A lightweight handler for a specific table.
    Table table = null;

    try {
      //establish the connection to the cluster.
      connection = ConnectionFactory.createConnection(conf);
      //retrieve a handler to the target table
      table = connection.getTable(TableName.valueOf(TableInformation.TABLE_NAME));
      //describe the data
      Put put = new Put(Bytes.toBytes("row1"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TITLE), Bytes.toBytes(0));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_CONTENT), Bytes.toBytes(0));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TAG), Bytes.toBytes(0));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_NAME), Bytes.toBytes(0));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_GENDER), Bytes.toBytes(0));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_AGE), Bytes.toBytes(0));
      //send the data
      table.put(put);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //close
      if (table != null) table.close();
      if (connection != null) connection.close();
    }
  }
  public static void updatePut(Configuration conf) throws IOException {

    //Connection to the cluster.
    Connection connection = null;
    //A lightweight handler for a specific table.
    Table table = null;

    try {
      //establish the connection to the cluster.
      connection = ConnectionFactory.createConnection(conf);
      //retrieve a handler to the target table
      table = connection.getTable(TableName.valueOf(TableInformation.TABLE_NAME));
      //describe the data
      Put put = new Put(Bytes.toBytes("blog1"));
//      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TITLE), Bytes.toBytes(0));
//      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_CONTENT), Bytes.toBytes(0));
//      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TAG), Bytes.toBytes(0));
//      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_NAME), Bytes.toBytes(0));
//      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_GENDER), Bytes.toBytes(0));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_AGE), Bytes.toBytes("40"));
      //send the data
      table.put(put);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //close
      if (table != null) table.close();
      if (connection != null) connection.close();
    }
  }
  public static void asyncBatchPut(Configuration conf) throws IOException {
    //Connection to the cluster.
    Connection connection = null;
    //a async batch handler
    BufferedMutator bufferedMutator = null;

    //establish the connection to the cluster.
    try {
      connection = ConnectionFactory.createConnection(conf);
      bufferedMutator = connection.getBufferedMutator(TableName.valueOf(TableInformation.TABLE_NAME));
      //describe the data
      Put put = new Put(Bytes.toBytes("blog1"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TITLE), Bytes.toBytes("mapreduce"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_CONTENT), Bytes.toBytes("Introduce mapreduce"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TAG), Bytes.toBytes("computing"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_NAME), Bytes.toBytes("David"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_GENDER), Bytes.toBytes("male"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_AGE), Bytes.toBytes("34"));

      bufferedMutator.mutate(put);
      //describe the data
      put = new Put(Bytes.toBytes("blog2"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TITLE), Bytes.toBytes("hadoop"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_CONTENT), Bytes.toBytes("Hadoop in action"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TAG), Bytes.toBytes("system"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_NAME), Bytes.toBytes("Jim"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_GENDER), Bytes.toBytes("male"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_AGE), Bytes.toBytes(35));

      bufferedMutator.mutate(put);
      //describe the data
      put = new Put(Bytes.toBytes("blog3"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TITLE), Bytes.toBytes("hdfs"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_CONTENT), Bytes.toBytes("HDFS principle"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_ARTICLE), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_TAG), Bytes.toBytes("storage"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_NAME), Bytes.toBytes("Jack"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_GENDER), Bytes.toBytes("male"));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_AGE), Bytes.toBytes(21));

      bufferedMutator.mutate(put);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //close
      if (bufferedMutator != null) bufferedMutator.close();
      if (connection != null) connection.close();
    }
  }

  public static void main(String[] args) throws IOException {
    //WriteToHBase.put(TableInformation.getHBaseConfiguration());
    WriteToHBase.updatePut(TableInformation.getHBaseConfiguration());
  }

}
