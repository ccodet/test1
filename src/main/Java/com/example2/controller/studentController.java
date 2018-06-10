package com.example2.controller;

import com.example2.Service.UserServiceImpl;
import com.example2.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("students")
public class studentController {

    @RequestMapping("/hello")
    public String index() {
        return "index1";
    }


    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String haveStudent(@RequestParam("sname") String sname, @RequestParam("pwd") String pwd, Model model) {

        model.addAttribute("sname", sname);
        model.addAttribute("pwd", pwd);
       if (new UserServiceImpl().doLogin(sname,pwd)){
            List<Student> list = new UserServiceImpl().findAll();
            model.addAttribute("student",list);
            return "login";
        }else {
            return "fail";
       }

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestBody Student student) {
        System.out.println(student.toString());

        int code = new UserServiceImpl().add(student);

        if (code > 0) {
            return "success";
        } else {
            return "fail";
        }
    }



}
