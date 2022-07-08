package com.example.iron.mapper;

import com.example.iron.pojo.CaseManageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CaseManageMapper {

    int insert(CaseManageDO record);

    List<CaseManageDO> selectAll(int pageOn,int pageSize);

    int update(CaseManageDO caseManageDO);

    CaseManageDO selectCaseById(int caseId);

    int discardCaseById(int caseID);
}