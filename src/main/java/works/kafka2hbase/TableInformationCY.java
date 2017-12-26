package works.kafka2hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class TableInformationCY {

  public static final String TABLE_NAME = "enterprise:enterprise_credit";

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
  public static final String QUALIFIER_NAME_AP_1   = "spider_name";
  public static final String QUALIFIER_NAME_AP_2 = "create_date";
  public static final String QUALIFIER_NAME_AP_3 = "why_listed_in";
  public static final String QUALIFIER_NAME_AP_4 = "company_detail_pageUrl";
  public static final String QUALIFIER_NAME_AP_5 = "source_page";
  public static final String QUALIFIER_NAME_AP_6 = "administration";
  public static final String QUALIFIER_NAME_AP_7 = "company_name";
  public static final String QUALIFIER_NAME_AP_8 = "annals_year";
  public static final String QUALIFIER_NAME_AP_9 = "year_listed_in";
  public static final String QUALIFIER_NAME_AP_10 = "notice_id";

  // 银监局行政处罚 COLUMN NAMES
  public static final String QUALIFIER_NAME_CB_1 = "spider_name";
  public static final String QUALIFIER_NAME_CB_2 = "create_date";
  public static final String QUALIFIER_NAME_CB_3 = "entity_name";
  public static final String QUALIFIER_NAME_CB_4 = "title";
  public static final String QUALIFIER_NAME_CB_5 = "pun_org";
  public static final String QUALIFIER_NAME_CB_6 = "decision";
  public static final String QUALIFIER_NAME_CB_7 = "entity_type";
  public static final String QUALIFIER_NAME_CB_8 = "source_page";
  public static final String QUALIFIER_NAME_CB_9 = "org_level";

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
  public static final String QUALIFIER_NAME_CD_10 = "spider_name";
  public static final String QUALIFIER_NAME_CD_11 = "deadLine";
  public static final String QUALIFIER_NAME_CD_12 = "orgNum";
  public static final String QUALIFIER_NAME_CD_13 = "fianceNum";
  public static final String QUALIFIER_NAME_CD_14 = "regAddress";
  public static final String QUALIFIER_NAME_CD_15 = "punishType";
  public static final String QUALIFIER_NAME_CD_16 = "businessRegNum";

  // 保监会行政处罚 COLUMN NAMES
  public static final String QUALIFIER_NAME_CI_1 = "spider_name";
  public static final String QUALIFIER_NAME_CI_2 = "create_date";
  public static final String QUALIFIER_NAME_CI_3 = "ent_name";
  public static final String QUALIFIER_NAME_CI_4 = "title";
  public static final String QUALIFIER_NAME_CI_5 = "case_no";
  public static final String QUALIFIER_NAME_CI_6 = "source_url";
  public static final String QUALIFIER_NAME_CI_7 = "content";
  public static final String QUALIFIER_NAME_CI_8 = "org_level";
  public static final String QUALIFIER_NAME_CI_9 = "pub_date";

  // 建筑市场违法欺骗 COLUMN NAMES
  public static final String QUALIFIER_NAME_CM_1 = "administration";
  public static final String QUALIFIER_NAME_CM_2 = "credit_icon";
  public static final String QUALIFIER_NAME_CM_3 = "credit_recordBody";
  public static final String QUALIFIER_NAME_CM_4 = "credit_recordBodyDetailUrl";
  public static final String QUALIFIER_NAME_CM_5 = "credit_recordBodyTag";
  public static final String QUALIFIER_NAME_CM_6 = "credit_recordNum";
  public static final String QUALIFIER_NAME_CM_7 = "notice_id";
  public static final String QUALIFIER_NAME_CM_8 = "reason";
  public static final String QUALIFIER_NAME_CM_9 = "recordTime";
  public static final String QUALIFIER_NAME_CM_10 = "result";
  public static final String QUALIFIER_NAME_CM_11 = "resultTag";
  public static final String QUALIFIER_NAME_CM_12 = "source_url";
  public static final String QUALIFIER_NAME_CM_13 = "spider_name";

  // 证监会行政处罚 COLUMN NAMES
  public static final String QUALIFIER_NAME_CS_1 = "spider_name";
  public static final String QUALIFIER_NAME_CS_2 = "create_date";
  public static final String QUALIFIER_NAME_CS_3 = "title";
  public static final String QUALIFIER_NAME_CS_4 = "gender";
  public static final String QUALIFIER_NAME_CS_5 = "memo";
  public static final String QUALIFIER_NAME_CS_6 = "source_page";
  public static final String QUALIFIER_NAME_CS_7 = "org_level";
  public static final String QUALIFIER_NAME_CS_8 = "person_name";
  public static final String QUALIFIER_NAME_CS_9 = "pub_date";

  // 海关失信企业 COLUMN NAMES
  public static final String QUALIFIER_NAME_CU_1 = "penalty_reason";
  public static final String QUALIFIER_NAME_CU_2 = "legal_person";
  public static final String QUALIFIER_NAME_CU_3 = "create_date";
  public static final String QUALIFIER_NAME_CU_4 = "name";
  public static final String QUALIFIER_NAME_CU_5 = "penalty_content";
  public static final String QUALIFIER_NAME_CU_6 = "source_page";
  public static final String QUALIFIER_NAME_CU_7 = "source_url";
  public static final String QUALIFIER_NAME_CU_8 = "spider_name";
  public static final String QUALIFIER_NAME_CU_9 = "end_time";
  public static final String QUALIFIER_NAME_CU_10 = "penalty_by";
  public static final String QUALIFIER_NAME_CU_11 = "permit_number";
  public static final String QUALIFIER_NAME_CU_12 = "start_time";
  public static final String QUALIFIER_NAME_CU_13 = "description";

  // 食药监局黑名单 COLUMN NAMES
  public static final String QUALIFIER_NAME_FM_1 = "spider_name";
  public static final String QUALIFIER_NAME_FM_2 = "pub_mode";
  public static final String QUALIFIER_NAME_FM_3 = "create_date";
  public static final String QUALIFIER_NAME_FM_4 = "ent_name";
  public static final String QUALIFIER_NAME_FM_5 = "title";
  public static final String QUALIFIER_NAME_FM_6 = "check_org";
  public static final String QUALIFIER_NAME_FM_7 = "legal_man";
  public static final String QUALIFIER_NAME_FM_8 = "source_page";
  public static final String QUALIFIER_NAME_FM_9 = "problem";
  public static final String QUALIFIER_NAME_FM_10 = "source_url";
  public static final String QUALIFIER_NAME_FM_11 = "address";
  public static final String QUALIFIER_NAME_FM_12 = "check_date";
  public static final String QUALIFIER_NAME_FM_13 = "operation";
  public static final String QUALIFIER_NAME_FM_14 = "medicine_certno";
  public static final String QUALIFIER_NAME_FM_15 = "pub_date";
  public static final String QUALIFIER_NAME_FM_16 = "credit_code";
  public static final String QUALIFIER_NAME_FM_17 = "check_reason";

  // 政府采购失信 COLUMN NAMES
  public static final String QUALIFIER_NAME_GP_1 = "spider_name";
  public static final String QUALIFIER_NAME_GP_2 = "punishDate";
  public static final String QUALIFIER_NAME_GP_3 = "create_date";
  public static final String QUALIFIER_NAME_GP_4 = "entity_name";
  public static final String QUALIFIER_NAME_GP_5 = "source_page";
  public static final String QUALIFIER_NAME_GP_6 = "compAddress";
  public static final String QUALIFIER_NAME_GP_7 = "source_url";
  public static final String QUALIFIER_NAME_GP_8 = "orgNum";
  public static final String QUALIFIER_NAME_GP_9 = "punishResult";
  public static final String QUALIFIER_NAME_GP_10 = "punishBy";
  public static final String QUALIFIER_NAME_GP_11 = "uncreditContent";
  public static final String QUALIFIER_NAME_GP_12 = "exeDepartment";

  // 重大税收违法 COLUMN NAMES
  public static final String QUALIFIER_NAME_MT_1 = "case_nature";
  public static final String QUALIFIER_NAME_MT_2 = "create_date";
  public static final String QUALIFIER_NAME_MT_3 = "legal_man_identify_num";
  public static final String QUALIFIER_NAME_MT_4 = "legal_man_name";
  public static final String QUALIFIER_NAME_MT_5 = "legal_man_sex";
  public static final String QUALIFIER_NAME_MT_6 = "org_num";
  public static final String QUALIFIER_NAME_MT_7 = "reg_address";
  public static final String QUALIFIER_NAME_MT_8 = "source_page";
  public static final String QUALIFIER_NAME_MT_9 = "source_url";
  public static final String QUALIFIER_NAME_MT_10 = "spider_name";
  public static final String QUALIFIER_NAME_MT_11 = "tax_name";
  public static final String QUALIFIER_NAME_MT_12 = "tax_num";
  public static final String QUALIFIER_NAME_MT_13 = "uncredit_content";

  // 企业经营异常 COLUMN NAMES
  public static final String QUALIFIER_NAME_OE_1 = "case_no";
  public static final String QUALIFIER_NAME_OE_2 = "create_date";
  public static final String QUALIFIER_NAME_OE_3 = "data_id";
  public static final String QUALIFIER_NAME_OE_4 = "data_source";
  public static final String QUALIFIER_NAME_OE_5 = "del_flag";
  public static final String QUALIFIER_NAME_OE_6 = "entity_name";
  public static final String QUALIFIER_NAME_OE_7 = "op_flag";
  public static final String QUALIFIER_NAME_OE_8 = "punish_date";
  public static final String QUALIFIER_NAME_OE_9 = "punish_org";
  public static final String QUALIFIER_NAME_OE_10 = "punish_reason";
  public static final String QUALIFIER_NAME_OE_11 = "source_url";
  public static final String QUALIFIER_NAME_OE_12 = "spider_name";

  // 高法受惩黑名单 COLUMN NAMES
  public static final String QUALIFIER_NAME_SP_1 = "case_id";
  public static final String QUALIFIER_NAME_SP_2 = "card_no";
  public static final String QUALIFIER_NAME_SP_3 = "entity_name";
  public static final String QUALIFIER_NAME_SP_4 = "gender";
  public static final String QUALIFIER_NAME_SP_5 = "age";
  public static final String QUALIFIER_NAME_SP_6 = "represent_name";
  public static final String QUALIFIER_NAME_SP_7 = "court";
  public static final String QUALIFIER_NAME_SP_8 = "province";
  public static final String QUALIFIER_NAME_SP_9 = "case_no";
  public static final String QUALIFIER_NAME_SP_10 = "entity_type";
  public static final String QUALIFIER_NAME_SP_11 = "status";
  public static final String QUALIFIER_NAME_SP_12 = "memo";
  public static final String QUALIFIER_NAME_SP_13 = "pub_date";
  public static final String QUALIFIER_NAME_SP_14 = "obligation";
  public static final String QUALIFIER_NAME_SP_15 = "case_date";
  public static final String QUALIFIER_NAME_SP_16 = "gist_id";
  public static final String QUALIFIER_NAME_SP_17 = "gist_unit";
  public static final String QUALIFIER_NAME_SP_18 = "performed_part";
  public static final String QUALIFIER_NAME_SP_19 = "unperform_part";
  public static final String QUALIFIER_NAME_SP_20 = "create_date";
  public static final String QUALIFIER_NAME_SP_21 = "update_date";

  // 企业欠税信息 COLUMN NAMES
  public static final String QUALIFIER_NAME_TA_1 = "entity_name";
  public static final String QUALIFIER_NAME_TA_2 = "tax_no";
  public static final String QUALIFIER_NAME_TA_3 = "legal_man";
  public static final String QUALIFIER_NAME_TA_4 = "identity_code";
  public static final String QUALIFIER_NAME_TA_5 = "address";
  public static final String QUALIFIER_NAME_TA_6 = "tax_type";
  public static final String QUALIFIER_NAME_TA_7 = "tax_balance";
  public static final String QUALIFIER_NAME_TA_8 = "current_amount";
  public static final String QUALIFIER_NAME_TA_9 = "ent_area";
  public static final String QUALIFIER_NAME_TA_10 = "create_date";
  public static final String QUALIFIER_NAME_TA_11 = "update_date";
  public static final String QUALIFIER_NAME_TA_12 = "del_flag";
  public static final String QUALIFIER_NAME_TA_13 = "tax_org";
  public static final String QUALIFIER_NAME_TA_14 = "data_source";
  public static final String QUALIFIER_NAME_TA_15 = "file_name";
  public static final String QUALIFIER_NAME_TA_16 = "pub_date";

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
  public static final String QUALIFIER_NAME_TR_13 = "start_time";

  public static Configuration getHBaseConfiguration() {
    Configuration conf = HBaseConfiguration.create();
    conf.set("hbase.zookeeper.quorum",
            "cdh0");
    conf.set("zookeeper.znode.parent", "/hbase");

    return conf;
  }


}

