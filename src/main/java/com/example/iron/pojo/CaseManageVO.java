package com.example.iron.pojo;


import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
@Data
public class CaseManageVO implements Serializable {

    private int id;

    private String url;

    private String reqMethod;

    private Map<String,String> reqHeader;

    private Map<String,String> reqParam;

    private String jsonTemp;

    private String fileName;

}
