package org.training.hadoop.hbase.homework;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class GetFromHBase {
  public static void get(Configuration conf) throws IOException {
    Connection connection = null;

    connection = ConnectionFactory.createConnection(conf);

    Table table = connection.getTable(TableName.valueOf(TableInformation.TABLE_NAME));
    Get get = new Get(Bytes.toBytes("blog1"));
    get.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_AGE));
    get.addColumn(Bytes.toBytes(TableInformation.FAMILY_NAME_AUTHOR), Bytes.toBytes(TableInformation.QUALIFIER_NAME_2_NAME));
    Result result = table.get(get);
      List<Cell> cells = result.listCells();
      for(Cell cell: cells){
        System.out.println(Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength()) +" : " + Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()) + " : " + Bytes.toString(CellUtil.cloneValue(cell)));
        System.out.println(cell);
      }

    table.close();
    connection.close();
  }

  public static void main(String[] args) throws IOException {
    GetFromHBase.get(TableInformation.getHBaseConfiguration());
  }
}
