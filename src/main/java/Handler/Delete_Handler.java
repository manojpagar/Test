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
 * Servlet implementation class Delete_Handler
 */
@WebServlet("/Delete_Handler")
public class Delete_Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Handler() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String id=request.getParameter("id");
		login_bo e=new login_bo();
		   e.setId(id);
		   
		    
		    int status=login_dao.Delete(e);
		    
		    if(status>0)
			  {
				  pw.print("Data Deleted");
				  RequestDispatcher rd=request.getRequestDispatcher("home.html");
				  rd.forward(request, response);
			  }
		    else
			  {
				  pw.print("data  not deleted");
				  RequestDispatcher rd=request.getRequestDispatcher("Delete_data.html");
				  rd.include(request, response);
			  }
		
		
		
	}

}
