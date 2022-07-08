package com.example.iron.controller;

import com.example.iron.pojo.RecordDO;
import com.example.iron.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("selectRecordByCaseId")
    public List<RecordDO> selectRecordByExecuteId(String executeId){
        return recordService.selectRecordByExecuteId(executeId);
    }


}
