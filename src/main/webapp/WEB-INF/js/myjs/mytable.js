$(function () {
    $('#btSearch').click(function () {


        $.ajax({
            type: "post",
            dataType: "json",
            url: "/getPatientPersonalInfo",
            data: {

            },
            success: function (msg) {

                // $('#thid1').innerText="success";
                // $('#thid1').innerHTML="success";
                // console.log("#thid1");
                //
                // var columnList = [];      //显示列对应的json字段
                //
                // var columnStr = "Id,Name,Code,Age,Pwd";
                //
                // colArr = columnStr.split(',');
                // for (var i = 0; i < colArr.length; i++) {
                //     var obj = {};
                //     obj['data'] = colArr[i];
                //     columnList.push(obj);
                // }
                //
                // $(document).ready(function() {
                //     $('#example').dataTable().fnClearTable(true);
                //     $('#example').dataTable().fnDestroy();
                //     $('#example').dataTable({
                //         retrieve: true,
                //         columns: columnList,
                //         data:    columnList
                //     });
                //     console.log($('#example'));
                // });

                // var strHead="<tr>"+

                // "<th>患者ID</th>"+
                //
                // "<th>姓名</th>"+
                //
                // "<th>性别</th>"+
                //
                // "<th>年龄</th>"+
                //
                // "<th>联系方式</th>"+
                //
                // "<th>身份证号</th>"+
                //
                // "<th>社保卡号</th>"+
                //
                // "</tr>";

                //window.document.getElementById("example").innerHTML=strHead;

                //$("#example").dataTable().fnDraw(true);
                //$('#example').dataTable().fnHeaderCallback;
                //------------------------------------------------------------------------------------------
                    console.log(msg);
                    var str = "";
                    var data = msg;
                    //$('#example').dataTable().fnClearTable();
                     for (var i in data) {
                    //     // str = "<tr class=\"tr_"+i+">" +
                    //     //     "<td>" + data[i].patientid + "</td>" +
                    //     //     "<td>" + data[i].name + "</td>" +
                    //     //     "<td>" + data[i].gender + "</td>" +
                    //     //     "<td>" + data[i].age + "</td>" +
                    //     //     "<td>" + data[i].telephone + "</td>" +
                    //     //     // "<td>" + data[i].idcard + "</td>" +
                    //     //     // "<td>" + data[i].sscard + "</td>" +
                    //     //     "</tr>";
                    //
                         $('#example').dataTable().fnAddData([data[i].patientid,data[i].name,data[i].gender
                             ,data[i].age,data[i].telephone,data[i].idcard, data[i].sscard],true);
                     }
                console.log($('#example'));
                //---------------------------------------------------------------------------------------------
                    // tbody.innerHTML = str;
                // $('#example').dataTable().fnAddData(str);
                // window.document.getElementById("tbody-result-patientpersonalinfo").innerHTML=(str);
            },
            error: function () {
                alert("查询失败")
            }
        });
    });
});