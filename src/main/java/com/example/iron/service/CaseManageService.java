package com.example.iron.service;

import com.example.iron.pojo.CaseManageDO;
import com.example.iron.pojo.CaseManageVO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface CaseManageService {

    List<CaseManageVO> selectAllCase(int pageOn, int pageSize);

    boolean insertCase(CaseManageVO caseManageVO, MultipartFile csvFile) throws IOException;

    boolean updateCase(String caseId, CaseManageVO requestInfo, MultipartFile csvFile) throws IOException;

    boolean discardCaseById(int caseID);

    CaseManageVO selectCaseById(int caseId);

    void executeCaseById(int caseId, String userId) ;
}
