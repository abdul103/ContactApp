package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.bean.NewContactBean;
import com.hefshine.dao.MyContactAppDao;

/**
 * Servlet implementation class FetchAllServlet
 */
public class FetchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		pw.print("<h1>Your All Contacts</h1>");
		pw.print("<a href='Welcome.html' ><img src='images/home.png' height=50; width=50; text-align:right></a>");
		pw.print("<h3>Home<h3>");
		MyContactAppDao dao = new MyContactAppDao();
		
	List<NewContactBean> al =dao.fetchAll();
	
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		pw.print("<h1>post fetch all</h1>");
	}

}
