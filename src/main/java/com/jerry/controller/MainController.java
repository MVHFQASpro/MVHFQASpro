package com.jerry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jerry.model.HealthyHandAction_Result;
import com.jerry.model.PatientDiseaseInfo;
import com.jerry.model.PatientPersonalInfo;
import com.jerry.model.UnhealthyHandAction_Result;
import com.jerry.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {

    public static Logger logger=Logger.getLogger(MainController.class);

    @Autowired
    private UserService userService;

//    @RequestMapping("")
//    public String  welcomeIndex() throws Exception{
//        return "redirect:WEB-INF/html/charts.html";
//    }

    @RequestMapping("/json")
    public List<String> json(){
        return userService.getAllUsernames();
    }

    @RequestMapping("/getAll")
    public String getAll(){
        return String.valueOf(userService.showAllUsers().size());
    }

    @RequestMapping("/jsptest")
    public String jsptest(){
        return "jsptest";
    }

    @RequestMapping(value = "/buttons",method = RequestMethod.GET)
    public String buttons(){
        return "buttons";
    }

    @RequestMapping("/charts")
    public String charts(){
        return "charts";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @RequestMapping("/form-controls")
    public String form_controls(){
        return "form-controls";
    }

    @RequestMapping("/gallery-with-filter")
    public String gallery_with_filter(){
        return "gallery-with-filter";
    }

    @RequestMapping("/image-gallery")
    public String image_gallery(){
        return "image-gallery";
    }

    @RequestMapping("/notifications")
    public String notifications(){
        return "notifications";
    }

    @RequestMapping("/table")
    public String table(){
        return "table";
    }

    @RequestMapping("/table_PatientPersonalInfo")
    public String table_PatientPersonalInfo(){
        return "table_PatientPersonalInfo";
    }

    @RequestMapping("/getPatientPersonalInfo")
    //@RequestBody 将json对象转成java对象
    // @ResponseBody 表示返回的是json对象
    public @ResponseBody ArrayList<PatientPersonalInfo> getPatientPersonalInfo(){
        ArrayList<PatientPersonalInfo> arrayPatientPersonalInfo=userService.showAllUsers();
        logger.info("showAllUsers:"+arrayPatientPersonalInfo.get(0).getName()+"<<");
        return arrayPatientPersonalInfo;
    }

    @RequestMapping("/table_PatientDiseaseInfo")
    public String table_PatientDiseaseInfo(){
        return "table_PatientDiseaseInfo";
    }

    @RequestMapping("/getPatientDiseaseInfo")
    public @ResponseBody ArrayList<PatientDiseaseInfo> getPatientDiseaseInfo(){
        ArrayList<PatientDiseaseInfo> arrayPatientDiseaseInfo=userService.getAllPatientDiseaseInfo();
        return arrayPatientDiseaseInfo;
    }

    @RequestMapping("/table_HHA_R")
    public String table_HHA_R(){
        return "table_HHA_R";
    }

    @RequestMapping("/getHHAR")
    public @ResponseBody ArrayList<HealthyHandAction_Result> getHHAR(){
        ArrayList<HealthyHandAction_Result> arrayHealthyHandAction_Result=userService.getAllHHAR();
        return arrayHealthyHandAction_Result;
    }

    @RequestMapping("/table_UHHA_R")
    public String table_UHHA_R(){
        return "table_UHHA_R";
    }

    @RequestMapping("/getUHHAR")
    public @ResponseBody ArrayList<UnhealthyHandAction_Result> getUHHAR(){
        ArrayList<UnhealthyHandAction_Result> arrayUnhealthyHandAction_Result=userService.getAllUHHAR();
        return arrayUnhealthyHandAction_Result;
    }

    @RequestMapping("/typography")
    public String typography(){
        return "typography";
    }


//    @RequestMapping("/uploadForm")
//    public String uploadForm(){ return "uploadForm"; }

    //上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public void upload(HttpServletRequest request,HttpServletResponse response) throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("video");

        String filename = multipartRequest.getParameter("filename");
        String handType = multipartRequest.getParameter("handtype");
        String actionName = multipartRequest.getParameter("actionname");
        String HHfilename = multipartRequest.getParameter("HHfilename");

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            //String path = request.getServletContext().getRealPath("/WechatVideo/");
            String path = "/usr/local/tomcat/apache-tomcat-7.0.82/webapps/WechatVideo/";
            //上传文件名
            //String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));

//            float resultVal = -1.0f;
//            if("healthy".equals(handType)) {
//                //TODO call calculation script
//                String workPath = "/usr/local/tomcat/apache-tomcat-7.0.82/webapps/MVHFQASpro/WechatVideo/";
//                String shFile = actionName+".sh";
//                String resultFile = "result.txt";
//                //String sourceFile1 = HHfilename;
//                String sourceFile2 = filename;
//                Process process = null;
//                String command0 = "chmod 777 " + workPath + "\n";
//                process = Runtime.getRuntime().exec(command0);
//                process.waitFor();
//                String command1 = "chmod 777 " + workPath + shFile + "\n";
//                process = Runtime.getRuntime().exec(command1);
//                process.waitFor();
//                String command2 = workPath + shFile + " " + workPath + sourceFile2 + "\n";
//                process = Runtime.getRuntime().exec(command2);
//                process.waitFor();
//
////                Runtime run = Runtime.getRuntime();
////                File wd = new File(workPath);
////                System.out.println(wd);
////                Process proc = null;
////                try {
////                    proc = run.exec("/bin/bash", null, wd);
////                }catch (IOException e) {
////                    e.printStackTrace();
////                }
////                if (proc != null) {
////                    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
////                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
////                    out.println("chmod 777 " + workPath);
////                    out.println("chmod 777 " + workPath + shFile);
////                    out.println(workPath + shFile + " " + workPath + sourceFile2);
////                    //out.println("exit");
////                    try {
////                        String line;
////                        while ((line = in.readLine()) != null) {
////                            System.out.println(line);
////                        }
////                        proc.waitFor();
////                        in.close();
////                        out.close();
////                        proc.destroy();
////                    }catch (Exception e) {
////                        e.printStackTrace();
////                    }
////                }
//            }
//            if("unhealthy".equals(handType)) {
//                //TODO call calculation script
//                String workPath = "/usr/local/tomcat/apache-tomcat-7.0.82/webapps/MVHFQASpro/WechatVideo/";
//                String shFile = actionName+".sh";
//                String resultFile = "result.txt";
//                String sourceFile1 = HHfilename;
//                String sourceFile2 = filename;
//                Process process = null;
//                String command0 = "chmod 777 " + workPath + "\n";
//                process = Runtime.getRuntime().exec(command0);
//                process.waitFor();
//                String command1 = "chmod 777 " + workPath + shFile + "\n";
//                process = Runtime.getRuntime().exec(command1);
//                process.waitFor();
//                String command2 = workPath+ shFile + " " + workPath + sourceFile1 + " " + workPath + sourceFile2 + "\n";
//                process = Runtime.getRuntime().exec(command2);
//                process.waitFor();
//
////                Runtime run = Runtime.getRuntime();
////                File wd = new File(workPath);
////                System.out.println(wd);
////                Process proc = null;
////                try {
////                    proc = run.exec("/bin/bash", null, wd);
////                }catch (IOException e) {
////                    e.printStackTrace();
////                }
////                if (proc != null) {
////                    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
////                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
////                    out.println("chmod 777 " + workPath);
////                    out.println("chmod 777 " + workPath + shFile);
////                    out.println(workPath+ shFile + " " + workPath + sourceFile1 + " " + workPath + sourceFile2);
////                    try {
////                        String line;
////                        while ((line = in.readLine()) != null) {
////                            System.out.println(line);
////                        }
////                        proc.waitFor();
////                        in.close();
////                        out.close();
////                        proc.destroy();
////                    }catch (Exception e) {
////                        e.printStackTrace();
////                    }
////                }

//                File f1 = new File(workPath + resultFile);
//                Reader reader = new InputStreamReader(new FileInputStream(f1));
//                int ch;
//                String resultStr = "";
//                while ((ch = reader.read()) != -1) {
//                    resultStr += (char) ch;
//                }
//                resultVal = Float.valueOf(resultStr.toString());
//            }


            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            HashMap<String, Object> res = new HashMap<String, Object>();
            //TODO 返回
            res.put("UploadStatus", true);
//            if("unhealthy".equals(handType)) {
//                res.put("Score", resultVal);
//            }
            printWriter.write(JSON.toJSONString(res));
            printWriter.flush();
        } else {
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            HashMap<String, Object> res = new HashMap<String, Object>();
            res.put("UploadStatus", false);
            printWriter.write(JSON.toJSONString(res));
            printWriter.flush();
        }

    }

    @RequestMapping(value = "/score",method = RequestMethod.GET)
    public void score(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String userNumber = request.getParameter("userNumber");
        String actionName = request.getParameter("actionName");
        String workPath = "/usr/local/tomcat/apache-tomcat-7.0.82/webapps/WechatVideo/";
        String shFile = actionName+".sh";
        String resultFile = userNumber+"_"+actionName+"_result.txt";
        String sourceFile1 = userNumber+"_"+actionName+"0.mp4";
        String sourceFile2 = userNumber+"_"+actionName+"1.mp4";
        String command0 = "chmod 777 " + workPath + "\n";
        Process process = null;
        process = Runtime.getRuntime().exec(command0);
        process.waitFor();
        String command1 = "chmod 777 " + workPath + shFile + "\n";
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();
        String command2 ="/bin/bash " + workPath+ shFile + " " + workPath + sourceFile1 + " " + workPath + sourceFile2 + "\n";
        process = Runtime.getRuntime().exec(command2);
        process.waitFor();
        File f1 = new File(workPath + resultFile);
        Reader reader = new InputStreamReader(new FileInputStream(f1));
        int ch;
        String resultStr = "";
        while ((ch = reader.read()) != -1) {
            resultStr += (char) ch;
        }
        float resultVal = -1.0f;
        resultVal = Float.valueOf(resultStr.toString());
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("scoreStatus", true);
        res.put("Score", resultVal);
        printWriter.write(JSON.toJSONString(res));
        printWriter.flush();
    }

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public void regist(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String userName = request.getParameter("userName");
        userName =  new String(userName.getBytes("iso8859-1"),"utf-8");
        String userNumber = request.getParameter("userNumber");

        String path = "/usr/local/tomcat/apache-tomcat-7.0.82/webapps/WechatData/";
        String fileName=userNumber+".txt";

        File file = new File(path+fileName);

        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> res = new HashMap<String, Object>();

        if(file.exists()){
            res.put("registStatus", false);
            res.put("illustrate", "user is exist!");
        }else{
            file.createNewFile();
            HashMap<String,String> mapData = new HashMap<String,String>();
            mapData.put("userName", userName);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mapData);
            fos.close();
            res.put("registStatus", true);
        }
        printWriter.write(JSON.toJSONString(res));
        printWriter.flush();
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String userNumber = request.getParameter("userNumber");
        String path = "/usr/local/tomcat/apache-tomcat-7.0.82/webapps/WechatData/";
        String fileName=userNumber+".txt";
        File file = new File(path+fileName);

        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> res = new HashMap<String, Object>();

        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String,String> mapData = new HashMap<String,String>();
            mapData = (HashMap<String,String>) ois.readObject();
            fis.close();
            res.put("loginStatus", true);
            res.put("userName", mapData.get("userName"));
        }else{
            res.put("loginStatus", false);
            res.put("illustrate", "user is not exist!");
        }
        printWriter.write(JSON.toJSONString(res));
        printWriter.flush();
    }

    @RequestMapping(value = "/DBFileUpload",method = RequestMethod.POST)
    public void dbFileUpload(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String pathName = "//var//opt//mssql//mvhandDbFile//";
        String logFile = "dbUpdateLog.txt";
        File dbLogFile = new File(pathName+logFile);
        if(!dbLogFile.exists()){
            dbLogFile.createNewFile();
        }
        OutputStream os = new FileOutputStream(dbLogFile,true);

        System.out.println("DB File Uploading ......");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        if(!file.isEmpty()) {
            File filepath = new File(pathName,file.getOriginalFilename());
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(pathName + File.separator + file.getOriginalFilename()));

            String dbName = file.getOriginalFilename().substring(0,file.getOriginalFilename().indexOf("."));
            String shFile = "restore.sh";
            Process process = null;
            String command1 = "chmod 777 " + pathName +shFile;
            process = Runtime.getRuntime().exec(command1);
            process.waitFor();
            String command2 = pathName + shFile + " " + dbName;
            process = Runtime.getRuntime().exec(command2);
            if(process.waitFor()==0){
                os.write((new Date().toString()+"update db " +dbName + "succee!!!\r\n").getBytes());
            }else{
                os.write((new Date().toString()+"update db " +dbName + "fail!!!\r\n").getBytes());
            }

            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            HashMap<String, Object> res = new HashMap<String, Object>();
            res.put("dbUploadStates", true);
            printWriter.write(JSON.toJSONString(res));
            printWriter.flush();
        }else{
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            HashMap<String, Object> res = new HashMap<String, Object>();
            res.put("dbUploadStates", false);
            printWriter.write(JSON.toJSONString(res));
            printWriter.flush();
        }
    }

    @RequestMapping("/statistics")
    public String statistics(){
        return "statistics";
    }

//    @RequestMapping("/getPersonCount")
//    public @ResponseBody int getPersonCount(){
//       int personCount = userService.getPersonCount();
//        logger.info("personCount:"+personCount+"|");
//        return personCount;
//    }

    @RequestMapping("/getPersonCountByGender")
    public @ResponseBody Map<String,Integer> getPersonCountByGender(){
        int personCount = userService.getPersonCount();
        int personCountMale = userService.getPersonCountByGender("男");
        int personCountFemale = userService.getPersonCountByGender("女");
        logger.info("personCountMale|personCountFemale:"+personCountMale+"|"+personCountFemale);
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("Male",personCountMale);
        resultMap.put("Female",personCountFemale);
        resultMap.put("Total",personCount);
        return resultMap;
    }

    @RequestMapping("/getPersonCountByAge")
    public @ResponseBody Map<String,Integer> getPersonCountByAge(){
        int personCount = userService.getPersonCount();
        int personCount00_40 = userService.getPersonCountByAge(0,40);
        int personCount40_50 = userService.getPersonCountByAge(40,50);
        int personCount50_60 = userService.getPersonCountByAge(50,60);
        int personCount60_70 = userService.getPersonCountByAge(60,70);
        int personCount70_1000 = userService.getPersonCountByAge(70,1000);
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("b00t40",personCount00_40);
        resultMap.put("b40t50",personCount40_50);
        resultMap.put("b50t60",personCount50_60);
        resultMap.put("b60t70",personCount60_70);
        resultMap.put("b70t1000",personCount70_1000);
        resultMap.put("Total",personCount);
        return resultMap;
    }

    @RequestMapping("/getPersonCountByUnhealthyhand")
    public @ResponseBody Map<String,Integer> getPersonCountByUnhealthyhand(){
        int personCount = userService.getPersonCount();
        int personCountLeft = userService.getPersonCountByUnhealthyhand("左");
        int personCountRight = userService.getPersonCountByUnhealthyhand("右");
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("Total",personCount);
        resultMap.put("UHandLeft",personCountLeft);
        resultMap.put("UHandRight",personCountRight);
        return resultMap;
    }

    @RequestMapping("/getPersonCountByStrokeType")
    public @ResponseBody Map<String,Integer> getPersonCountByStrokeType(){
        int personCount = userService.getPersonCount();
        int personCountNGS = userService.getPersonCountByStrokeType("脑梗死");
        int personCountNCX = userService.getPersonCountByStrokeType("脑出血");
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("Total",personCount);
        resultMap.put("NGS",personCountNGS);
        resultMap.put("NCX",personCountNCX);
        return resultMap;
    }

    @RequestMapping("/getPersonCountByDiseaseCourse")
    public @ResponseBody Map<String,Integer> getPersonCountByDiseaseCourse(){
        int personCount = userService.getPersonCount();
        int personCountJ0t2W = userService.getPersonCountByDiseaseCourse("急性期（0-2周）");
        int personCountJ0t3M = userService.getPersonCountByDiseaseCourse("急性期（0-3个月）");
        int personCountYJ3t6M = userService.getPersonCountByDiseaseCourse("亚急性期（3-6个月）");
        int personCountH2Wt6M = userService.getPersonCountByDiseaseCourse("恢复期（2周-6个月）");
        int personCountM6tXM = userService.getPersonCountByDiseaseCourse("慢性期（6个月以上）");
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("Total",personCount);
        resultMap.put("J0t2W",personCountJ0t2W);
        resultMap.put("J0t3M",personCountJ0t3M);
        resultMap.put("YJ3t6M",personCountYJ3t6M);
        resultMap.put("H2Wt6M",personCountH2Wt6M);
        resultMap.put("M6tXM",personCountM6tXM);
        return resultMap;
    }

    @RequestMapping("/getPersonCountByDiseaseCount")
    public @ResponseBody Map<String,Integer> getPersonCountByDiseaseCount(){
        int personCount = userService.getPersonCount();
        int DiseaseCount0t1 = userService.getPersonCountByDiseaseCount(0,1);
        int DiseaseCount1tX = userService.getPersonCountByDiseaseCount(1,10000);
        //int DiseaseCount2tX = userService.getPersonCountByDiseaseCount(2,10000);
        Map<String,Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("Total",personCount);
        resultMap.put("DC0t1",DiseaseCount0t1);
        resultMap.put("DC1tX",DiseaseCount1tX);
        return resultMap;
    }

    @RequestMapping("/getUseingTimesByDate")
    public @ResponseBody JSONObject getPersonIncreaseByDate() throws Exception{
        int personCount = userService.getPersonCount();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dfWithoutD = new SimpleDateFormat("yyyy-MM");
        String nowDate = df.format(cal.getTime());
        String upperDate = df.format(cal.getTime());
        Calendar calUpper = cal;
        Calendar calLower = cal;
        calLower.set(Calendar.DATE,1);
        String lowerDate = df.format(calLower.getTime());

        JSONObject resultJson = new JSONObject();
        JSONObject tempJson = new JSONObject();
        resultJson.put("Total",personCount);

        tempJson.put("name",dfWithoutD.format(cal.getTime()));
        tempJson.put("value",userService.getUsingTimesByDate(lowerDate,nowDate));
        resultJson.put("nowDate",tempJson);

        for(int i=1;i<=8;i++){
            calUpper = calLower;
            upperDate = df.format(calUpper.getTime());
            calLower.add(Calendar.MONTH,-1);
            lowerDate = df.format(calLower.getTime());
            tempJson = new JSONObject();
            tempJson.put("name",dfWithoutD.format(calLower.getTime()));
            tempJson.put("value",userService.getUsingTimesByDate(lowerDate,upperDate));
            resultJson.put("nowDateLast"+String.valueOf(i)+"M",tempJson);
        }

        calUpper = calLower;
        upperDate = df.format(calUpper.getTime());
        tempJson = new JSONObject();
        tempJson.put("name",dfWithoutD.format(calUpper.getTime())+"before");
        calLower.set(Calendar.YEAR,1900);
        calLower.set(Calendar.MONTH,0);
        calLower.set(Calendar.DATE,1);
        lowerDate = df.format(calLower.getTime());
        tempJson.put("value",userService.getUsingTimesByDate(lowerDate,upperDate));
        resultJson.put("nowDateLastXM",tempJson);

        logger.info("Json");
        logger.info(resultJson.toJSONString());
        return resultJson;
    }


}
