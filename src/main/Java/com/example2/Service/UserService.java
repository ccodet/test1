package com.example2.Service;

import com.example2.entity.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

//    public int excute(String sql, Object[] params);
    int add(Student var1);

    int update(Student var1);

    int del(Student var1);
    //    全查
    public List<Student> findAll();

    List<Student> findByName(String name);

    boolean doLogin(String sname, String pwd);
}
