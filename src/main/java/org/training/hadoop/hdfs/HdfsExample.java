package org.training.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsExample {

  public static void testMkdirPath(String path) throws Exception {
    FileSystem fs = null;
    try {
      System.out.println("Creating " + path + " on hdfs...");
      Configuration conf = new Configuration();
      // First create a new directory with mkdirs
      Path myPath = new Path(path);
      fs = myPath.getFileSystem(conf);
      fs.getContentSummary(myPath);
      fs.mkdirs(myPath);
      System.out.println("Create " + path + " on hdfs successfully.");
    } catch (Exception e) {
      System.out.println("Exception:" + e);
    } finally {
      if(fs != null)
        fs.close();
    }
  }

    public static String testGetTextBuString(String txtFilePath, Configuration conf) {

        StringBuffer buffer = new StringBuffer();
        FSDataInputStream fsr = null;
        BufferedReader bufferedReader = null;
        String lineTxt = null;
        try {
            FileSystem fs = FileSystem.get(URI.create(txtFilePath),conf);
            fsr = fs.open(new Path(txtFilePath));
            bufferedReader = new BufferedReader(new InputStreamReader(fsr));
            while ((lineTxt = bufferedReader.readLine()) != null) {
                if(lineTxt.split("\t")[0].trim().equals("00067")) {
                    return lineTxt;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try{
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lineTxt;
    }

    public static void ListDirAll(String DirFile) throws IOException {

        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(URI.create(DirFile), conf);

        Path path = new Path(DirFile);

        FileStatus[] status = fs.listStatus(path);

        //方法1
        for(FileStatus f: status) {
            System.out.println(f.getPath().toString());
        }

        //方法2
        Path[] listedPaths = FileUtil.stat2Paths(status);
        for (Path p : listedPaths) {

            System.out.println(p.toString());

        }

    }

    public static void WriteToHDFS(String file, String words) throws IOException, URISyntaxException

    {

        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(URI.create(file), conf);

        Path path = new Path(file);

        FSDataOutputStream out = fs.create(path);   //创建文件


        //两个方法都用于文件写入，好像一般多使用后者
        out.writeBytes(words);
        out.write(words.getBytes("UTF-8"));
        out.close();

        //如果是要从输入流中写入，或是从一个文件写到另一个文件（此时用输入流打开已有内容的文件）

        //可以使用如下IOUtils.copyBytes方法。

        //FSDataInputStream in = fs.open(new Path(args[0]));

        //IOUtils.copyBytes(in, out, 4096, true)        //4096为一次复制块大小，true表示复制完成后关闭流

    }

    public static void testGetSize(String file) throws Exception {
        FileSystem fs = null;
        Configuration conf = new Configuration();

        try {
            fs = FileSystem.get(new URI(file),conf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Path filenamePath = new Path("/test/input");
        try {
            //会根据集群的配置输出，例如我这里输出3G
            System.out.println("SIZE OF THE HDFS DIRECTORY : " + fs.getContentSummary(filenamePath).getSpaceConsumed());
            // 显示实际的输出，例如这里显示 1G
            System.out.println("SIZE OF THE HDFS DIRECTORY : " + fs.getContentSummary(filenamePath).getLength());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fs != null)
                fs.close();
        }
    }

  public static void testDeletePath(String path) throws Exception {
    FileSystem fs = null;
    try {
      System.out.println("Deleting " + path + " on hdfs...");
      Configuration conf = new Configuration();
      Path myPath = new Path(path);
      fs = myPath.getFileSystem(conf);

      fs.delete(myPath, true);
      System.out.println("Deleting " + path + " on hdfs successfully.");
    } catch (Exception e) {
      System.out.println("Exception:" + e);
    } finally {
      if(fs != null)
        fs.close();
    }
  }


  public static void main(String[] args) {
    try {
      //String path = "hdfs:namenodehost:8020/test/mkdirs-test";
      String path = "hdfs://master:9000/test/mkdirs-test";
      testMkdirPath(path);
      //testDeletePath(path);
    } catch (Exception e) {
      System.out.println("Exceptions:" + e);
    }
    System.out.println("timestamp:" + System.currentTimeMillis());
  }
}
