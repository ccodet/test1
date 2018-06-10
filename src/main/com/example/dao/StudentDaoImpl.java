package com.example.dao;

import com.example.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentDaoImpl implements StudentDao {
    static final String SQL = "select * from student where 1=1";

    Connection conn = null;
    @Override
    public int save(Student student) {
        String sql = "insert into student(sno,sname,ssex,sage,sdept,pwd) values(?,?,?,?,?,?)";
        Object[] params = {student.getSno(), student.getSname(), student.getSsex(),student.getSage(),student.getSdept(),student.getPwd()};
        return new DBUtils().excute(sql, params);
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int del(Student student) {
        String sql = "delete from student where sno = ?";
        Object[] params = new Object[]{student.getSno()};
        return (new DBUtils()).excute(sql, params);
    }

    @Override
    public List<Student> findAll() {
        DBUtils dbUtils = new DBUtils();
        PreparedStatement ps = null;
        conn = dbUtils.getConn();
        ResultSet rs = null;
        String sql = "select * from student";
        List<Student> students = new LinkedList<>();
        Student[] students1 = new Student[70];
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                students1[i] = new Student();
                students1[i].setSno(rs.getString(1));
                students1[i].setSname(rs.getString(2));
                students1[i].setSsex(rs.getString(3));
                students1[i].setSage(rs.getInt(4));
                students1[i].setSdept(rs.getString(5));
                students1[i].setPwd(rs.getString(6));
                students.add(i, students1[i]);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }



    @Override
    public Student findById(String id) {
        Student student = new Student();
        Map<String, String> map = new HashMap<>();
        map.put("condition", "id");
        map.put("value", "id");
        ResultSet rs = (new DBUtils()).find("select * from student where 1=1", map);

        try {
            while (rs.next()) {
                student.setSno(rs.getString(1));
                student.setSname(rs.getString(2));
                student.setSsex(rs.getString(3));
                student.setSage(rs.getInt(4));
                student.setSdept(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> findByName(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("condition", "name");
        map.put("value", "name");
        ResultSet rs = (new DBUtils()).find("select * from student where ?=?", map);

        ArrayList list = new ArrayList();
        try {
            while (rs.next()) {
                Student student = new Student();
                student.setSno(rs.getString(1));
                student.setSname(rs.getString(2));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean login(String name, String pwd) {
        PreparedStatement ps = null;
        Connection conn = (new DBUtils().getConn());
        ResultSet rs = null;

        try {
            String sql = "select * from student where sname = ? and pwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, pwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
