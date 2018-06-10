<%--
  Created by IntelliJ IDEA.
  User: Tong
  Date: 2018/5/31
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../statics/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../statics/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../statics/easyui/demo/demo.css">
    <script type="text/javascript" src="../statics/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../statics/easyui/jquery.easyui.min.js"></script>
</head>

welcome!!
<h2>Basic DataGrid</h2>
<p>The DataGrid is created from markup, no JavaScript code needed.</p>
<div style="margin:20px 0;"></div>

<table id="dg" title="My Users" class="easyui-datagrid" style="width:550px;height:250px"
       url=""
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>

        <th data-options="field:'id',checkbox:'true'"></th>
        <th field="sname" width="50">姓名</th>
        <th field="ssex" width="50">性别</th>
        <th field="sage" width="50">年龄</th>
        <th field="sdept" width="50">专业</th>
        <th field="pwd" width="50">密码</th>
    </tr>
    </thead>
    <c:forEach var="student" items="${student}">
        <tr>
            <td>${student.sno}</td>
            <td>${student.sname}</td>
            <td>${student.ssex}</td>
            <td>${student.sage}</td>
            <td>${student.sdept}</td>
            <td>${student.pwd}</td>
        </tr>
    </c:forEach>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
<div id="dlg1" closed="true" class="easyui-dialog" title="新增" data-options="iconCls:'icon-save'"
     style="width:500px;height:400px;padding:10px">
    <form id="ff" class="easyui-form" method="get" data-options="novalidate:true">
        <table cellpadding="7">
            <tr>
                <td>学号:</td>
                <td><input class="easyui-textbox" type="text" name="sno" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input class="easyui-textbox" type="text" name="sname" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input class="easyui-textbox" type="text" name="ssex" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input class="easyui-textbox" type="text" name="sage" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>专业:</td>
                <td><input class="easyui-textbox" type="text" name="sdept" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input class="easyui-textbox" type="text" name="pwd" data-options="required:true"></input></td>
            </tr>
        </table>
    </form>
    <div id="bb">
        <a href="#" class="easyui-linkbutton" id="save">Save</a>
        <a href="#" class="easyui-linkbutton" id="close" onclick="$('#dlg1').dialog('close')">Close</a>
    </div>
</div>
</div>
</div>



</body>
<script>
    var isClick = "";
    function newUser() {

        isClick = "add";
        $("#ff").form("clear");
        $('#dlg1').dialog('open').dialog('setTitle', '添加新用户');
        $("#save").click(function () {
        $.ajax({
            url: "/students/add?type=0",
            method: "get",
            data: $("#ff").serializeArray(),
            success: function (data) {
                if (data == "success") {
                    alert("添加成功！");
                    $('#dlg1').dialog('close');
                }


            }

        })

    });
    }


</script>
</html>
