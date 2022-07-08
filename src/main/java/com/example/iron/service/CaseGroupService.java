package com.example.iron.service;

import java.util.List;

public interface CaseGroupService {

    void caseGroupExcute(String groupID,String userId);

    void caseGroupCreate(String groupName, String userId, List<String> caseList);

    void caseGroupDelete(String groupID);

    void caseGroupUpdate(String groupID,String groupName, List<String> caseList);
}