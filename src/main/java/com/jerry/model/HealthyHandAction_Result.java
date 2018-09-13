package com.jerry.model;

import java.util.Date;

public class HealthyHandAction_Result {
    private String actionoperationid;

    private String patientid;

    private Integer actionid;

    private String caseid;

    private Integer actiontimes;

    private String tokenvalue1Res;

    private String tokenvalue2Res;

    private String tokenvalue3Res;

    private String tokenvalue4Res;

    private String tokenvalue5Res;

    private String hVideopath;

    private Date hResCreatetime;

    private String column1;

    public HealthyHandAction_Result(){super();}

    public HealthyHandAction_Result(String actionoperationid, String patientid, Integer actionid, String caseid, Integer actiontimes, String tokenvalue1Res, String tokenvalue2Res, String tokenvalue3Res, String tokenvalue4Res, String tokenvalue5Res, String hVideopath, Date hResCreatetime, String column1) {
        this.actionoperationid = actionoperationid;
        this.patientid = patientid;
        this.actionid = actionid;
        this.caseid = caseid;
        this.actiontimes = actiontimes;
        this.tokenvalue1Res = tokenvalue1Res;
        this.tokenvalue2Res = tokenvalue2Res;
        this.tokenvalue3Res = tokenvalue3Res;
        this.tokenvalue4Res = tokenvalue4Res;
        this.tokenvalue5Res = tokenvalue5Res;
        this.hVideopath = hVideopath;
        this.hResCreatetime = hResCreatetime;
        this.column1 = column1;
    }

    public String getActionoperationid() {
        return actionoperationid;
    }

    public String getPatientid() {
        return patientid;
    }

    public Integer getActionid() {
        return actionid;
    }

    public String getCaseid() {
        return caseid;
    }

    public Integer getActiontimes() {
        return actiontimes;
    }

    public String getTokenvalue1Res() {
        return tokenvalue1Res;
    }

    public String getTokenvalue2Res() {
        return tokenvalue2Res;
    }

    public String getTokenvalue3Res() {
        return tokenvalue3Res;
    }

    public String getTokenvalue4Res() {
        return tokenvalue4Res;
    }

    public String getTokenvalue5Res() {
        return tokenvalue5Res;
    }

    public String gethVideopath() {
        return hVideopath;
    }

    public Date gethResCreatetime() {
        return hResCreatetime;
    }

    public String getColumn1() {
        return column1;
    }
}