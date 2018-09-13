package com.jerry.service;

import com.jerry.dao.*;
import com.jerry.model.HealthyHandAction_Result;
import com.jerry.model.PatientDiseaseInfo;
import com.jerry.model.PatientPersonalInfo;
import com.jerry.model.UnhealthyHandAction_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private PatientPersonalInfoMapper patientPersonalInfoMapper;
    @Resource
    private PatientDiseaseInfoMapper patientDiseaseInfoMapper;
    @Resource
    private HealthyHandAction_ResultMapper healthyHandAction_resultMapper;
    @Resource
    private UnhealthyHandAction_ResultMapper unhealthyHandAction_resultMapper;
    @Resource
    private CaseManagementMapper caseManagementMapper;

    public List<String> getAllUsernames() {
        List<String> users = new ArrayList<String>();
        users.add("MarK");
        users.add("MarK");
        users.add("Ken");
        users.add("Fowafolo");
        return users;
    }

    public ArrayList<PatientPersonalInfo> showAllUsers() {
        return patientPersonalInfoMapper.selectAll();
    }

    public ArrayList<PatientDiseaseInfo> getAllPatientDiseaseInfo() {
        return patientDiseaseInfoMapper.selectAll();
    }

    public ArrayList<HealthyHandAction_Result> getAllHHAR(){return healthyHandAction_resultMapper.selectAll();}

    public ArrayList<UnhealthyHandAction_Result> getAllUHHAR(){return unhealthyHandAction_resultMapper.selectAll();}

    public int getPersonCount(){return patientPersonalInfoMapper.selectPersonCount();}

    public int getPersonCountByGender(String gender){return patientPersonalInfoMapper.selectPersonCountByGender(gender);}

    public int getPersonCountByAge(int ageMin,int ageMax){return patientPersonalInfoMapper.selectPersonCountByAge(ageMin,ageMax);}

    public int getPersonCountByUnhealthyhand(String hand){return patientDiseaseInfoMapper.selectPersonCountByUnhealthyhand(hand);}

    public int getPersonCountByStrokeType(String strokeType){return patientDiseaseInfoMapper.selectPersonCountByStrokeType(strokeType);}

    public int getPersonCountByDiseaseCourse(String diseaseCourse){return patientDiseaseInfoMapper.selectPersonCountByDiseaseCourse(diseaseCourse);}

    public int getPersonCountByDiseaseCount(int lower,int upper){return patientDiseaseInfoMapper.selectPersonCountByDiseaseCount(lower,upper);}

    public int getUsingTimesByDate(String dateLower,String dateUpper){return caseManagementMapper.selectUsingTimesByDate(dateLower,dateUpper);}


}
