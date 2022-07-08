package com.example.iron.pojo;

import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
public class CaseManageDO implements Serializable {

    private int id;

    private String executeId;

    private String url;

    private String reqMethod;

    private String reqHeader;

    private String contentType;

    private String reqParam;

    private String jsonTemp;

    private String fileName;

    private String filePath;

    private String createUser;

    private String isAvailble;

    private Date createTime;

    private Date updateTime;

}