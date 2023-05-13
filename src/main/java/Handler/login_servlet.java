package Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bin.login_bo;
import dao.*;


@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    public login_servlet() 
    {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		  PrintWriter pw=response.getWriter();
		  
		  String emp_id=request.getParameter("id");
		  String emp_pass=request.getParameter("pass");
		  
		  login_bo lb=new login_bo(emp_id, emp_pass);
		  
		  int status=login_dao.insert(lb);
		 
		  
		  if(status>0)
		  {
			  pw.print("data inserted");
			  RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			  rd.include(request, response);
		  }
		  
		  else
		  {
			  pw.print("data  not inserted");
			  RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			  rd.include(request, response);
		  }
		    
		  
		 
	}
}
