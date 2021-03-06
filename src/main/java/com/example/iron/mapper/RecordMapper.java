package com.example.iron.mapper;

import com.example.iron.pojo.RecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RecordMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated Fri Jul 08 02:02:32 CST 2022
     */
    int insertRecord(RecordDO recordDO);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated Fri Jul 08 02:02:32 CST 2022
     */
    List<RecordDO> selectRecordByExecuteId(String executeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated Fri Jul 08 02:02:32 CST 2022
     */
    List<RecordDO> selectRecordByGroupId();

}