package com.jerry.model;

import java.util.Date;

public class CaseManagement {
    private String caseid;

    private String patientid;

    private Date logindate;

    private Integer times;

    private String username;

    private String machineid;

    public CaseManagement(){super();}

    public CaseManagement(String caseid, String patientid, Date logindate, Integer times, String username, String machineid) {
        this.caseid = caseid;
        this.patientid = patientid;
        this.logindate = logindate;
        this.times = times;
        this.username = username;
        this.machineid = machineid;
    }

    public String getCaseid() {
        return caseid;
    }

    public String getPatientid() {
        return patientid;
    }

    public Date getLogindate() {
        return logindate;
    }

    public Integer getTimes() {
        return times;
    }

    public String getUsername() {
        return username;
    }

    public String getMachineid() {
        return machineid;
    }
}