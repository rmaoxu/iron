package com.example.iron.asyn;

import com.alibaba.fastjson2.JSON;
import com.example.iron.pojo.CaseManageDTO;
import com.example.iron.pojo.RecordDO;
import com.example.iron.service.RecordService;
import com.example.iron.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    RecordService recordService;

    //异步多线程调用
    @Async("asyncServiceExecutor")
    public void executeGetAsync(CaseManageDTO caseManageDTO) {
        HttpResponse response = HttpClientUtil.getHttps(caseManageDTO.getUrl(),caseManageDTO.getReqParam());
        log.info(caseManageDTO.toString());
        RecordDO recordDO = new RecordDO();
        recordDO.setExecuteId(caseManageDTO.getExecuteId());
        recordDO.setCaseId(caseManageDTO.getId());
        int statusCode = response.getStatusLine().getStatusCode();
        recordDO.setStatusCode(statusCode);
        if (statusCode == 200){
            recordDO.setIsSuccess("1");
        }else {
            recordDO.setIsSuccess("0");
            recordDO.setFailParam(JSON.toJSONString(caseManageDTO.getReqParam()));
        }

        recordService.insertRecord(recordDO);
        log.info(recordDO.toString());
    }

    @Override
    @Async("asyncServiceExecutor")
    public void executePostAsync(CaseManageDTO caseManageDTO) {
        HttpResponse response = HttpClientUtil.postJson(caseManageDTO.getUrl(), caseManageDTO.getJsonStr());
        log.info(caseManageDTO.toString());
        RecordDO recordDO = new RecordDO();
        recordDO.setExecuteId(caseManageDTO.getExecuteId());
        recordDO.setCaseId(caseManageDTO.getId());
        int statusCode = response.getStatusLine().getStatusCode();
        recordDO.setStatusCode(statusCode);
        if (statusCode == 200){
            recordDO.setIsSuccess("1");
        }else {
            recordDO.setIsSuccess("0");
            recordDO.setFailParam(caseManageDTO.getJsonStr());
        }
        recordService.insertRecord(recordDO);
        log.info(recordDO.toString());

    }
}
