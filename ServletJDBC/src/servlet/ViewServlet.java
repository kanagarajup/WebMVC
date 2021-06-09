package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.Customer;
import dao.BankDAO;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViewServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int cid=Integer.parseInt(request.getParameter("cid"));
		  BankDAO cd=new BankDAO();
		  Customer c=cd.view(cid);		  
		  request.setAttribute("bean",c); 
		  if(c!=null){  
	            RequestDispatcher rd=request.getRequestDispatcher("viewcustomer.jsp");  
	            rd.forward(request, response);  
	        }  
	        else{  
	            RequestDispatcher rd=request.getRequestDispatcher("viewerror.jsp");  
	            rd.forward(request, response);  
	        }  
	}

	


}
