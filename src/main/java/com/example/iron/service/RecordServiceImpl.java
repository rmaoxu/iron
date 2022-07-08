package com.example.iron.service;


import com.example.iron.mapper.RecordMapper;
import com.example.iron.pojo.RecordDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordMapper recordMapper;

    @Override
    public boolean insertRecord(RecordDO recordDO) {
        return recordMapper.insertRecord(recordDO)==1;
    }

    @Override
    public List<RecordDO> selectRecordByExecuteId(String executeId) {
        return recordMapper.selectRecordByExecuteId(executeId);
    }

    @Override
    public List<RecordDO> selectRecordByGroupId(int groupId) {
        return null;
    }


}
