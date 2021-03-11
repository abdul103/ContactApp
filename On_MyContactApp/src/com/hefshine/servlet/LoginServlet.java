package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.bean.RegisterBean;
import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		HttpSession mysession = request.getSession();
		mysession.setAttribute("username", username);
		mysession.setAttribute("password", password);
		
		RegisterBean reg = new RegisterBean();
		reg.setUsername(username);
		reg.setPassword(password);
		MyContactAppDao mycontact = new MyContactAppDao();
		
		boolean status=mycontact.checkUser(reg);
		
		
		
		if(status) 
		{
			pw.print("<h1>login Successfull</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.html");
			rd.forward(request, response);
		}
		else {
			pw.print("<html><h1 style='color:Blue; text-align:center'>Invalid User Name or Password</h1></html>");
			pw.print("<html><h1 style='color:Blue; text-align:center'>Please check username\\ password and try again </h1></html>");
		}

		
	}

}
