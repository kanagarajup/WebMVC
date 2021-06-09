package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.Customer;
import dao.BankDAO;

/**
 * Servlet implementation class BankServlet
 */
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw=response.getWriter();
        
        int cid=Integer.parseInt(request.getParameter("cid"));
        String cname=request.getParameter("cname");
        double balance=Double.parseDouble(request.getParameter("balance"));
        String branch=request.getParameter("branch");
        Customer c=new Customer();
        c.setCid(cid);
        c.setCname(cname); 
        c.setBalance(balance);
        c.setBranch(branch);
        BankDAO cd=new BankDAO();
        String t=cd.insert(c);
        if(t.equals("Success"))
        {pw.println("<h3> Customer Deatials with "+cid+" Insertion Successfull</h3>");}
        else
        { pw.println("<h3>Insert Fail</h3>");}
	}
}
