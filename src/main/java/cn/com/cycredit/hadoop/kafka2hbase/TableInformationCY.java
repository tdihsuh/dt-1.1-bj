package cn.com.cycredit.hadoop.kafka2hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class TableInformationCY {

  public static final String TABLE_NAME_ENTERPRISE = "enterprise_credit_test";
  public static final String TABLE_NAME_INDIVIDUAL = "individual_credit_test";

  // 农业部行政处罚
  public static final String FAMILY_NAME_AG = "ag";
  // 政府行政处罚
  public static final String FAMILY_NAME_AP = "ap";
  // 银监局行政处罚
  public static final String FAMILY_NAME_CB = "cb";
  // 商务部黑名单
  public static final String FAMILY_NAME_CD = "cd";
  // 保监会行政处罚
  public static final String FAMILY_NAME_CI = "ci";
  // 建筑市场违法欺骗
  public static final String FAMILY_NAME_CM = "cm";
  // 证监会行政处罚
  public static final String FAMILY_NAME_CS = "cs";
  // 海关失信企业
  public static final String FAMILY_NAME_CU = "cu";
  // 发展改革委受惩黑名单
  public static final String FAMILY_NAME_DP = "dp";
  // 食药监局黑名单
  public static final String FAMILY_NAME_FM = "fm";
  // 政府采购失信
  public static final String FAMILY_NAME_GP = "gp";
  // 重大税收违法
  public static final String FAMILY_NAME_MT = "mt";
  // 企业经营异常
  public static final String FAMILY_NAME_OE = "oe";
  // 质量黑名单
  public static final String FAMILY_NAME_QB = "qb";
  // 安全生产黑名单
  public static final String FAMILY_NAME_SB = "sb";
  // 高法受惩黑名单
  public static final String FAMILY_NAME_SP = "sp";
  // 企业欠税信息
  public static final String FAMILY_NAME_TA = "ta";
  // 旅游不良信息
  public static final String FAMILY_NAME_TR = "tr";

  // 政府行政处罚 COLUMN NAMES
  public static final String QUALIFIER_NAME_AP_1   = "case_no";
  public static final String QUALIFIER_NAME_AP_2 = "punish_type1";
  public static final String QUALIFIER_NAME_AP_3 = "punish_reason";
  public static final String QUALIFIER_NAME_AP_4 = "law_item";
  public static final String QUALIFIER_NAME_AP_5 = "entity_name";
  public static final String QUALIFIER_NAME_AP_6 = "credit_no";
  public static final String QUALIFIER_NAME_AP_7 = "org_code";
  public static final String QUALIFIER_NAME_AP_8 = "reg_no";
  public static final String QUALIFIER_NAME_AP_9 = "tax_no";
  public static final String QUALIFIER_NAME_AP_10 = "identity_card";
  public static final String QUALIFIER_NAME_AP_11 = "legal_man";
  public static final String QUALIFIER_NAME_AP_12 = "punish_result";
  public static final String QUALIFIER_NAME_AP_13 = "punish_date";
  public static final String QUALIFIER_NAME_AP_14 = "punish_agent";
  public static final String QUALIFIER_NAME_AP_15 = "current_status";
  public static final String QUALIFIER_NAME_AP_16 = "area_code";
  public static final String QUALIFIER_NAME_AP_17 = "offical_updtime";
  public static final String QUALIFIER_NAME_AP_18 = "note";
  public static final String QUALIFIER_NAME_AP_19 = "create_date";
  public static final String QUALIFIER_NAME_AP_20 = "update_date";
  public static final String QUALIFIER_NAME_AP_21 = "punish_type2";
  public static final String QUALIFIER_NAME_AP_22 = "entity_type";
  public static final String QUALIFIER_NAME_AP_23 = "data_source";
  public static final String QUALIFIER_NAME_AP_24 = "source_url";
  public static final String QUALIFIER_NAME_AP_25 = "source_page";
  public static final String QUALIFIER_NAME_AP_26 = "spider_name";
  public static final String QUALIFIER_NAME_AP_27 = "notice_id";

  // 银监局行政处罚 COLUMN NAMES

  // 商务部黑名单 COLUMN NAMES
  public static final String QUALIFIER_NAME_CD_1 = "socialUnionNum";
  public static final String QUALIFIER_NAME_CD_2 = "punishDate";
  public static final String QUALIFIER_NAME_CD_3 = "punishDepartment";
  public static final String QUALIFIER_NAME_CD_4 = "entity_name";
  public static final String QUALIFIER_NAME_CD_5 = "legalMan";
  public static final String QUALIFIER_NAME_CD_6 = "fileNum";
  public static final String QUALIFIER_NAME_CD_7 = "source_page";
  public static final String QUALIFIER_NAME_CD_8 = "source_url";
  public static final String QUALIFIER_NAME_CD_9 = "managerRange";
  public static final String QUALIFIER_NAME_CD_10 = "compName";
  public static final String QUALIFIER_NAME_CD_11 = "create_date";
  public static final String QUALIFIER_NAME_CD_12 = "spider_name";
  public static final String QUALIFIER_NAME_CD_13 = "deadLine";
  public static final String QUALIFIER_NAME_CD_14 = "orgNum";
  public static final String QUALIFIER_NAME_CD_15 = "fianceNum";
  public static final String QUALIFIER_NAME_CD_16 = "regAddress";
  public static final String QUALIFIER_NAME_CD_17 = "punishType";
  public static final String QUALIFIER_NAME_CD_18 = "businessRegNum";

  // 保监会行政处罚 COLUMN NAMES
  public static final String QUALIFIER_NAME_CI_1 = "spider_name";
  public static final String QUALIFIER_NAME_CI_2 = "create_date";
  public static final String QUALIFIER_NAME_CI_3 = "ent_name";
  public static final String QUALIFIER_NAME_CI_4 = "title";
  public static final String QUALIFIER_NAME_CI_5 = "source_page";
  public static final String QUALIFIER_NAME_CI_6 = "address";
  public static final String QUALIFIER_NAME_CI_7 = "identity_code";
  public static final String QUALIFIER_NAME_CI_8 = "person_name";
  public static final String QUALIFIER_NAME_CI_9 = "case_no";
  public static final String QUALIFIER_NAME_CI_10 = "source_url";
  public static final String QUALIFIER_NAME_CI_11 = "content";
  public static final String QUALIFIER_NAME_CI_12 = "org_level";
  public static final String QUALIFIER_NAME_CI_13 = "pub_date";

  // 建筑市场违法欺骗 COLUMN NAMES
  public static final String QUALIFIER_NAME_CM_1 = "credit_icon";
  public static final String QUALIFIER_NAME_CM_2 = "credit_recordNum";
  public static final String QUALIFIER_NAME_CM_3 = "credit_recordBody";
  public static final String QUALIFIER_NAME_CM_4 = "credit_recordBodyDetailUrl";
  public static final String QUALIFIER_NAME_CM_5 = "credit_recordBodyDetailSourceCode";
  public static final String QUALIFIER_NAME_CM_6 = "credit_recordBodyTag";
  public static final String QUALIFIER_NAME_CM_7 = "credit_recordBodyID";
  public static final String QUALIFIER_NAME_CM_8 = "credit_recordBodyGender";
  public static final String QUALIFIER_NAME_CM_9 = "reason";
  public static final String QUALIFIER_NAME_CM_10 = "result";
  public static final String QUALIFIER_NAME_CM_11 = "resultTag";
  public static final String QUALIFIER_NAME_CM_12 = "administration";
  public static final String QUALIFIER_NAME_CM_13 = "notice_id";
  public static final String QUALIFIER_NAME_CM_14 = "recordTime";
  public static final String QUALIFIER_NAME_CM_15 = "source_page";
  public static final String QUALIFIER_NAME_CM_16 = "spider_name";
  public static final String QUALIFIER_NAME_CM_17 = "source_url";

  // 证监会行政处罚 COLUMN NAMES
  public static final String QUALIFIER_NAME_CS_1 = "spider_name";
  public static final String QUALIFIER_NAME_CS_2 = "create_date";
  public static final String QUALIFIER_NAME_CS_3 = "title";
  public static final String QUALIFIER_NAME_CS_4 = "gender";
  public static final String QUALIFIER_NAME_CS_5 = "case_no";
  public static final String QUALIFIER_NAME_CS_6 = "content";
  public static final String QUALIFIER_NAME_CS_7 = "update_date";
  public static final String QUALIFIER_NAME_CS_8 = "ent_name";
  public static final String QUALIFIER_NAME_CS_9 = "source_url";
  public static final String QUALIFIER_NAME_CS_10 = "memo";
  public static final String QUALIFIER_NAME_CS_11 = "source_page";
  public static final String QUALIFIER_NAME_CS_12 = "org_level";
  public static final String QUALIFIER_NAME_CS_13 = "person_name";
  public static final String QUALIFIER_NAME_CS_14 = "pub_date";

  // 海关失信企业 COLUMN NAMES
  public static final String QUALIFIER_NAME_CU_1 = "creditcode";
  public static final String QUALIFIER_NAME_CU_2 = "entity_name";
  public static final String QUALIFIER_NAME_CU_3 = "org_code";
  public static final String QUALIFIER_NAME_CU_4 = "source_page";
  public static final String QUALIFIER_NAME_CU_5 = "copname";
  public static final String QUALIFIER_NAME_CU_6 = "source_url";
  public static final String QUALIFIER_NAME_CU_7 = "spider_name";

  // 食药监局黑名单 COLUMN NAMES
  public static final String QUALIFIER_NAME_FM_1 = "spider_name";
  public static final String QUALIFIER_NAME_FM_2 = "pub_mode";
  public static final String QUALIFIER_NAME_FM_3 = "create_date";
  public static final String QUALIFIER_NAME_FM_4 = "ent_name";
  public static final String QUALIFIER_NAME_FM_5 = "source_page";
  public static final String QUALIFIER_NAME_FM_6 = "title";
  public static final String QUALIFIER_NAME_FM_7 = "check_org";
  public static final String QUALIFIER_NAME_FM_8 = "legal_man";
  public static final String QUALIFIER_NAME_FM_9 = "content";
  public static final String QUALIFIER_NAME_FM_10 = "link";
  public static final String QUALIFIER_NAME_FM_11 = "problem";
  public static final String QUALIFIER_NAME_FM_12 = "source_url";
  public static final String QUALIFIER_NAME_FM_13 = "attach_flag";
  public static final String QUALIFIER_NAME_FM_14 = "address";
  public static final String QUALIFIER_NAME_FM_15 = "check_date";
  public static final String QUALIFIER_NAME_FM_16 = "operation";
  public static final String QUALIFIER_NAME_FM_17 = "update_date";
  public static final String QUALIFIER_NAME_FM_18 = "check_reason";
  public static final String QUALIFIER_NAME_FM_19 = "medicine_certno";
  public static final String QUALIFIER_NAME_FM_20 = "pub_date";
  public static final String QUALIFIER_NAME_FM_21 = "credit_code";

  // 政府采购失信 COLUMN NAMES
  public static final String QUALIFIER_NAME_GP_1 = "entity_name";
  public static final String QUALIFIER_NAME_GP_2 = "spider_name";
  public static final String QUALIFIER_NAME_GP_3 = "punishDate";
  public static final String QUALIFIER_NAME_GP_4 = "create_date";
  public static final String QUALIFIER_NAME_GP_5 = "source_page";
  public static final String QUALIFIER_NAME_GP_6 = "compAddress";
  public static final String QUALIFIER_NAME_GP_7 = "source_url";
  public static final String QUALIFIER_NAME_GP_8 = "orgNum";
  public static final String QUALIFIER_NAME_GP_9 = "punishResult";
  public static final String QUALIFIER_NAME_GP_10 = "punishBy";
  public static final String QUALIFIER_NAME_GP_11 = "uncreditContent";
  public static final String QUALIFIER_NAME_GP_12 = "exeDepartment";

  // 重大税收违法 COLUMN NAMES
  public static final String QUALIFIER_NAME_MT_1 = "tax_name";
  public static final String QUALIFIER_NAME_MT_2 = "tax_num";
  public static final String QUALIFIER_NAME_MT_3 = "org_num";
  public static final String QUALIFIER_NAME_MT_4 = "reg_address";
  public static final String QUALIFIER_NAME_MT_5 = "legal_man_name";
  public static final String QUALIFIER_NAME_MT_6 = "legal_man_sex";
  public static final String QUALIFIER_NAME_MT_7 = "legal_man_identify_num";
  public static final String QUALIFIER_NAME_MT_8 = "case_nature";
  public static final String QUALIFIER_NAME_MT_9 = "uncredit_content";
  public static final String QUALIFIER_NAME_MT_10 = "create_date";
  public static final String QUALIFIER_NAME_MT_11 = "source_page";
  public static final String QUALIFIER_NAME_MT_12 = "source_url";
  public static final String QUALIFIER_NAME_MT_13 = "spider_name";

  // 企业经营异常 COLUMN NAMES
  public static final String QUALIFIER_NAME_OE_1 = "case_no";
  public static final String QUALIFIER_NAME_OE_2 = "punish_agent";
  public static final String QUALIFIER_NAME_OE_3 = "punish_date";
  public static final String QUALIFIER_NAME_OE_4 = "entity_name";
  public static final String QUALIFIER_NAME_OE_5 = "punish_reason";
  public static final String QUALIFIER_NAME_OE_6 = "data_id";
  public static final String QUALIFIER_NAME_OE_7 = "data_source";
  public static final String QUALIFIER_NAME_OE_8 = "del_flag";
  public static final String QUALIFIER_NAME_OE_9 = "op_flag";
  public static final String QUALIFIER_NAME_OE_10 = "create_date";
  public static final String QUALIFIER_NAME_OE_11 = "source_url";
  public static final String QUALIFIER_NAME_OE_12 = "source_page";
  public static final String QUALIFIER_NAME_OE_13 = "reg_no";
  public static final String QUALIFIER_NAME_OE_14 = "report_year";
  public static final String QUALIFIER_NAME_OE_15 = "spider_name";
  public static final String QUALIFIER_NAME_OE_16 = "notice_id";

  // 高法受惩黑名单 COLUMN NAMES
  public static final String QUALIFIER_NAME_SP_1 = "sexName";
  public static final String QUALIFIER_NAME_SP_2 = "courtName";
  public static final String QUALIFIER_NAME_SP_3 = "age";
  public static final String QUALIFIER_NAME_SP_4 = "buesinessentity";
  public static final String QUALIFIER_NAME_SP_5 = "areaName";
  public static final String QUALIFIER_NAME_SP_6 = "caseCode";
  public static final String QUALIFIER_NAME_SP_7 = "cardnum";
  public static final String QUALIFIER_NAME_SP_8 = "iname";
  public static final String QUALIFIER_NAME_SP_9 = "publishDate";
  public static final String QUALIFIER_NAME_SP_10 = "partyTypeName";
  public static final String QUALIFIER_NAME_SP_11 = "gistCid";
  public static final String QUALIFIER_NAME_SP_12 = "gistUnit";
  public static final String QUALIFIER_NAME_SP_13 = "performance";
  public static final String QUALIFIER_NAME_SP_14 = "disreputTypeName";
  public static final String QUALIFIER_NAME_SP_15 = "regDate";
  public static final String QUALIFIER_NAME_SP_16 = "performedPart";
  public static final String QUALIFIER_NAME_SP_17 = "spider_name";
  public static final String QUALIFIER_NAME_SP_18 = "unperformPart";
  public static final String QUALIFIER_NAME_SP_19 = "duty";
  public static final String QUALIFIER_NAME_SP_20 = "source_page";
  public static final String QUALIFIER_NAME_SP_21 = "source_url";

  // 企业欠税信息 COLUMN NAMES

  // 旅游不良信息 COLUMN NAMES
  public static final String QUALIFIER_NAME_TR_1 = "penalty_reason";
  public static final String QUALIFIER_NAME_TR_2 = "legal_person";
  public static final String QUALIFIER_NAME_TR_3 = "create_date";
  public static final String QUALIFIER_NAME_TR_4 = "description";
  public static final String QUALIFIER_NAME_TR_5 = "entity_name";
  public static final String QUALIFIER_NAME_TR_6 = "penalty_content";
  public static final String QUALIFIER_NAME_TR_7 = "source_page";
  public static final String QUALIFIER_NAME_TR_8 = "source_url";
  public static final String QUALIFIER_NAME_TR_9 = "spider_name";
  public static final String QUALIFIER_NAME_TR_10 = "end_time";
  public static final String QUALIFIER_NAME_TR_11 = "penalty_by";
  public static final String QUALIFIER_NAME_TR_12 = "permit_number";
  public static final String QUALIFIER_NAME_TR_13 = "name";
  public static final String QUALIFIER_NAME_TR_14 = "start_time";

  public static Configuration getHBaseConfiguration() {
    Configuration conf = HBaseConfiguration.create();
    conf.set("hbase.zookeeper.quorum",
            "cdh0");
    conf.set("zookeeper.znode.parent", "/hbase");

    return conf;
  }


}

