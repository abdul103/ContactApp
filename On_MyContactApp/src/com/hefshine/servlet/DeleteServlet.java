package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		String fname=request.getParameter("fname");
		//pw.print("<h1>"+fname+"</h1>");
		MyContactAppDao dao = new MyContactAppDao();
		int status=dao.deleteByName(fname);
		
		if(status>0) 
		{
			pw.print("<html><h2 style='color:blue; text-align:center'>Your contact: &nbsp;&nbsp"+fname+"</h2></html>");
			pw.print("<html><h1 style='color:green;text-align:center'>Has been deleted successfully</h1></html>");
			//pw.print("<html><h1 style='color:Blue; text-align:center'>Please Login to Continue</h1></html>");

		
		}
		else 
			
		{
			pw.print("<h1 style='color:blue; text-align:center'>The Name: &nbsp&nbsp"+fname+"</h1>");
			pw.print("<html><h2 style='color:red; text-align:center'> Is not Available in Your contactlist</h2></html>");
		pw.print("<html><h2 style='color:red; text-align:center'> Check the name and try Again</h2></html>");
		}
		
	}

}
