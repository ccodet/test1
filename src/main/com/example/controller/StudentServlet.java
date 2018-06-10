package com.example.controller;

import com.example.Service.UserServiceImpl;
import com.example.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/student")  //name,url
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //提交大文件
        System.out.println("提交到post");
        String name = request.getParameter("username");//括号里填写jsp里面name的内容
        String pwd = request.getParameter("password");
        System.out.println(name+","+pwd);
        if (new UserServiceImpl().doLogin(name,pwd)) {
            List<Student> list = new UserServiceImpl().findAll();
            request.setAttribute("student",list);
            response.setCharacterEncoding("UTF-8");//定义输出编码格式，指定输出流格式
            PrintWriter out = response.getWriter();//获取对象
            response.setContentType("text/html;charsetUTF_8");//请求转发
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //提交小文件,信息会显示在URL
        //设置网页响应类型
//        response.setContentType("text/html");
        //实现具体操作
//        PrintWriter out = response.getWriter();
//        out.println("This is a new servlet page");
//        System.out.println("提交");


        String id;
        if (request.getParameter("type").equals("0")) {
            id = request.getParameter("sname");
            String sno = request.getParameter("sno");
            String sex = request.getParameter("ssex");
            String sage = request.getParameter("sage");
            String sdept = request.getParameter("sdept");
            String pwd = request.getParameter("pwd");
            Student student = new Student();
            student.setSname(id);
            student.setSno(sno);
            student.setSsex(sex);
            student.setSage(Integer.parseInt(sage));
            student.setPwd(pwd);
            student.setSdept(sdept);

            int code = (new UserServiceImpl()).add(student);
            if (code > 0) {
                response.getWriter().print("success");
            } else {
                response.getWriter().print("fail");
            }
        } else {
            Student student;
            if (request.getParameter("type").equals("1")) {

            }
        }
    }
}
