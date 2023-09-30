package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FiveSteps {

	public static void main(String[] args) {		
		//setting up the prerequisities
		Connection con = null;
		Statement statement = null;
		ResultSet res = null;

		String url = "jdbc:mysql://localhost:3306/jdbc01";
		String username = "root";
		String password = "root";

		try {
			
			//step 2: connnection
			con = DriverManager.getConnection(url, username, password);

			//step 3: create statement
			statement = con.createStatement();
			
			String sql = "select * from employee;";
			
			//step 4: execute statement
			res = statement.executeQuery(sql);
			
			//step 5: process the result
			while(res.next()) {
				
				int id = res.getInt("id");
				String name = res.getString("name");
				String dept = res.getString("dept");
				int salary = res.getInt("salary");
				
				System.out.println(id +" "+name+" "+dept+" "+salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
