package com.example.iron.pojo;

import lombok.Data;

@Data
public class RecordDO {

    private int id;

    private int caseId;

    private String groupId;

    private String executeId;

    private String caseName;

    private String isSuccess;

    private String failParam;

    private int statusCode;

}