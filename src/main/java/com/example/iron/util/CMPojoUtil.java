package com.example.iron.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.iron.pojo.CaseManageDO;
import com.example.iron.pojo.CaseManageDTO;
import com.example.iron.pojo.CaseManageVO;

import java.util.Map;

public class CMPojoUtil {




    public static CaseManageDO voToDo(CaseManageVO caseManageVO){
        CaseManageDO caseManageDO = new CaseManageDO();
        caseManageDO.setId(caseManageVO.getId());
        caseManageDO.setUrl(caseManageVO.getUrl());
        caseManageDO.setReqMethod(caseManageVO.getReqMethod());
        caseManageDO.setReqHeader(JSON.toJSONString(caseManageVO.getReqHeader()));
        caseManageDO.setReqParam(JSON.toJSONString(caseManageVO.getReqParam()));
        caseManageDO.setJsonTemp(caseManageVO.getJsonTemp());
        caseManageDO.setFileName(caseManageVO.getFileName());
        return caseManageDO;

    }


    public static CaseManageVO doToVo( CaseManageDO caseManageDO){
        CaseManageVO caseManageVO = new CaseManageVO();
        caseManageVO.setId(caseManageDO.getId());
        caseManageVO.setUrl(caseManageDO.getUrl());
        caseManageVO.setReqMethod(caseManageDO.getReqMethod());
        caseManageVO.setReqHeader(JSONObject.parseObject(caseManageDO.getReqHeader(), Map.class));
        caseManageVO.setReqParam(JSONObject.parseObject(caseManageDO.getReqParam(), Map.class));
        caseManageVO.setJsonTemp(caseManageDO.getJsonTemp());
        caseManageVO.setFileName(caseManageDO.getFileName());
        return caseManageVO;
    }

    public static CaseManageDTO doToDto( CaseManageDO caseManageDO){
        CaseManageDTO caseManageDTO = new CaseManageDTO();
        caseManageDTO.setId(caseManageDO.getId());
        caseManageDTO.setExecuteId(caseManageDO.getExecuteId());
        caseManageDTO.setUrl(caseManageDO.getUrl());
        caseManageDTO.setReqMethod(caseManageDO.getReqMethod());
        caseManageDTO.setReqHeader(JSONObject.parseObject(caseManageDO.getReqHeader(), Map.class));
        caseManageDTO.setReqParam(JSONObject.parseObject(caseManageDO.getReqParam(), Map.class));
        caseManageDTO.setFileName(caseManageDO.getFileName());
        caseManageDTO.setFilePath(caseManageDO.getFilePath());
        return caseManageDTO;

    }
}
