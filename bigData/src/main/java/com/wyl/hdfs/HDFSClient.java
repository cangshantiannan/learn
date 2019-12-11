package com.wyl.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;
import java.io.IOException;

public class HDFSClient {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        //这里指定使用的是 hdfs文件系统
        conf.set("fs.defaultFS", "hdfs://192.168.23.70:8020");
        //创建HDFS连接
        /**
         *方式1
         */
        System.setProperty("HADOOP_USER_NAME", "root");
        FileSystem fs = FileSystem.get(conf);

        /**
         *方式2
         */
        //FileSystem fs = FileSystem.get(new URI("hdfs://master:9000"),conf,"root");

        /**
         * 输出流到HDFS
         */
        //使用Stream的形式操作HDFS，这是更底层的方式
        FSDataOutputStream outputStream = fs.create(new Path("/2.txt"), true);

        /**
         * 从本地输入流
         */
        FileInputStream inputStream = new FileInputStream("E:\\c++project\\vmbkdkp\\CMakeLists.txt");
        byte buffer[] = new byte[2048];
        Long SINE = 137438953472L;
        Long currFileSize = 0L;
        Long readSize = 0L;
        while (-1 != readSize) {
            readSize = new Long(inputStream.read(buffer));
            currFileSize += readSize;
            outputStream.write(buffer);
            outputStream.flush();
        }
        System.out.println(currFileSize);
        fs.close();
    }
}
