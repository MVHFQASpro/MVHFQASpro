package com.jerry.model;

import java.util.Date;

public class PatientDiseaseInfo {
    private String patientid;

    private String healthyhand;

    private String unhealthyhand;

    private String handedness;

    private String stroketype;

    private String strokearea;

    private String diseasecourse;

    private String brunnstormupperlimb;

    private String brunnstormhand;

    private String mtbendelbow;

    private String mtbendwrist;

    private String mtbendfinger;

    private String mtstretchelbow;

    private String mtstretchwrist;

    private String mtstretchfinger;

    private String mtstretchfront;

    private String mtstretchbehind;

    private String fuglmeyer;

    private String mss;

    private String wmft;

    private Date accidentdate;

    private Integer countofdisease;

    private String overview;

    public PatientDiseaseInfo(){super();}

    public PatientDiseaseInfo(String patientid, String healthyhand, String unhealthyhand, String handedness, String stroketype, String strokearea, String diseasecourse, String brunnstormupperlimb, String brunnstormhand, String mtbendelbow, String mtbendwrist, String mtbendfinger, String mtstretchelbow, String mtstretchwrist, String mtstretchfinger, String mtstretchfront, String mtstretchbehind, String fuglmeyer, String mss, String wmft, Date accidentdate, Integer countofdisease, String overview) {
        this.patientid = patientid;
        this.healthyhand = healthyhand;
        this.unhealthyhand = unhealthyhand;
        this.handedness = handedness;
        this.stroketype = stroketype;
        this.strokearea = strokearea;
        this.diseasecourse = diseasecourse;
        this.brunnstormupperlimb = brunnstormupperlimb;
        this.brunnstormhand = brunnstormhand;
        this.mtbendelbow = mtbendelbow;
        this.mtbendwrist = mtbendwrist;
        this.mtbendfinger = mtbendfinger;
        this.mtstretchelbow = mtstretchelbow;
        this.mtstretchwrist = mtstretchwrist;
        this.mtstretchfinger = mtstretchfinger;
        this.mtstretchfront = mtstretchfront;
        this.mtstretchbehind = mtstretchbehind;
        this.fuglmeyer = fuglmeyer;
        this.mss = mss;
        this.wmft = wmft;
        this.accidentdate = accidentdate;
        this.countofdisease = countofdisease;
        this.overview = overview;
    }

    public String getPatientid() {
        return patientid;
    }

    public String getHealthyhand() {
        return healthyhand;
    }

    public String getUnhealthyhand() {
        return unhealthyhand;
    }

    public String getHandedness() {
        return handedness;
    }

    public String getStroketype() {
        return stroketype;
    }

    public String getStrokearea() {
        return strokearea;
    }

    public String getDiseasecourse() {
        return diseasecourse;
    }

    public String getBrunnstormupperlimb() {
        return brunnstormupperlimb;
    }

    public String getBrunnstormhand() {
        return brunnstormhand;
    }

    public String getMtbendelbow() {
        return mtbendelbow;
    }

    public String getMtbendwrist() {
        return mtbendwrist;
    }

    public String getMtbendfinger() {
        return mtbendfinger;
    }

    public String getMtstretchelbow() {
        return mtstretchelbow;
    }

    public String getMtstretchwrist() {
        return mtstretchwrist;
    }

    public String getMtstretchfinger() {
        return mtstretchfinger;
    }

    public String getMtstretchfront() {
        return mtstretchfront;
    }

    public String getMtstretchbehind() {
        return mtstretchbehind;
    }

    public String getFuglmeyer() {
        return fuglmeyer;
    }

    public String getMss() {
        return mss;
    }

    public String getWmft() {
        return wmft;
    }

    public Date getAccidentdate() {
        return accidentdate;
    }

    public Integer getCountofdisease() {
        return countofdisease;
    }

    public String getOverview() {
        return overview;
    }
}