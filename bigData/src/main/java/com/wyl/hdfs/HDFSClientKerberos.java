package com.wyl.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.FileInputStream;
import java.io.IOException;

public class HDFSClientKerberos {
    public static void main(String[] args) throws IOException {
        System.setProperty("java.security.krb5.conf", "C:\\Users\\Administrator\\Desktop\\krb5\\krb5.conf");
        Configuration conf = new Configuration();
//        conf.addResource(new Path("D:\\HDFS-test\\hdfs-site.xml"));
        //kerberos 登录验证
        /**
         *  配置认证方式
         */
        conf.set("hadoop.security.authentication", "kerberos");

        /**
         * namenode的地址和端口
         */
        conf.set("fs.default.name", "hdfs://192.168.23.70:8020");
        UserGroupInformation.setConfiguration(conf);
        try {
            UserGroupInformation.loginUserFromKeytab("hdfs-dev_cluster@DSG.COM", "C:\\Users\\Administrator\\Desktop\\krb5\\hdfs.headless.keytab");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("HADOOP_USER_NAME", "root");
        FileSystem fs = FileSystem.get(conf);

        FSDataOutputStream outputStream = fs.create(new Path("/2.txt"), true); //输出流到HDFS
        FileInputStream inputStream = new FileInputStream("E:\\c++project\\vmbkdkp\\CMakeLists.txt"); //从本地输入流。
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
