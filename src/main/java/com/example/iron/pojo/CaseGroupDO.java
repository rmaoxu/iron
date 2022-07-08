package com.example.iron.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class CaseGroupDO implements Serializable {

    private String groupName;

    private String groupId;

    private String groupCase;

    private Date createTime;

    private String groupMember;

}