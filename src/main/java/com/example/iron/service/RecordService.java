package com.example.iron.service;

import com.example.iron.pojo.RecordDO;

import java.util.List;

public interface RecordService {


    boolean insertRecord(RecordDO recordDO);

    List<RecordDO> selectRecordByExecuteId(String executeId);

    List<RecordDO> selectRecordByGroupId(int groupId);
}
