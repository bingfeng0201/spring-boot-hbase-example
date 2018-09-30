package com.example.entry;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 *
 * Created by heyangyang on 2018/8/31.
 */
public class Member implements Serializable{

    private static final long serialVersionUID = -8371920313549444051L;
    private Integer memId;

    private String mobile;

    private String shopCode;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }
}
