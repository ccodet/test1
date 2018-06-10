package com.example.Service;

import com.example.dao.DBUtils;
import com.example.dao.StudentDaoImpl;
import com.example.entity.Student;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
    Connection conn = null; //链接数据库的对象

    @Override
    public int add(Student student) {
        return (new StudentDaoImpl().save(student));
    }

    @Override
    public int update(Student var1) {
        return 0;
    }

    @Override
    public int del(Student student) {
        return (new StudentDaoImpl().del(student));
    }
    StudentDaoImpl studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {

        return studentDao.findAll();

}

    @Override
    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public boolean doLogin(String name, String pwd) {

        return studentDao.login(name, pwd);
    }

    //直接面向控制器Servlet,继承一个service接口
}
