package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.bean.NewContactBean;
import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class AddNewContactServlet
 */
public class AddNewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewContactServlet() {
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
		//pw.print("<h1>add new servlet </h2>");
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String number=request.getParameter("number");
		String sim=request.getParameter("sim");
		
		NewContactBean newcontact = new NewContactBean();
		
		newcontact.setFname(fname);
		newcontact.setLname(lname);
		newcontact.setNumber(number);
		newcontact.setSim(sim);
		
		MyContactAppDao methods = new MyContactAppDao();
		
		int status = methods.AddNewContact(newcontact);

		
		if(status>0) 
		{
			pw.print("<html><h1 style='color:green;text-align:center'>Contact has been added successfully</h1></html>");
			//pw.print("<html><h1 style='color:Blue; text-align:center'>Please Login to Continue</h1></html>");
		}
		else 
		{
			pw.print("<html><h1 style='color:red;text-align:center'>Contact din't add</h1></html>");
			pw.print("<html><h1 style='color:red;text-align:center'>Please fill all field and try again</h1></html>");
		}
	}
}
