package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDAO;

/**
 * Servlet implementation class NameSuggest
 */
public class NameSuggest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameSuggest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String suggestion="";
		//Array containing city names
		//String cities[]={"salem","sal","sa","ed","Erod","erode","covai","cov"};
		//fetch the city name from application request
		String city_name=request.getParameter("city_n");
		  BankDAO cd=new BankDAO();
		suggestion=cd.search(city_name);
		out.println(suggestion);
	
	
	}

	

}
