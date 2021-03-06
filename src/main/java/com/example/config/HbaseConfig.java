package com.example.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 *
 * Created by heyangyang on 2018/8/31.
 */
@Configuration
public class HbaseConfig {

    @Bean
    public HbaseTemplate hbaseTemplate(@Value("${hbase.zookeeper.quorum}")String quorum,
                                       @Value("${hbase.zookeeper.property.clientPort}")String port){
        HbaseTemplate hbaseTemplate = new HbaseTemplate();
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", quorum);
        conf.set("hbase.zookeeper.property.clientPort",port);
        hbaseTemplate.setConfiguration(conf);
        hbaseTemplate.setAutoFlush(true);
        return hbaseTemplate;
    }


}
