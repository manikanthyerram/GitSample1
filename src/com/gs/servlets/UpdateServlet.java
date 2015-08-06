package com.gs.servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.util.ConnectionUtil;
import com.mysql.jdbc.Connection;



public class UpdateServlet extends HttpServlet
{
      Connection con;
     
      ResultSet rs;
      public void init(ServletConfig config)throws ServletException
      {
            try
               {
                       // Class.forName("com.mysql.jdbc.Driver");
                       // con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pricing","root","root");
			con=(Connection) ConnectionUtil.getConnection();
               }
                  catch (Exception e)
                     {
                        System.out.println(e);
                     }
                  
      }
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
            
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();
                String Name=request.getParameter("name");
                String Npassword=request.getParameter("pass");
		String RePassword=request.getParameter("Repass");
 
try {
 	if(Npassword.equals(RePassword)) {
	
	Statement st = con.createStatement();
	String sql="UPDATE users set Password='"+Npassword+"' WHERE UserName='"+Name+"'";
   	int i=st.executeUpdate(sql);
     	//out.println("connection successful .."+i);
	st.executeUpdate(sql);
				
                            out.println("<center><h3>succefully updated</h3></center>");
                            RequestDispatcher rd1=request.getRequestDispatcher("./index.html");
                            rd1.include(request,response);
                           

                      }
                      else 
                      {
                            out.println("<center><h3>password did not match</h3></center>");
                            RequestDispatcher rd2=request.getRequestDispatcher("./index.html");
                            rd2.include(request,response);
                            
                      } 
                
 	} catch (Exception e) {
     		 out.println(e);
    		}

		 finally {
			try {
      			
      			con.close();
			}
			catch(Exception ex){ }
  			 }
  }
}
                
 
