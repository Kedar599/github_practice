package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdemo {

    public static void main(String args[]) {
    	Student s1=new Student();
    	s1.setId(0);
    	s1.setName("kedar");
    	s1.setSal(56.45);
    	
    	

        try {

            // 1. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdb",
                    "root",
                    "12345678"
            );

            // 3. Create statement
            Statement st = con.createStatement();

            // 4. Create table
           // st.execute(
//                    "CREATE TABLE student(" +
//                    "name VARCHAR(50)," +
//                    "id INT," +
//                    "mark INT)"
//            );
            
            //st.execute("create table info(id int ,name varchar(34),salary float)");
            //st.execute("insert into info values(1,'kk',23.23)");
            st.execute("insert into info values(2,'pp',24.23)");
            st.execute("insert into info values(3,'tt',26.23)");
            ResultSet rs=st.executeQuery("select * from info");
            
            while(rs.next())
            {
            	int id=rs.getInt("id");
            	String name=rs.getString("name");
            	float sal=rs.getFloat("sal");
            	System.out.print(id+" "+name+" "+sal);
            	
            }
            

            // 5. Insert data
//            st.execute(
//                    "INSERT INTO student VALUES('kedar', 1, 23)"
//            );

            System.out.println("Data inserted successfully");

            // 6. Close
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}