package com.jerry.service;

import com.jerry.model.HealthyHandAction_Result;
import com.jerry.model.PatientDiseaseInfo;
import com.jerry.model.PatientPersonalInfo;
import com.jerry.model.UnhealthyHandAction_Result;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public List<String> getAllUsernames();

    public ArrayList<PatientPersonalInfo> showAllUsers();

    public ArrayList<PatientDiseaseInfo> getAllPatientDiseaseInfo();

    public ArrayList<HealthyHandAction_Result> getAllHHAR();

    public ArrayList<UnhealthyHandAction_Result> getAllUHHAR();

    public int getPersonCount();

    public int getPersonCountByGender(String gender);

    public int getPersonCountByAge(int ageMin,int ageMax);

    public int getPersonCountByUnhealthyhand(String hand);

    public int getPersonCountByStrokeType(String strokeType);

    public int getPersonCountByDiseaseCourse(String diseaseCourse);

    public int getPersonCountByDiseaseCount(int lower,int upper);

    public int getUsingTimesByDate(String dateLower,String dateUpper);

}
