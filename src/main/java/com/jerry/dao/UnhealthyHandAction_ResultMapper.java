package com.jerry.dao;

import com.jerry.model.UnhealthyHandAction_Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UnhealthyHandAction_ResultMapper {
    int deleteByPrimaryKey(String actionoperationid);

    int insert(UnhealthyHandAction_Result record);

    int insertSelective(UnhealthyHandAction_Result record);

    UnhealthyHandAction_Result selectByPrimaryKey(String actionoperationid);

    ArrayList<UnhealthyHandAction_Result> selectAll();

    int updateByPrimaryKeySelective(UnhealthyHandAction_Result record);

    int updateByPrimaryKey(UnhealthyHandAction_Result record);
}