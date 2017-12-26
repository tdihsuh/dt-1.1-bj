package works.kafka2hbase;

import net.sf.json.JSONObject;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.BufferedMutator;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;

public class WriteToHBaseCY {

  public static void asyncBatchPut(Configuration conf, ConsumerRecords<String,String> records,String topicName) throws IOException {
    //Connection to the cluster.
    Connection connection = null;
    //a async batch handler
    BufferedMutator bufferedMutator = null;

    //establish the connection to the cluster.
    try {
      connection = ConnectionFactory.createConnection(conf);
      bufferedMutator = connection.getBufferedMutator(TableName.valueOf(TableInformationCY.TABLE_NAME));
      //describe the data

      if("tag_ag".equals(topicName)) {
        // TODO 无结构，无数据
      }else if("tag_ap".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("--------------------tag_ap-------------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("company_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_AP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_AP_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_AP_10)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_cb".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("-----------------------tag_cb---------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CB), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CB_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CB_9)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_cd".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("-----------------------tag_cd----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_13)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_14), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_14)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_15), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_15)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CD), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CD_16), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CD_16)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_ci".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("-----------------------tag_ci----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("ent_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CI), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CI_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CI_9)));
          bufferedMutator.mutate(put);
        }

      }else if("tag_cm".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("----------------------tag_cm-----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("credit_recordBody")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CM_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CM_13)));
          bufferedMutator.mutate(put);
        }

      }else if("tag_cs".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("--------------------tag_cs-------------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("ent_name"))); // TODO  个人和企业信息在一起的问题.
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CS), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CS_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CS_9)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_cu".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("-----------------------tag_cu----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_CU), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_CU_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_CU_13)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_dp".equals(topicName)){
        // TODO 无结构，无数据
      }else if("tag_fm".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("--------------------tag_fm-------------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_13)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_14), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_14)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_15), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_15)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_16), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_16)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_FM), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_FM_17), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_FM_17)));
          bufferedMutator.mutate(put);
        }

      }else if("tag_gp".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("----------------------tag_gp-----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_GP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_GP_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_GP_12)));
          bufferedMutator.mutate(put);
        }

      }else if("tag_mt".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("----------------------tag_mt-----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name"))); // TODO 个人和企业 数据在一个topic的问题
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_MT), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_MT_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_MT_13)));
          bufferedMutator.mutate(put);
        }

      }else if("tag_oe".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("----------------------tag_oe-----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_OE), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_OE_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_OE_12)));
          bufferedMutator.mutate(put);
        }

      }else if("tag_qb".equals(topicName)){
        // TODO 无结构，无数据
      }else if("tag_sb".equals(topicName)){
        // TODO 无结构，无数据
      }else if("tag_sp".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("----------------------tag_sp-----------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_13)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_14), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_14)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_15), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_15)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_16), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_16)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_17), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_17)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_18), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_18)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_19), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_19)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_20), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_20)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_SP), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_SP_21), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_SP_21)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_ta".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("---------------------tag_ta------------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_13)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_14), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_14)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_15), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_15)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TA), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TA_16), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TA_16)));
          bufferedMutator.mutate(put);
        }
      }else if("tag_tr".equals(topicName)){
        for (ConsumerRecord<String, String> record : records) {
          String value = record.value();
          JSONObject valueJsonObject = JSONObject.fromObject(value);
          System.out.println("-------------------------tag_tr--------------------"+ value.toString());
          Put put = new Put(Bytes.toBytes((String) valueJsonObject.get("entity_name")));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_1), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_1)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_2), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_2)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_3), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_3)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_4), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_4)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_5), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_5)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_6), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_6)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_7), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_7)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_8), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_8)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_9), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_9)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_10), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_10)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_11), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_11)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_12), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_12)));
          put.addColumn(Bytes.toBytes(TableInformationCY.FAMILY_NAME_TR), Bytes.toBytes(TableInformationCY.QUALIFIER_NAME_TR_13), Bytes.toBytes((String) valueJsonObject.get(TableInformationCY.QUALIFIER_NAME_TR_13)));
          bufferedMutator.mutate(put);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //close
      if (bufferedMutator != null) bufferedMutator.close();
      if (connection != null) connection.close();
    }
  }

}
