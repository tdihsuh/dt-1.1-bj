package cn.com.cycredit.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;

public class ScanFromHBase {

  public static void scan(Configuration conf) throws IOException {
    Connection connection = null;

    connection = ConnectionFactory.createConnection(conf);

    Table table = connection.getTable(TableName.valueOf(TableInformation.TABLE_NAME));

    Scan scan = new Scan();
    scan.setMaxVersions(256);
    scan.setCaching(1);
    ResultScanner results = table.getScanner(scan);
    int i = 0;
    for (Result result : results) {
      String str = "";
      String rowname = "";
      while (result.advance()) {
        System.out.println(result.current());
        str += "[[" + result.current().toString() + "]]";
        if("".equals(rowname)){
          rowname = Bytes.toString(result.getRow());
        }
      }
      int score = scoreCompute(str);
      Put put = new Put(Bytes.toBytes(rowname));
      put.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_INFOS), Bytes.toBytes(TableInformation.QUALIFIER_SCORE), Bytes.toBytes("" + score));
      table.put(put);
      if(++i %100 ==0 ){
        System.out.println("已经更新第"+ i +"个实体的薪信用分");
      }
    }
    table.close();
    connection.close();
  }

  private static int scoreCompute(String str) {
    int score = 0;
    ArrayList<Integer> counts = new ArrayList<Integer>();

    int agScore = ScanFromHBase.getTopicScore(str, "ag:pun_type",
            new String[]{"ELSE", "警告", "罚款", "没收违法所得", "责令停产停业", "暂扣","吊销","行政拘留"},
            new int[]{1, 1, 3, 3, 9, 9, 9});
    counts.add(agScore);

    int cbScore = ScanFromHBase.getTopicScore(str, "cb:decision",
            new String[]{"ELSE", "警告", "罚款", "没收违法所得", "责令停产停业", "暂扣","吊销","行政拘留"},
            new int[]{1, 1, 3, 3, 9, 9, 9});
    counts.add(cbScore);

    int ciScore = ScanFromHBase.getTopicScore(str, "ci:content",
            new String[]{"ELSE", "警告", "罚款", "没收违法所得", "责令停产停业", "暂扣","吊销","行政拘留"},
            new int[]{1, 1, 3, 3, 9, 9, 9});
    counts.add(ciScore);

    int csScore = ScanFromHBase.getTopicScore(str, "cs:pun_content",
            new String[]{"ELSE", "警告", "罚款", "没收违法所得", "责令停产停业", "暂扣","吊销","行政拘留"},
            new int[]{1, 1, 3, 3, 9, 9, 9});
    counts.add(csScore);

    int cmScore = ScanFromHBase.getTopicScore(str, "cm:pun_content",
            new String[]{"ELSE", "警告", "通报批评", "罚款", "没收违法所得", "责令停产停业", "暂扣","吊销","行政拘留"},
            new int[]{1, 1, 1, 1, 3, 3, 9, 9, 9});
    counts.add(cmScore);


    int trScore = ScanFromHBase.getTopicScore(str, "tr:penalty_content",
            new String[]{"ELSE", "警告", "罚款", "没收违法所得", "责令整改", "暂扣","吊销","行政拘留"},
            new int[]{1, 1, 3, 3, 9, 9, 9});
    counts.add(trScore);

//    int dpScore = ScanFromHBase.getTopicScore(str, "dp:penalty_content", new String[]{"ELSE", "警告", "拘留"}, new int[]{1, 1, 6});
//    counts.add(dpScore);
//
    int oeScore = ScanFromHBase.getTopicScore(str, "oe:pun_reason",
            new String[]{"ELSE", "企业异常名录", "企业严重违法"},
            new int[]{1, 1, 9});
    counts.add(oeScore);

    int mtScore = ScanFromHBase.getTopicScore(str, "mt:uncredit_content",
            new String[]{"ELSE", "伪造发票", "偷税漏税"},
            new int[]{9, 9, 9});
    counts.add(mtScore);

    int gpScore = ScanFromHBase.getTopicScore(str, "gp:pun_content",
            new String[]{"ELSE", "通报批评", "罚款", "禁止参加政府采购活动", "撤销政府采购代理机构的资格", "撤销中标"},
            new int[]{1, 1, 1, 3, 9, 9});
    counts.add(gpScore);


    int sbScore = ScanFromHBase.getTopicScore(str, "sb:info_source",
            new String[]{"ELSE", "隐患曝光", "重大事故通报"},
            new int[]{1, 3, 9});
    counts.add(sbScore);

    int fmScore = ScanFromHBase.getTopicScore(str, "fm:operation",
            new String[]{"ELSE", "注销", "撤销证书", "限期整改", "违法广告", "食品抽检不合格", "食品安全审计通报"},
            new int[]{1, 9, 9, 9, 3, 9, 1});
    counts.add(fmScore);

//    int qbScore = ScanFromHBase.getTopicScore(str, "qb:penalty_content", new String[]{"ELSE", "警告", "拘留"}, new int[]{1, 1, 6});
//    counts.add(qbScore);

    int cuScore = ScanFromHBase.getTopicScore(str, "cu:entity_name",
            new String[]{"ELSE"},
            new int[]{9});
    counts.add(cuScore);

    int spScore = ScanFromHBase.getTopicScore(str, "sp:status",
            new String[]{"ELSE", "全部未履行", "部分未履行"},
            new int[]{1, 9, 3});
    counts.add(spScore);


    int total = 0;
    for (int i = 0; i < counts.size(); i++) {
      total += counts.get(i);
    }

    return total;
  }






    /*
    // 1 ag 农业领域行政处罚
    int countSumAG = cyCompareNumber(str, "\\[\\[.*?" + AG_PATTERN +".*?\\]\\]");
    if(countSumAG >0){
      ArrayList<Integer> counts = new ArrayList<Integer>();

      int countSum1 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN +".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum2 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN + ".*?罚款.*?\\]\\]");
      counts.add(countSum2);
      score += countSum2;

      int countSum3 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN + ".*?没收违法所得.*?\\]\\]");
      counts.add(countSum3);
      score += countSum3 * 3;

      int countSum4 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN + ".*?责令停产停业.*?\\]\\]");
      counts.add(countSum4);
      score += countSum4 * 3;

      int countSum5 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN + ".*?暂扣.*?\\]\\]");
      counts.add(countSum5);
      score += countSum5 * 9;

      int countSum6 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN + ".*?吊销.*?\\]\\]");
      counts.add(countSum6);
      score += countSum6 * 9;

      int countSum7 = cyCompareNumber(str,"\\[\\[.*?" + AG_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum7);
      score += countSum7*9;

      int useredTotal = 0;
      for (int i = 0; i < counts.size(); i++) {
        useredTotal += counts.get(i);
      }

      if(useredTotal != countSumAG){
        score += (countSumAG - useredTotal);
      }
    }

    // 2 cb 银监会行政处罚
    int countSumCB = cyCompareNumber(str, "\\[\\[.*?" + CB_PATTERN + ".*?\\]\\]");
    if(countSumCB > 0){
      ArrayList<Integer> counts = new ArrayList<Integer>();

      int countSum1 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum2 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?罚款.*?\\]\\]");
      counts.add(countSum2);
      score += countSum2;

      int countSum3 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?没收违法所得.*?\\]\\]");
      counts.add(countSum3);
      score += countSum3 * 3;

      int countSum4 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?责令停产停业.*?\\]\\]");
      counts.add(countSum4);
      score += countSum4 * 3;

      int countSum5 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?暂扣.*?\\]\\]");
      counts.add(countSum5);
      score += countSum5 * 9;

      int countSum6 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?吊销.*?\\]\\]");
      counts.add(countSum6);
      score += countSum6 * 9;

      int countSum7 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum7);
      score += countSum7 * 9;

      int countSum8 = cyCompareNumber(str,"\\[\\[.*?" + CB_PATTERN + ".*?取消高管任职资格.*?\\]\\]");
      counts.add(countSum8);
      score += countSum8 * 3;

      int useredTotal = 0;
      for (int i = 0; i < counts.size(); i++) {
        useredTotal += counts.get(i);
      }

      if(useredTotal != countSumCB){
        score += (countSumCB - useredTotal);
      }
    }

    // 3 ci 保监会行政处罚
   int countSumCI = cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?\\]\\]");
    if(countSumCI > 0){
      ArrayList<Integer> counts = new ArrayList<Integer>();

      int countSum1 = cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum2 = cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?罚款.*?\\]\\]");
      counts.add(countSum2);
      score += countSum2;

      int countSum3 = cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?没收违法所得.*?\\]\\]");
      counts.add(countSum3);
      score += countSum3 * 3;

      int countSum4 = cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?责令停产停业.*?\\]\\]");
      counts.add(countSum4);
      score += countSum4 * 3;

      int countSum5 = cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?暂扣.*?\\]\\]");
      counts.add(countSum5);
      score += countSum5 * 9;

      int countSum6 =cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?吊销.*?\\]\\]");
      counts.add(countSum6);
      score += countSum6 * 9;

      int countSum7 =cyCompareNumber(str,"\\[\\[.*?" + CI_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum7);
      score += countSum7 * 9;

      int useredTotal = 0;
      for (int i = 0; i < counts.size(); i++) {
        useredTotal += counts.get(i);
      }

      if(useredTotal != countSumCI){
        score += (countSumCI - useredTotal);
      }
    }

    // 4 cs 证监会行政处罚
    int countSumCS = cyCompareNumber(str, "\\[\\[.*?" + CS_PATTERN + ".*?\\]\\]");
    if(countSumCS > 0){
      ArrayList<Integer> counts = new ArrayList<Integer>();

      int countSum1 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum2 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?罚款.*?\\]\\]");
      counts.add(countSum2);
      score += countSum2;

      int countSum3 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?没收违法所得.*?\\]\\]");
      counts.add(countSum3);
      score += countSum3 * 3;

      int countSum4 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?责令停产停业.*?\\]\\]");
      counts.add(countSum4);
      score += countSum4 * 3;

      int countSum5 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?暂扣.*?\\]\\]");
      counts.add(countSum5);
      score += countSum5 * 9;

      int countSum6 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?吊销.*?\\]\\]");
      counts.add(countSum6);
      score += countSum6 * 9;

      int countSum7 = cyCompareNumber(str,"\\[\\[.*?" + CS_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum7);
      score += countSum7 * 9;

      int useredTotal = 0;
      for (int i = 0; i < counts.size(); i++) {
        useredTotal += counts.get(i);
      }

      if(useredTotal != countSumCS){
        score += (countSumCS - useredTotal);
      }
    }

    // 5 cm 建筑市场违法欺骗
    int countSumCM = cyCompareNumber(str, "\\[\\[.*?" + CM_PATTERN + ".*?\\]\\]");
    if(countSumCM >0){
      ArrayList<Integer> counts = new ArrayList<Integer>();

      int countSum1 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum2 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum2);
      score += countSum2;

      int countSum3 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum3);
      score += countSum3;

      int countSum4 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum4);
      score += countSum4;

      int countSum5 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum5);
      score += countSum5;

      int countSum6 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum6);
      score += countSum6;

      int countSum7 = cyCompareNumber(str,"\\[\\[.*?" + CM_PATTERN + ".*?行政拘留.*?\\]\\]");
      counts.add(countSum7);
      score += countSum7;

      int useredTotal = 0;
      for (int i = 0; i < counts.size(); i++) {
        useredTotal += counts.get(i);
      }

      if(useredTotal != countSumCM){
        score += (countSumCM - useredTotal);
      }

    }

    // 6 tr 旅游不良信息
    int countSumTR = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?\\]\\]");
    if(countSumTR >0){
      ArrayList<Integer> counts = new ArrayList<Integer>();

      int countSum1 = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum2 = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum3 = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum4 = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum5 = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

      int countSum6 = cyCompareNumber(str, "\\[\\[.*?" + TR_PATTERN + ".*?警告.*?\\]\\]");
      counts.add(countSum1);
      score += countSum1;

    }

    // 7 dp 发展改革委受惩黑名单
    if(cyCompareNumber(str,"\\[\\[.*?dp:pun_content.*?\\]\\]")>0){
      int currentInt = cyCompareNumber(str,"\\[\\[.*?dp:pun_content.*?\\]\\]");
      int currentScore = score;
      if(1==1){
        score += cyCompareNumber(str, "\\[\\[.*?dp:pun_content.*?行政拘留.*?\\]\\]") * 9;
      }else{
        score += cyCompareNumber(str, "\\[\\[.*?dp:pun_content.*?行政拘留.*?\\]\\]") * 9;
      }
    }

    // 8 oe 企业经营异常
    if(cyCompareNumber(str,"\\[\\[.*?oe.*?\\]\\]")>0){
      score += cyCompareNumber(str, "\\[\\[.*?oe:pun_reason.*?行政拘留.*?\\]\\]") * 9;

    }

    // 9 mt 重大税收违法
    if(cyCompareNumber(str,"\\[\\[.*?mt:pun_reason.*?\\]\\]")>0){
      score += cyCompareNumber(str, "\\[\\[.*?mt:pun_reason.*?\\]\\]") * 9;
    }

    // 10 政府采购失信
    if(cyCompareNumber(str,"\\[\\[.*?gp:pun_content.*?\\]\\]")>0){
      score += cyCompareNumber(str, "\\[\\[.*?gp:pun_content.*?行政拘留.*?\\]\\]") * 9;

    }

    // 11 安全生产黑名单
    if(cyCompareNumber(str,"\\[\\[.*?sb:info_source.*?\\]\\]")>0){
      score += cyCompareNumber(str, "\\[\\[.*?sb:info_source.*?行政拘留.*?\\]\\]") * 9;

    }

    // 12 fm 食品、药品虚假广告
    if(cyCompareNumber(str,"\\[\\[.*?fm:operation.*?\\]\\]")>0){
      score += cyCompareNumber(str, "\\[\\[.*?fm:operation.*?行政拘留.*?\\]\\]") * 9;

    }

    // 13 qb 质量黑名单
    if(cyCompareNumber(str,"\\[\\[.*?qb:pun_reason.*?\\]\\]")>0){
      if(1==1){

      }else{
        score += cyCompareNumber(str, "\\[\\[.*?qb:pun_reason.*?行政拘留.*?\\]\\]") * 9;
      }
    }

    // 14 cu 海关失信企业
    if(cyCompareNumber(str,"\\[\\[.*?cu:pun_reason.*?\\]\\]")>0){
      if(1==1){

      }else {
        score += cyCompareNumber(str, "\\[\\[.*?cu:pun_reason.*?行政拘留.*?\\]\\]") * 9;
      }

    }

    // 15 sp 失信被执行人
    if(cyCompareNumber(str,"\\[\\[.*?sp:status.*?\\]\\]")>0){
      score += cyCompareNumber(str, "\\[\\[.*?sp:status.*?行政拘留.*?\\]\\]") * 9;


    }
    return score;
  }   */

  public static int cyCompareNumber(String str, String pattern) {
    String [] ary = ("," + str.toLowerCase() + ",").split(pattern);
    return ary.length - 1;
  }

  public static int getTopicScore(String objectStr ,String topicKey,String[] keyWords, int[] scores){
    if(keyWords.length != scores.length || keyWords.length == 0){
      throw new RuntimeException("input error");
    }
    if (keyWords.length == 1) { // 如果只有一个值，说明没有关键字匹配
      return cyCompareNumber(objectStr, "\\[\\[.*?" + topicKey +".*?\\]\\]") * scores[0];
    } else {
      ArrayList<Integer> counts = new ArrayList<Integer>(); // 所有关键字匹配数
      int resultScore = 0; // 信用分的和
      int countOne = cyCompareNumber(objectStr, "\\[\\[.*?" + topicKey +".*?\\]\\]"); // 总共条数
      for(int i = 1; i<keyWords.length; i++){
        int countSum = cyCompareNumber(objectStr, "\\[\\[.*?" + topicKey + ".*?" + keyWords[i] + ".*?\\]\\]");
        counts.add(countSum);
        resultScore += countSum * scores[i];
      }
      int useredTotal = 0;
      for (int i = 0; i < counts.size(); i++) {
        useredTotal += counts.get(i);
      }

      if(useredTotal != countOne){
        resultScore += (countOne - useredTotal) * scores[0];
      }
      return resultScore;
    }
  }

  public static void main(String args[]) throws IOException {
    ScanFromHBase.scan(TableInformation.getHBaseConfiguration());

  }
}
