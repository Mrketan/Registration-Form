package com.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Register1
 */
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1() {
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
PrintWriter out=response.getWriter();
		
		String myname=request.getParameter("name1");
		String myemail=request.getParameter("email1");
		
		String mypass=request.getParameter("pass1");
		
		String mygender=request.getParameter("gender1");
		
		String mycity=request.getParameter("city1");
		
		
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","123456789");
			
			PreparedStatement ps	=con.prepareStatement("insert into register1 values(?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mygender);
			ps.setString(5, mycity);
			
			int count=ps.executeUpdate();
			
			if(count>0) {
				response.setContentType("text/html");
				out.print("<h3 style='color:green'>User registered successfully</h3>");
				
				RequestDispatcher rd=request.getRequestDispatcher("/Index.html");
rd.include(request, response);
				
			}
			else
			{
				
				response.setContentType("text/html");
				out.print("<h3 style='color:red'>User not registered due to some error</h3>");
				
				RequestDispatcher rd=request.getRequestDispatcher("/Index.html");
				rd.include(request, response);

				
			}
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			

			response.setContentType("text/html");
			out.print("<h3 style='color:red'>Error Occured: "+e.getMessage()+"</h3>");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Index.html");
rd.include(request, response);
		}
		
		
	}
	}


