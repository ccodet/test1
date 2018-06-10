package com.example;

import com.example.dao.DBUtils;

public class testjdbc2 {
    public static void main(String[] args) {
        DBUtils db = new DBUtils();
        db.getConn();

    }
}
