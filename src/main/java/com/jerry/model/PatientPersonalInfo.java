package com.jerry.model;

import java.io.Serializable;

public class PatientPersonalInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String patientid;

    private String name;

    private String gender;

    private Integer age;

    private String telephone;

    private String idcard;

    private String sscard;

    public PatientPersonalInfo(){
        super();
    }

    public PatientPersonalInfo(String patientid, String name, String gender, Integer age, String telephone, String idcard, String sscard) {
        this.patientid = patientid;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.telephone = telephone;
        this.idcard = idcard;
        this.sscard = sscard;
    }

    public String getPatientid() {
        return patientid;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getSscard() {
        return sscard;
    }
}