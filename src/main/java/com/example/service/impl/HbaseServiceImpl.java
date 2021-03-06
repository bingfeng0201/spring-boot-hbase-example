package com.example.service.impl;

import com.example.entry.Member;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by heyangyang on 2018/8/31.
 */
public class HbaseServiceImpl {

    @Resource(name = "htemplate")
    private HbaseTemplate htemplate;

    // 获取表中指定行，列簇，列的值
    public String get(String tableName, String rowName, String familyName,
                      String qualifier) {
        return htemplate.get(tableName, rowName, familyName, qualifier,
                new RowMapper<String>() {
                    public String mapRow(Result result, int rowNum)
                            throws Exception {
                        List<Cell> ceList = result.listCells();
                        String res = "";
                        if (ceList != null && ceList.size() > 0) {
                            for (Cell cell : ceList) {
                                res = Bytes.toString(cell.getValueArray(),
                                        cell.getValueOffset(),
                                        cell.getValueLength());
                            }
                        }
                        return res;
                    }
                });
    }
    // 浏览表中某些行的信息，例子中指定的起始行和结束行
    public List<Member> find(String tableName, String startRow,
                             String stopRow) {
        // 使用Scan可以实现过滤的功能
      return null;
    }
    // 获取一行的数据，并封装成vo
    public Member get(String tableName, String rowName) {
       return null;
    }
    // 将值插入表中指定的行，列簇，列中
    public void put(final String tableName, final String rowKey,
                    final String familyName, final String column, final String value) {
        htemplate.put(tableName, rowKey, familyName, column, value.getBytes());
    }


}
