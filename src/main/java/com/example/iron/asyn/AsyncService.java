package com.example.iron.asyn;

import com.example.iron.pojo.CaseManageDO;
import com.example.iron.pojo.CaseManageDTO;

public interface AsyncService {
    /**
     * 执行异步任务
     **/
    void executeGetAsync(CaseManageDTO caseManageDTO);

    void executePostAsync(CaseManageDTO caseManageDTO);
}
