package com.example.iron.service;

import com.example.iron.asyn.AsyncService;
import com.example.iron.mapper.CaseManageMapper;
import com.example.iron.pojo.CaseManageDO;
import com.example.iron.pojo.CaseManageDTO;
import com.example.iron.pojo.CaseManageVO;
import com.example.iron.util.CMPojoUtil;
import com.example.iron.util.CsvUtil;
import com.example.iron.util.UploadCsvUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class CaseManageServiceImpl implements CaseManageService {

    @Autowired
    private CaseManageMapper caseManageMapper;


    @Autowired
    private AsyncService asyncService;


    @Override
    public List<CaseManageVO> selectAllCase(int pageOn, int pageSize) {
        List<CaseManageDO> caseManageDOS = caseManageMapper.selectAll(pageOn, pageSize);
        List<CaseManageVO> caseManageVOs = new ArrayList<>();
        for (CaseManageDO caseManageDO : caseManageDOS) {
            caseManageVOs.add(CMPojoUtil.doToVo(caseManageDO));
        }
        return caseManageVOs;
    }

    @Override
    public boolean insertCase(CaseManageVO caseManageVO, MultipartFile csvFile) throws IOException {
        String fileName = String.valueOf(System.currentTimeMillis());
        String filePath = UploadCsvUtil.uploadCsv(fileName, csvFile);
        CaseManageDO caseManageDO = CMPojoUtil.voToDo(caseManageVO);
        caseManageDO.setFilePath(filePath);
        caseManageDO.setFileName(fileName);
        caseManageDO.setIsAvailble("1");
        return caseManageMapper.insert(caseManageDO) == 1;
    }

    @Override
    public boolean updateCase(String caseId, CaseManageVO caseManageVO, MultipartFile csvFile) throws IOException {
        //TODO  更新用例    未测试
        CaseManageDO caseManageDO = CMPojoUtil.voToDo(caseManageVO);
        if (ObjectUtils.isEmpty(csvFile) || csvFile.getSize() <= 0){
            return caseManageMapper.update(caseManageDO)==1;
        }
        String fileName = caseManageVO.getFileName();
        UploadCsvUtil.uploadCsv(fileName, csvFile);
        return caseManageMapper.update(caseManageDO)==1;
    }

    @Override
    public boolean discardCaseById(int caseID) {
        return caseManageMapper.discardCaseById(caseID) == 1;
    }

    @Override
    public CaseManageVO selectCaseById(int caseId) {
        CaseManageDO caseManageDO = caseManageMapper.selectCaseById(caseId);
        return CMPojoUtil.doToVo(caseManageDO);
    }

    @Override
    public void executeCaseById(int caseId, String userId) {
        CaseManageDO caseManageDO = caseManageMapper.selectCaseById(caseId);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        caseManageDO.setExecuteId(uuid);
        log.info(caseManageDO.toString());
            try {
                List<Map<String, String>> dataList = CsvUtil.getCsvData(caseManageDO.getFilePath());
                if (caseManageDO.getReqMethod().equalsIgnoreCase("GET")){
                    for (Map<String, String> dataMap : dataList) {
                        CaseManageDTO caseManageDTO = CMPojoUtil.doToDto(caseManageDO);
                        Map<String, Object> reqParam = caseManageDTO.getReqParam();
                        reqParam.putAll(dataMap);
                        asyncService.executeGetAsync(caseManageDTO);
                    }
                    return;
                }
                if (caseManageDO.getReqMethod().equalsIgnoreCase("POST")) {
                    for (Map<String, String> dataMap : dataList) {
                        CaseManageDTO caseManageDTO = CMPojoUtil.doToDto(caseManageDO);
                        String jsonstr = CsvUtil.jsonStrParse(caseManageDO.getJsonTemp(), dataMap);
                        caseManageDTO.setJsonStr(jsonstr);
                        asyncService.executePostAsync(caseManageDTO);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}

