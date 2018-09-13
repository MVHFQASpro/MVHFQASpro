package com.jerry.dao;

import com.jerry.model.HealthyHandAction_Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HealthyHandAction_ResultMapper {
    int deleteByPrimaryKey(String actionoperationid);

    int insert(HealthyHandAction_Result record);

    int insertSelective(HealthyHandAction_Result record);

    HealthyHandAction_Result selectByPrimaryKey(String actionoperationid);

    ArrayList<HealthyHandAction_Result> selectAll();

    int updateByPrimaryKeySelective(HealthyHandAction_Result record);

    int updateByPrimaryKey(HealthyHandAction_Result record);
}