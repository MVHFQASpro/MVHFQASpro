package com.jerry.controller;

import com.jerry.controller.MainController;

import com.jerry.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath*:/spring-mvc.xml"})
//public class MainControllerTest extends AbstractJUnit4SpringContextTests {
public class MainControllerTest {

    private MainController mainController;

//    @Autowired
//    private UserService userService;

    @Before
    public void setUp() throws Exception {
        mainController = new MainController();
    }

    @Test
    public void json() throws Exception {
        //mainController = new MainController();
//        List<String> users = new ArrayList<String>();
//        users.add("MarK");
//        users.add("MarK");
//        users.add("Ken");
//        users.add("Fowafolo");
//        assertEquals("pass",users,mainController.json());
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void jsptest() throws Exception {
    }

    @Test
    public void buttons() throws Exception {
    }

    @Test
    public void charts() throws Exception {
    }

    @Test
    public void dashboard() throws Exception {
    }

    @Test
    public void form_controls() throws Exception {
    }

    @Test
    public void gallery_with_filter() throws Exception {
    }

    @Test
    public void image_gallery() throws Exception {
    }

    @Test
    public void notifications() throws Exception {
    }

    @Test
    public void table() throws Exception {
    }

    @Test
    public void table_PatientPersonalInfo() throws Exception {
    }

    @Test
    public void getPatientPersonalInfo() throws Exception {
    }

    @Test
    public void table_PatientDiseaseInfo() throws Exception {
    }

    @Test
    public void getPatientDiseaseInfo() throws Exception {
    }

    @Test
    public void table_HHA_R() throws Exception {
    }

    @Test
    public void getHHAR() throws Exception {
    }

    @Test
    public void table_UHHA_R() throws Exception {
    }

    @Test
    public void getUHHAR() throws Exception {
    }

    @Test
    public void typography() throws Exception {
    }

    @Test
    public void upload() throws Exception {
    }

    @Test
    public void score() throws Exception {
    }

    @Test
    public void regist() throws Exception {
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void dbFileUpload() throws Exception {
    }

    @Test
    public void statistics() throws Exception {
    }

    @Test
    public void getPersonCountByGender() throws Exception {
    }

    @Test
    public void getPersonCountByAge() throws Exception {
    }

    @Test
    public void getPersonCountByUnhealthyhand() throws Exception {
    }

    @Test
    public void getPersonCountByStrokeType() throws Exception {
    }

    @Test
    public void getPersonCountByDiseaseCourse() throws Exception {
    }

    @Test
    public void getPersonCountByDiseaseCount() throws Exception {
    }

    @Test
    public void getPersonIncreaseByDate() throws Exception {
    }

}