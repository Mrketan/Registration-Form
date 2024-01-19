package com.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerInput")
public class registerInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cID;
private static int idCounter = 1;
	

	public static synchronized int createID()
	{
	    return idCounter++;
	}    
    
    public registerInput() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		 String name=request.getParameter("name");
		 
		String  password=request.getParameter("password");
			
		String	address=request.getParameter("address");
	
			String email=request.getParameter("email");
			
			response.setContentType("text/html");  
			try{  
				Class.forName("oracle.jdbc.driver.OracleDriver");				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","123456789");
			   
				PreparedStatement ps=con.prepareStatement(  
						"insert into student values(?,?,?,?,?)");  
				cID=createID();
				
					ps.setInt(1, cID); 
					ps.setString(2, name);				
					ps.setString(3, email);
					ps.setString(4, password);
					ps.setString(5, address);
			 
			          
			int i=ps.executeUpdate();  
			 
//			out.print("You are successfully registered...");  
			if(i>0) 
			{
			response.sendRedirect("Index.html"); 
			}
			con.close();
			
			}
			catch (Exception e2) 
			{
				System.out.println(e2);
				
				
			}
			out.close();
	}
			          
			

		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		 String name=request.getParameter("name");
		 
		String  password=request.getParameter("password");
			
		String	address=request.getParameter("address");
	
			String email=request.getParameter("email");
			
			response.setContentType("text/html");  
			try{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","123456789");  
			   
				PreparedStatement ps=con.prepareStatement(  
						"insert into student values(?,?,?,?,?)");  
				cID=createID();
				
					ps.setInt(1, cID); 
					ps.setString(2, name);				
					ps.setString(3, email);
					ps.setString(4, password);
					ps.setString(5, address);
			 
			          
			int i=ps.executeUpdate();  
			 
//			out.print("You are successfully registered...");  
			if(i>0) 
			{
			response.sendRedirect("Index.html"); 
			}
			con.close();
			
			}
			catch (Exception e2) 
			{
				System.out.println(e2);
				
				
			}
			out.close();
		
		
		
		
		
	}

}
