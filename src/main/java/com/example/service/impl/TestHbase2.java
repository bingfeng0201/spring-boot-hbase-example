package com.example.service.impl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

/**
 * Created by heyangyang on 2018/9/3.
 */
public class TestHbase2 {

    public static Configuration config;
    static {
        config = HBaseConfiguration.create();
        config
                .addResource(new Path(
                        "C:\\Users\\hyy\\Desktop\\hadoop\\hbase-site.xml"));
    }

    /**
     * 创建表
     *
     * @throws IOException
     * @param tableName
     *            表名
     * @param columns
     *            列族
     */
    public static void createTable(String tableName, String[] columns)
            throws IOException {
        HBaseAdmin Hbaseadmin = new HBaseAdmin(config);
        if (Hbaseadmin.tableExists(tableName)) {
            System.out.println("表已经存在！");
        } else {
            HTableDescriptor desc = new HTableDescriptor(tableName);
            for (String column : columns) {
                desc.addFamily(new HColumnDescriptor(column));
            }
            Hbaseadmin.createTable(desc);
            System.out.println("表创建成功！");
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        System.setProperty("hadoop.home.dir", "C:\\Users\\hyy\\Desktop\\hadop\\hadoop-2.6.5");
        // TODO Auto-generated method stub
        String tableName = "test_db2";
        String[] columns = {"c1","c2","c3"};
        createTable(tableName,columns);
    }
}
