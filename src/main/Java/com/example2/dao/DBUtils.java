package com.example2.dao;

import com.example2.entity.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DBUtils {
    Connection conn = null; //链接数据库的对象
    public Connection getConn() {
        if (conn == null) {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=UTF-8";
                conn = DriverManager.getConnection(url,"root","1234");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void closeConn(ResultSet rs,PreparedStatement pspt,Connection conn) {
        if (rs != null) {
            try {
                rs.close();//存结果集的对象
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pspt != null) {
            try {
                pspt.close(); //取数据的对象
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //新增、修改的方法
    public int excute(String sql, Object[] params) {
        PreparedStatement ps = null;
        this.conn = this.getConn();
        int result = 0;
        try {
            ps = this.conn.prepareStatement(sql);
            if (ps != null) {

                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
            }
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public ResultSet find(String sql, Map<String, String> map) {
        PreparedStatement ps = null;
        conn = getConn();
        ResultSet rs = null;
        String condition = map.get("condition");
        String value = map.get("value");
        StringBuffer sb = new StringBuffer("sql");

            try {
                    sql = sb.append(" and " + condition + " like ?").toString();
                    System.out.println(sql);
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1, "%" + value + "%");
                    rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return rs;

    }





}
