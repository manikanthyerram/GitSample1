package com.gs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.util.ConnectionUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public void init(ServletConfig config)throws ServletException
    {
          try
             {
                       //Class.forName("com.mysql.jdbc.Driver");
           
        	  //con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pricing","root","root");
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
              PrintWriter pw=response.getWriter();
              String UserName=request.getParameter("name");
              String Password=request.getParameter("pass");
              pw.println("<html><body>");
              try
              {
                    ps=(PreparedStatement) con.prepareStatement("select * from users where UserName=? and Password=?");
                    ps.setString(1, UserName);
                    ps.setString(2, Password);
                    rs=ps.executeQuery();
                    if(rs.next())
                    {
                          pw.println("<h3>welcome " +" " + UserName +"</h3>");
                          RequestDispatcher rd1=request.getRequestDispatcher("PRM.jsp");
                          rd1.include(request,response);
                          //or
                          //response.sendRedirect("./index.html");
                          pw.println("<form method=\"post\" action=\"index.html\">");
                         // pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
                          pw.println("</form>");

                    }
                    else
                    {
                          pw.println("<center><h3>invalid username/password Enter Correct username/password</h3></center>");
                          RequestDispatcher rd2=request.getRequestDispatcher("./index.html");
                          rd2.include(request,response);
                          
                    }
              }
              catch (SQLException e){
			 e.printStackTrace();
			}

	}

}
