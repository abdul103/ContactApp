package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.bean.NewContactBean;
import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		//pw.print("seach by name");
		String fname= request.getParameter("fname");
		
		MyContactAppDao dao = new MyContactAppDao();
		List<NewContactBean> al =dao.searchByName(fname);
		
		
		pw.print("<html><head><title>allContact</title></head><body style='background-color:powderblue;text-align:center'>");
		pw.print("<table border='1px'><thead><th>No.</th><th>First Name</th><th>Last Name</th><th>Contact Number</th><th>Sim Type</th></thead>");
		pw.print("<tbody>");
		int i=1;
		for(NewContactBean bean:al) {
			pw.print("<tr style='padding:5px;'>");
			pw.print("<td style='padding:5px;'> "+i+"</td>");
			pw.print("<td style='padding:5px;'> "+bean.getFname()+"</td>");
			pw.print("<td style='padding:5px;'> "+bean.getLname()+"</td>");
			pw.print("<td style='padding:5px;'> "+bean.getNumber()+"</td>");
			pw.print("<td style='padding:5px;'> "+bean.getSim()+"</td>");
			pw.print("</tr>");
			i++;
			
		}
		
		pw.print("</tbody></table>");
		
		
		
	}

}
