package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.FormModel;
import com.service.FormService;

public class FormRepository implements FormService {

	private Connection conn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;

	public FormRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletjdbc", "root", "ducat");
			stm = conn.createStatement();
			stm.execute(
					"create table if not exists form (sno int auto_increment primary key,name text,email text,password text,mobile text,fileName text)");
			System.out.println("Table created");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean insert(FormModel fm) throws Exception {

		pstm = conn.prepareStatement("insert into form(name,email,password,mobile,fileName) values(?,?,?,?,?) ");
		pstm.setString(1, fm.getName());
		pstm.setString(2, fm.getEmail());
		pstm.setString(3, fm.getPassword());
		pstm.setString(4, fm.getMobile());
		pstm.setString(5, fm.getFile_name());
		return pstm.execute();

	}

	public ArrayList<FormModel> fetchAllData() {
		ArrayList<FormModel> data = new ArrayList<FormModel>();
		try
		{
		pstm = conn.prepareStatement("select * from form");
		ResultSet set = pstm.executeQuery();
		
		while(set.next())
		{
			int sno = set.getInt(1);
			String name = set.getString(2);
			String email = set.getString(3);
			String password = set.getString(4);
			String mobile = set.getString(5);
			String file_name = set.getString(6);
			FormModel fm = new FormModel(sno, name, email, mobile, password, file_name);
					data.add(fm);
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
