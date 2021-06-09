package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {
	public static Connection getConnection()
	{   Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@10.1.8.8:1521:xe","hr","hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}			
		return con;
	}
}
