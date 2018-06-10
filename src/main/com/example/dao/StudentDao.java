package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentDao {
//    新增
    public int save(Student student);

    //    修改
    public int update(Student student);

    //    删除
    public int del(Student student);

    //    全查
    public List<Student> findAll();

    public Student findById(String id);

    public List<Student> findByName(String name);

    public boolean login(String name, String pwd);

}
