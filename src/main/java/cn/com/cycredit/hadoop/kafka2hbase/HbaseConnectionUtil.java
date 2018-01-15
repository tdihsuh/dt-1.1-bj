package cn.com.cycredit.hadoop.kafka2hbase;

import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HbaseConnectionUtil {
    private static Connection connection;

    /**
     * getconnection
     * @return
     * @throws IOException
     */
    public static synchronized Connection getConnection() throws IOException {
        if (connection != null) {
            return connection;
        }
        return ConnectionFactory.createConnection(TableInformationCY.getHBaseConfiguration());
    }

    /**
     * close connection
     * @return
     * @throws IOException
     */
    public static boolean closeConnection(){
            //close
        try {
            if (connection != null){
                connection.close();
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
