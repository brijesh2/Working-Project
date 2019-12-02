package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
             conn =DriverManager.getConnection(  
            		"jdbc:oracle:thin:@localhost:1521:xe","system","1234"); 
             
            pst = conn.prepareStatement("select * from userreg where name=? and pass=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
           
            status = rs.next();
            System.out.print(status);
        } catch (Exception e) {
            System.out.println(e);
        } 
        
        return status;
    }
}