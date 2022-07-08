package com.example.iron.controller;

import com.alibaba.fastjson2.JSON;
import com.example.iron.pojo.CaseManageVO;
import com.example.iron.result.ResponseEnum;
import com.example.iron.result.Result;
import com.example.iron.service.CaseManageService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Slf4j
@RestController
public class CaseManageController {

    private final CaseManageService caseManageService;

    public CaseManageController(CaseManageService caseManageService) {
        this.caseManageService = caseManageService;
    }


    @GetMapping("selectAllCase")
    public Result selectAllCase(int pageOn,int pageSize){
        List<CaseManageVO> caseManages = caseManageService.selectAllCase(pageOn, pageSize);
        return Result.ok().data("caseManages",caseManages);
    }

    @GetMapping("selectCaseById")
    public Result selectCaseById(int caseId){
        CaseManageVO caseManageVO = caseManageService.selectCaseById(caseId);
        return Result.ok().data("caseMassage",caseManageVO);
    }

    @PostMapping("insertCase")
    public Result insertCase(String caseManage, MultipartFile csvFile){
        if (ObjectUtils.isEmpty(csvFile) || csvFile.getSize() <= 0){
            log.error("缺少必要参数");
            return Result.setResult(ResponseEnum.CSVFILE_EMPTY);
        }
        try {
            CaseManageVO caseManageVO = JSON.to(CaseManageVO.class, caseManage);
            if (caseManageVO.getUrl().isEmpty()||caseManageVO.getReqMethod().isEmpty()){
                Result.setResult(ResponseEnum.PARAM_EMPTY).message("缺少必要参数");
            }
            caseManageService.insertCase(caseManageVO, csvFile);
        } catch (IOException e) {
            return Result.setResult(ResponseEnum.UPLOAD_ERROR);
        }
        return Result.ok().message("添加成功");
    }

    @PostMapping("updateCase")
    public Result updateCase(String caseId, String caseManage,MultipartFile csvFile) throws IOException {
        CaseManageVO caseManageVO = JSON.to(CaseManageVO.class, caseManage);
        caseManageService.updateCase(caseId,caseManageVO,csvFile);
        if(caseManageService.updateCase(caseId,caseManageVO,csvFile)){
            return Result.ok().message("修改成功");
        }
       return Result.error().message("修改失败");
    }

    @PostMapping("deleteCase")
    public Result deleteCase(int caseId) {
        if (String.valueOf(caseId).equals("")){
            Result.setResult(ResponseEnum.PARAM_EMPTY).message("用例ID为空");
        }
        caseManageService.discardCaseById(caseId);
        if (caseManageService.discardCaseById(caseId)){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }

    @GetMapping("executeCase")
    public Result executeCase(int caseId,String userId){
        caseManageService.executeCaseById(caseId,userId);
        return Result.ok();
    }

}
