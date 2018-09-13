package com.jerry.dao;

import com.jerry.model.CaseManagement;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseManagementMapper {
    int deleteByPrimaryKey(String caseid);

    int insert(CaseManagement record);

    int selectUsingTimesByDate(String dateLower,String dateUpper);

    int insertSelective(CaseManagement record);

    CaseManagement selectByPrimaryKey(String caseid);

    int updateByPrimaryKeySelective(CaseManagement record);

    int updateByPrimaryKey(CaseManagement record);
}