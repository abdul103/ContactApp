package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.bean.RegisterBean;
import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		HttpSession mysession = request.getSession();
		
		String username=(String) mysession.getAttribute("username");
		String password=(String) mysession.getAttribute("password");
		
		
		MyContactAppDao dao = new MyContactAppDao();
		
		RegisterBean b = new RegisterBean();
		
		b.setUsername(username);
		b.setPassword(password);

		RegisterBean bean=	dao.getProfileInfo(b);
      	
      	
		
      	String name= bean.getName();
      	String number= bean.getNumber();
      	String username1=bean.getUsername();
      	String password1=bean.getPassword();
      	
      	mysession.setAttribute("name", name);
      	mysession.setAttribute("number", number);
      	
      	RequestDispatcher rd = request.getRequestDispatcher("Welcome.html");
      	
      	pw.print("<html><head>  <style>h4{color:Green;text-align:center};h3{color:blue;text-align:center};  </style></head><body>");
      	
      	pw.print("<h3>Your Profile Details</h3>");
      	pw.print("<h4>Name  :&nbsp;"+name+"</h4>");
      	pw.print("<h4>Number  :&nbsp;"+number+"</h4>");
      	pw.print("<h4>UserName  :&nbsp;"+username1+"</h4>");
      	pw.print("<h4>Password  :&nbsp;"+password1+"</h4>");

      	pw.print("</body></html>");

      	rd.include(request, response);
      	pw.print(name+number+username1+password);
		
		pw.print(username+password);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
