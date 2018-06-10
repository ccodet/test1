package com.example2.controller;

import com.example2.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//404 访问路径错误
//500 程序写错 大概率控制层

//@Controller
//@RequestMapping("student")
public class indexController {
    @RequestMapping("/world")
    public String index() {
        return "index1";
    }

    @RequestMapping(value = "/world", method = RequestMethod.POST)
    public String testModel(@RequestParam("sname") String sname, @RequestParam("pwd") String pwd, Model model) {
        model.addAttribute("sname", sname);
        model.addAttribute("pwd", pwd);
        return "bingo";
    }

    @RequestMapping(value = "/world",method = RequestMethod.POST)
    public ModelAndView testModelAndView(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sname", student);
        modelAndView.addObject("pwd", student);
        modelAndView.setViewName("bingo");
        return modelAndView;
    }
}
