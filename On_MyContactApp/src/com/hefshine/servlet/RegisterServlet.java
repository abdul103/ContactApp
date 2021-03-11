package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.bean.RegisterBean;
import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String conpassword = request.getParameter("conpassword");
		
		
		
		if(password.equals(conpassword)) 
		{
			//pw.print("pass word same");
			
			RegisterBean reg = new RegisterBean();
			reg.setName(name);
			reg.setNumber(number);
			reg.setUsername(username);
			reg.setPassword(password);
			
			MyContactAppDao mycon = new MyContactAppDao();
			int status=mycon.registerUser(reg);
			
			if(status>0) 
			{
				pw.print("<html><h1 style='color:green;text-align:center'>You have Register successfully</h1></html>");
				pw.print("<html><h1 style='color:Blue; text-align:center'>Please Login to Continue</h1></html>");

			
			}
			else {
				pw.print("<html><h1 style='color:red; text-align:center'>Registeration failed</h1></html>");
			
			
			pw.print("<html><h1 style='color:blue; text-align:center'>"+number+"</h1></html>");
			pw.print("<html><h1 style='color:blue; text-align:center'>This Number allready Registered</h1></html>");
			
			}
		}else {
			pw.print("<h1>Your password doesnot match<h1>");
			pw.print("<h1>please re-enter the password Again<h1>");
		}
		
		//System.out.println(name+number+username+password+conpassword);
		
		
		
	}

}
