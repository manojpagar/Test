package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bin.login_bo;

public class login_dao {

	public static Connection connet() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1",
						"root","Manoj@123");
			
			} catch (Exception e) {
				System.out.println(e);
			}
			return con;

	}
	
	
	
	
	
	
	
	public static int Login(login_bo bl)
	{
		int status=0;
		
		try 
		{
		 Connection con=login_dao.connet();
		 String query="select * from login_emp where id=? and pass=?";
		 
		 PreparedStatement ps=con.prepareStatement(query);
		 
		 ps.setString(1,bl.getId());
		 ps.setString(2,bl.getPassword());
		 
		status= ps.executeUpdate();
			
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return status;
		
		
	}

	public static int insert(login_bo bl)
	{
		int status=0;
		
		try 
		{
		 Connection con=login_dao.connet();
		 String query="insert into login_emp values(?,?)";
		 
		 PreparedStatement ps=con.prepareStatement(query);
		 
		 ps.setString(1,bl.getId());
		 ps.setString(2,bl.getPassword());
		 
		status= ps.executeUpdate();
			
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return status;
		
		
	}
	
	
	public static List<login_bo> Fetch()
	{
		 List<login_bo> list=new ArrayList<login_bo>();
		 
		 try {
			
			 Connection con=login_dao.connet();
			 
			 Statement st=con.createStatement();
			 ResultSet rs =st.executeQuery("select * from login_emp");
			 

				while(rs.next())
				{
					login_bo e=new login_bo();
					e.setId(rs.getString(1));
					e.setPassword(rs.getString(2));
					
					list.add(e);
					
				}
				con.close();
		 
			 
		} catch (Exception e) {
			System.out.println(e);
		}
		 
		 
		 return list;
		 
	}
	
	
	public static int update(login_bo bl)
	{
		int status=0;
		try {
			
			Connection con=login_dao.connet();
			String query = "update login_emp set pass=? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(2, bl.getId());
			ps.setString(1, bl.getPassword());
			
			
			status =ps.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return status;
	}

	
	public static int Delete(login_bo bl)
	{
		int status=0;
		try {
			
			Connection con=login_dao.connet();
			String query = "delete from login_emp where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			
		ps.setString(1, bl.getId());
			
			
			
			status =ps.executeUpdate();
			
			con.close();
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	

}
