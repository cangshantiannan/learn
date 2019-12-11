package com.wyl.hive;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.sql.ResultSet;

public class HiveClientKerberos {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    // 注意：这里的principal是固定不变的，其指的hive服务所对应的principal,而不是用户所对应的principal
    private static String url = "jdbc:hive2://192.168.23.71:10000/default;principal=hive/slave.hdp71.com@DSG.COM";
    private static String sql = "";
    private static ResultSet res;

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("hadoop.security.authentication", "Kerberos");
        System.setProperty("java.security.krb5.conf", "E:\\wyl\\learn\\bigData\\src\\main\\resources\\kerberos\\hive\\krb5.conf");
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab("hive/slave.hdp71.com@DSG.COM", "E:\\wyl\\learn\\bigData\\src\\main\\resources\\kerberos\\hive\\hive.service.keytab");
    }
}
