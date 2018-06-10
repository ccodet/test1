package com.example;
import java.sql.*;

public class testjdbc {
    public static void main(String[] args) {
        ResultSet rs = null;
        PreparedStatement pspt = null;
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test1";
            conn = DriverManager.getConnection(url,"root","1234");
            String sql = "select * from student";
            pspt = conn.prepareStatement(sql);
            rs = pspt.executeQuery();
            while (rs.next())
            {
                String sno = rs.getString(1);
                System.out.println(sno);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
                pspt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

}

