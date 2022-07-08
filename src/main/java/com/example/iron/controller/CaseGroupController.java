package com.example.iron.controller;


import com.example.iron.result.Result;

import com.example.iron.service.CaseGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaseGroupController {

    @Autowired
    private CaseGroupService caseGroupService;

    @PostMapping("caseGroupExcute")
    public Result caseGroupExcute(String groupID,String userId){

        caseGroupService.caseGroupExcute(groupID,userId);

        return Result.ok();
    }

    @PostMapping("caseGroupCreate")
    public Result caseGroupCreate(String groupName,String userId,List<String> caseList){

        caseGroupService.caseGroupCreate(groupName,userId,caseList);

        return Result.ok();
    }

    @PostMapping("caseGroupDelete")
    public Result caseGroupDelete(String groupID){

        caseGroupService.caseGroupDelete(groupID);

        return Result.ok();
    }

    @PostMapping("caseGroupUpdate")
    public Result caseGroupUpdate(String groupID,String groupName, List<String> caseList){

        caseGroupService.caseGroupUpdate(groupID,groupName,caseList);

        return Result.ok();
    }






}
