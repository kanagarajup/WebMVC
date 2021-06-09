package dao;
import java.sql.*;   import customer.Customer;
import util.Util;
public class BankDAO {
	public String insert(Customer c)
    {   Connection con=Util.getConnection();
    	int i=0;
    	  try
    	  {	PreparedStatement ps=con.prepareStatement(
    				  "insert into hcustomer values(?,?,?,?)");
    		  ps.setInt(1, c.getCid());
    		  ps.setString(2,c.getCname());
    		  ps.setDouble(3, c.getBalance());
    		  ps.setString(4, c.getBranch());    		  
    		  i=ps.executeUpdate();
    		 con.close();
    	  }
    	  catch(SQLException e1)
    	  {	  try {	con.close(); } catch (SQLException e2) {e2.printStackTrace(); 	}
    	     e1.printStackTrace();    	  
    	  }
    	  if(i==1)
    	  {  return "Success";}
    	  else
    	  { return "Fail";}
    }
	public String search(String city_name)
	{  String suggestion="<br>";
		if(city_name.length()>0) {
		
		Connection con=Util.getConnection();
		   try {
				PreparedStatement ps=con.prepareStatement(
						"select cname from hcustomer");
				ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {  
					 String cities=rs.getString(1);			 
									
						if(cities.toUpperCase().startsWith
								(city_name.toUpperCase()))
						{
						suggestion=suggestion+cities+"<br>";
						}
						
				 }
				
				con.close();
			} catch (SQLException e1) {
				try {con.close();} catch (SQLException e2) {
				e2.printStackTrace();
				}
				e1.printStackTrace();
				}
	}
	return suggestion;
	}
	public Customer view(int cid) {
		Customer c=new Customer();
		Connection con=Util.getConnection();
		   try {
				PreparedStatement ps=con.prepareStatement(
						"select * from hcustomer where cid=?");
				ps.setInt(1, cid);
				ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {  
					 c.setCid(rs.getInt(1));
					 c.setCname(rs.getString(2));
					 c.setBalance(rs.getDouble(3));
					 c.setBranch(rs.getString(4));
						
				 }
				
				if(rs.getRow()==0)
				{c=null;}
				con.close();
			} catch (SQLException e1) {
				try {con.close();} catch (SQLException e2) {
				e2.printStackTrace();
				}
				e1.printStackTrace();
				}
		return c;
	}
}
