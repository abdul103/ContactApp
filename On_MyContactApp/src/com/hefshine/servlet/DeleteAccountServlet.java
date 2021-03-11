package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class DeleteAccountServlet
 */
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
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
		HttpSession mysession = request.getSession();
		String username= (String) mysession.getAttribute("username");
		String password= (String)mysession.getAttribute("password");
		
		PrintWriter pw = response.getWriter();
		//pw.print("<h1>"+username+"-user  pass-"+password+"</h1>");
		
		MyContactAppDao dao = new MyContactAppDao();
		
		int status =dao.deleteUser(username, password);
		
		response.setContentType("text/html");
		
		if(status>0) 
		{
			//pw.print("<html><h2 style='color:blue; text-align:center'>Your Contact Number: &nbsp;&nbsp"+number+"</h2></html>");
			pw.print("<html><head></head><body><h1 style='color:red;text-align:center'>Yout Account Has been deleted successfully</h1></body></html>");
			
//			Thread t = new Thread();
//			try {
//				t.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//response.sendRedirect("Home.html");
			 RequestDispatcher rd=   request.getRequestDispatcher("Home.html");
			 rd.include(request, response);
		}
		
		
		
//		else 
//			
//		{
//			pw.print("<h1 style='color:blue; text-align:center'>The Number: &nbsp&nbsp"+number+"</h1>");
//			pw.print("<html><h2 style='color:red; text-align:center'> Is not Available in Your contactlist</h2></html>");
//		pw.print("<html><h2 style='color:red; text-align:center'> Check the Number and try Again</h2></html>");
//		}
		
		
		
	}

}
