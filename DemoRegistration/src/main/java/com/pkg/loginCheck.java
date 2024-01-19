package com.pkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String emailID, password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		emailID=request.getParameter("email");
		password=request.getParameter("password"); 
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","123456789");
			Statement stmt  =con.createStatement();
			//out.print("select customer_password from customer where customer_emailID='"+emailID+"'");
			//out.println(password);
			ResultSet rs=stmt.executeQuery("select * from student where email='"+emailID+"'"); 
				while(rs.next())
				{	
					if((rs.getString(4)).equals(password))
					{	
						
						RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  				  
					    rd.forward(request, response);
					}	
					else
					{	//response.getWriter().append("Sorry UserName or Password Error!");  
			        	RequestDispatcher rd=request.getRequestDispatcher("loginError.html");  
			        	rd.include(request, response);  
				    }
				}	
			con.close();
		   }catch(Exception e){  e.printStackTrace();}
		
    }
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		emailID=request.getParameter("email");
		password=request.getParameter("password"); 
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","123456789");
			Statement stmt  =con.createStatement();
			//out.print("select customer_password from customer where customer_emailID='"+emailID+"'");
			//out.println(password);
			ResultSet rs=stmt.executeQuery("select * from student where email='"+emailID+"'"); 
				while(rs.next())
				{	
					if((rs.getString(4)).equals(password))
					{	
						
						RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  				  
					    rd.forward(request, response);
					}	
					else
					{	
						
//						response.getWriter().append("Sorry UserName or Password Error!");  
			        	RequestDispatcher rd=request.getRequestDispatcher("loginError.html");  
			        	rd.include(request, response);  
				    }
				}	
			con.close();
		   }catch(Exception e){  e.printStackTrace();}
		
    }
		
	}

