import java.sql.*;

public class jdbcUpdateTest {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "developer";		
		String pass = "developer";

		try {
			// Get a connection to database
			conn = DriverManager.getConnection(dbUrl, user, pass);
			
			// Create a statement
			stmt = conn.createStatement();

			// Call helper method to display the employee's information
			System.out.println("BEFORE THE UPDATE...");
			displayEmployee(conn, "John", "Doe");
			
			// UPDATE the employee
			System.out.println("\nEXECUTING THE UPDATE FOR: John Doe\n");
			
			int rowsAffected = stmt.executeUpdate(
					"update employees " +
					"set email='john.doe@bar.com' " + 
					"where last_name='Doe' and first_name='John'");
			
			// Call helper method to display the employee's information
			System.out.println("AFTER THE UPDATE...");
			displayEmployee(conn, "John", "Doe");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(conn, stmt, res);
		}
	}

	private static void displayEmployee(Connection conn, String firstName, String lastName) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			// Prepare statement
			stmt = conn
					.prepareStatement("select last_name, first_name, email from employees where last_name=? and first_name=?");

			stmt.setString(1, lastName);
			stmt.setString(2, firstName);
			
			// Execute SQL query
			res = stmt.executeQuery();

			// Process result set
			while (res.next()) {
				String theLastName = res.getString("last_name");
				String theFirstName = res.getString("first_name");
				String email = res.getString("email");
			
				System.out.printf("%s %s, %s\n", theFirstName, theLastName, email);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(stmt, res);
		}

	}

	private static void close(Connection conn, Statement stmt,
			ResultSet res) throws SQLException {
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

	private static void close(Statement stmt, ResultSet res)
			throws SQLException {

		close(null, stmt, res);
	}	
}
