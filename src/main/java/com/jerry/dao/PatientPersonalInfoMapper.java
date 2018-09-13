package com.jerry.dao;

import com.jerry.model.PatientPersonalInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public interface PatientPersonalInfoMapper {
    int deleteByPrimaryKey(String patientid);

    int insert(PatientPersonalInfo record);

    int insertSelective(PatientPersonalInfo record);

    PatientPersonalInfo selectByPrimaryKey(String patientid);

    ArrayList<PatientPersonalInfo> selectAll();

    int selectPersonCount();

    int selectPersonCountByGender(String gender);

    int selectPersonCountByAge(int ageMin,int ageMax);

    int updateByPrimaryKeySelective(PatientPersonalInfo record);

    int updateByPrimaryKey(PatientPersonalInfo record);
}