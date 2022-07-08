package com.example.iron.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class CaseManageDTO implements Serializable {

    private int id;

    private String groupId;

    private String executeId;

    private String url;

    private String reqMethod;

    private Map<String,String> reqHeader;

    private String contentType;

    private Map<String,Object> reqParam;

    private String jsonStr;

    private String fileName;

    private String filePath;

}
