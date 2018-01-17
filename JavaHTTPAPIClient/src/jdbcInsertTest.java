import java.sql.*;

public class jdbcInsertTest {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String dbUrl = "jdbc:mysql://localhost:8889/demo?useSSL=false";
		String user = "developer";		
		String pass = "developer";

		try {
			// 1. Get a connection to database
			conn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a statement
			stmt = conn.createStatement();

			// 3. Insert a new employee
			System.out.println("Inserting a new employee to database\n");
			
			int rowsAffected = stmt.executeUpdate(
				"insert into employees " +
				"(last_name, first_name, email, department, salary) " + 
				"values " + 
				"('Doe', 'John', 'john.doe@foo.com', 'HR', 45000.00)");
			
			// 4. Verify this by getting a list of employees
			res = stmt.executeQuery("select * from employees order by last_name");
			
			// 5. Process the result set
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
