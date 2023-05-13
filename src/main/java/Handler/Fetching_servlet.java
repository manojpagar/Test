package Handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bin.login_bo;
import dao.login_dao;


@WebServlet("/Fetching_servlet")
public class Fetching_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Fetching_servlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		  PrintWriter pw=response.getWriter();
		  
		  List<login_bo> ob=login_dao.Fetch();
		  
 
		  
		  pw.print("EMPLOYEE DETAILS <br><br>");
		  
		  pw.print("<table border ='1' width=400px>");
		  pw.print(" <tr> <th>Employee ID</th> <th>Employee Password</th></tr>");
		  
		  
		  for(login_bo el:ob)
		  {
			  pw.print("<tr> <td>"+el.getId()+"</td><td>"+el.getPassword()+"</td></tr>");
		  }
		  pw.print("</table>");
		  pw.close();

	}

}
