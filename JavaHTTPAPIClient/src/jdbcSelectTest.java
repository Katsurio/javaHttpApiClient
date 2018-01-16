import java.sql.*;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class jdbcSelectTest {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "developer";		
		String pass = "developer";

		try {
			// 1. Get a connection to database
			conn = DriverManager.getConnection(dbUrl, user, pass);
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			stmt = conn.createStatement();
			
			// 3. Execute SQL query
			res = stmt.executeQuery("select * from employees");
			
			// 4. Process the result set
			while (res.next()) {
				System.out.println(res.getString("last_name") + ", " + res.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (res != null) {
				res.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
	}

}