package com.hefshine.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hefshine.bean.NewContactBean;
import com.hefshine.bean.RegisterBean;


public class MyContactAppDao {

	String DB_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/mycontactapp";
	String DB_USERNAME = "root";
	String DB_PASSWORD = "";

	
	Connection con;
	PreparedStatement pst;
	ResultSet set;

	public void openDB()
	{
		try 
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	RegisterBean b = new RegisterBean();

	public int registerUser(RegisterBean reg)
	{
		int status=0;
		String quary="insert into userregister(name,number,username,password) values(?,?,?,?)";
		try {
			openDB();
			pst=con.prepareStatement(quary);
			pst.setString(1, reg.getName());
			pst.setString(2, reg.getNumber());
			pst.setString(3, reg.getUsername());
			pst.setString(4, reg.getPassword());
			status= pst.executeUpdate();
			closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean  checkUser(RegisterBean reg)
	{
		boolean status=false;
		
		String quary ="select username,password from userregister where username=? and password=? ;";
		//SELECT username,password FROM userregister WHERE username="abdul" and password="abdul"
		openDB();
		try 
		{
			pst=con.prepareStatement(quary);
			pst.setString(1, reg.getUsername());
			pst.setString(2, reg.getPassword());
			set= pst.executeQuery();
			while(set.next())
			{
				status=true;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeDB();
		
		return status;
		
	}
	
	
	public int AddNewContact(NewContactBean newcontact)
	{
		
		int status=0;
		
		String query="insert into contactlist (fname,lname,contact,sim)values(?,?,?,?);";
		
		openDB();
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1,newcontact.getFname() );
			pst.setString(2, newcontact.getLname());
			pst.setString(3, newcontact.getNumber());
			pst.setString(4, newcontact.getSim());
			status=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return status;
	}
	
	public List<NewContactBean> fetchAll()
	{
		String quary="select * from contactlist;";
		
		
		openDB();
		
		ArrayList<NewContactBean> al = new ArrayList<NewContactBean>();
		try {
			pst=con.prepareStatement(quary);
			set=pst.executeQuery();
			
			
			while(set.next()) {

				NewContactBean be = new NewContactBean();
				
			//	int id =set.getInt("id");
				String fname=set.getString("fname");
				String lname=set.getString("lname");
				String number=set.getString("contact");
				String sim=set.getString("sim");
				
				be.setFname(fname);
				be.setLname(lname);
				be.setNumber(number);
				be.setSim(sim);
				
				al.add(be);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		
		return al;
		
	}
	
	
	public List<NewContactBean> searchByName(String name)
	{
		String quary ="select * from contactlist where fname=?";
		openDB();
		
		ArrayList<NewContactBean> al = new ArrayList<NewContactBean>();
		try {
			
			pst=con.prepareStatement(quary);
			pst.setString(1, name);
			set=pst.executeQuery();
			
			
			while(set.next())
			{
				
				NewContactBean bean = new NewContactBean();
				String fname=set.getString("fname");
				String lname=set.getString("lname");
				String number=set.getString("contact");
				String sim=set.getString("sim");
				
				bean.setFname(fname);
				bean.setLname(lname);
				bean.setNumber(number);
				bean.setSim(sim);
				al.add(bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return al;
		
	}
	
	// 
	public List<NewContactBean> searchByNumber(String num)
	{
		String quary ="select * from contactlist where contact=?";
		openDB();
		
		ArrayList<NewContactBean> al = new ArrayList<NewContactBean>();
		try {
			
			pst=con.prepareStatement(quary);
			pst.setString(1, num);
			set=pst.executeQuery();
			
			
			while(set.next())
			{
				
				NewContactBean bean = new NewContactBean();
				String fname=set.getString("fname");
				String lname=set.getString("lname");
				String number=set.getString("contact");
				String sim=set.getString("sim");
				
				bean.setFname(fname);
				bean.setLname(lname);
				bean.setNumber(number);
				bean.setSim(sim);
				al.add(bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return al;
		
	}
	
	public int deleteByName(String name)
	{
		int status=0;
		String query = "Delete from contactlist where fname =?";
		
		openDB();
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, name);
			status=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return status;
	}
	
	public int deleteByNumber(String num)
	{
		int status=0;
		String query = "Delete from contactlist where contact =?";
		
		openDB();
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, num);
			status=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return status;
	}
	
	public int updateContact(NewContactBean bean)
	{
		int status=0;
		
		String query = "update contactlist set contact =? where fname=? ";
		
		openDB();
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, bean.getNumber());
			pst.setString(2, bean.getFname());
			status=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return status;
	}
	
	public RegisterBean getProfileInfo(RegisterBean bean)
	{

	String quary="select * from userregister where username =? and password=?;";
	
	
	openDB();
	
	RegisterBean be = new RegisterBean();
	//ArrayList<NewContactBean> al = new ArrayList<NewContactBean>();
	try {
		pst=con.prepareStatement(quary);
		pst.setString(1, bean.getUsername());
		pst.setString(2, bean.getPassword());
		set=pst.executeQuery();
		
		while(set.next()) {

		//	int id =set.getInt("id");
			String name=set.getString("name");
			String number=set.getString("number");
			String username=set.getString("username");
			String password=set.getString("password");
			
			be.setName(name);
			be.setNumber(number);
			be.setUsername(username);
			be.setPassword(password);
			
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	closeDB();
	
	return be;
	}
	public int deleteUser(String username,String password)
	{
		int status=0;
		String query = "Delete from userregister where username =? and password=?";
		
		openDB();
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			status=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return status;
	}
	
	public void closeDB()
	{
		try {
		
		if(con!=null) {
			con=null;
		}
		if(pst!=null) {
			pst=null;
		}
		if(set!=null) {
			set=null;
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
