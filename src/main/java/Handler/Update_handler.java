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
import dao.login_dao;

/**
 * Servlet implementation class Update_handler
 */
@WebServlet("/Update_handler")
public class Update_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_handler() {
        super();
   
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		  PrintWriter pw=response.getWriter();
		  
		  String id=request.getParameter("nid");
		  String pass=request.getParameter("npass");
		  
		  login_bo e=new login_bo();
		    e.setId(id);
		    e.setPassword(pass);
		    
		    int status=login_dao.update(e);
		    
		    if(status>0)
			  {
				  pw.print("data updated");
				  RequestDispatcher rd=request.getRequestDispatcher("home.html");
				  rd.include(request, response);
			  }
		    else
			  {
				  pw.print("data  not updated");
				  RequestDispatcher rd=request.getRequestDispatcher("Update.html");
				  rd.include(request, response);
			  }

		  
		  
	}

}
