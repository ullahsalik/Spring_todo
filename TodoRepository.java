package com.demo.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TodoRepository {

	Connection con = null;
	public TodoRepository() {
		String url = "jdbc:mysql://localhost:3306/Rest_DB";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	//GET ALL THE DETAILS
	public List<Todo> getTodos()
	{		
		List<Todo> stu = new ArrayList<>();
		String sql = "Select * from TODO";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Todo s = new Todo();
				s.setId(rs.getInt(1));
				s.setTname(rs.getString(2));				
				s.setIsDone(rs.getString(3));
				s.setCreatedat(rs.getString(4));
				s.setDoneat(rs.getString(5));
				
				
				stu.add(s);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return stu;
	}
	
	
	//GET THE SPECIFIED EVENT DETAIL Ex: 101
	public Todo getTodo(int id)
	{		
		Todo s = new Todo();
		String sql = "Select * from TODO where taskId="+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				s.setId(rs.getInt(1));
				s.setTname(rs.getString(2));				
				s.setIsDone(rs.getString(3));
				s.setCreatedat(rs.getString(4));
				s.setDoneat(rs.getString(5));
				
				
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return s;
	}
	
	
	//INSERT INTO DB
	public void create(Todo s1) {
		String sql = "insert into TODO values (?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,s1.getId());
			st.setString(2, s1.getTname());
			st.setString(3, s1.getIsDone());
			st.setString(4, s1.getCreatedat());
			st.setString(5, s1.getDoneat());
			st.executeUpdate();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	//UPDATE INTO DB
		public void update(Todo s1) {
			String sql = "update TODO set taskName=?,isDone=?,createdAt=?,doneAt=? where taskId=?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(5, s1.getId());
				st.setString(1, s1.getTname());
				st.setString(2, s1.getIsDone());
				st.setString(3, s1.getCreatedat());
				st.setString(4, s1.getDoneat());
				st.executeUpdate();
				
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			
		}
}

