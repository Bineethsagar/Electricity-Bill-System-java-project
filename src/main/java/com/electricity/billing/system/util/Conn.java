//package com.electricity.billing.system.util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class Conn{
//    Connection c;
//    public Statement s;
//    public Conn(){  
//        try{  
//            Class.forName("com.mysql.jdbc.Driver");  
//            c =DriverManager.getConnection("jdbc:mysql://electricity_billing_system","root","root");    
//            s =c.createStatement();  
//            
//           
//        }catch(Exception e){ 
//            System.out.println(e);
//        }  
//    }  
//}  
