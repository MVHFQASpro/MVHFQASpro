package com.jerry.dao;

import com.jerry.model.PatientDiseaseInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PatientDiseaseInfoMapper {
    int deleteByPrimaryKey(String patientid);

    int insert(PatientDiseaseInfo record);

    int insertSelective(PatientDiseaseInfo record);

    PatientDiseaseInfo selectByPrimaryKey(String patientid);

    ArrayList<PatientDiseaseInfo> selectAll();

    int selectPersonCountByUnhealthyhand(String hand);

    int selectPersonCountByStrokeType(String strokeType);

    int selectPersonCountByDiseaseCourse(String diseaseCourse);

    int selectPersonCountByDiseaseCount(int lower,int upper);

    int updateByPrimaryKeySelective(PatientDiseaseInfo record);

    int updateByPrimaryKeyWithBLOBs(PatientDiseaseInfo record);

    int updateByPrimaryKey(PatientDiseaseInfo record);
}