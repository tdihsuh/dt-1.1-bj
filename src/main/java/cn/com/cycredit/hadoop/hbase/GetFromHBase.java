package cn.com.cycredit.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class GetFromHBase {
  public static void get(Configuration conf) throws IOException {
    Connection connection = null;

    connection = ConnectionFactory.createConnection(conf);

    Table table = connection.getTable(TableName.valueOf(TableInformation.TABLE_NAME));
    System.out.println(Bytes.toBytes("郑州名景遮阳技术有限公司"));
    Get get = new Get(Bytes.toBytes("郑州名景遮阳技术有限公司"));
    get.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_1), Bytes.toBytes(TableInformation.QUALIFIER_NAME_1_1));
    Result result = table.get(get);
    while (result.advance()) {
      System.out.println(result.current());
    }
    table.close();
    connection.close();
  }

  public static void main(String[] args) throws IOException {
    GetFromHBase.get(TableInformation.getHBaseConfiguration());
  }
}
