import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/db";
		String uname="root";
		String pass="Hacker@2213402";
		int userId=7;
		String username="Shivani";
		String query="inse rt into student values (? , ?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection to the database
		Connection con=DriverManager.getConnection(url,uname, pass);
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, userId);
		st.setString(2, username);
		int count=st.executeUpdate();// returns how many rows were inserted
		System.out.println(count + " rows affected");
		st.close();
		con.close();
		
	}
}
/*
 * ================================
 * What is a PreparedStatement?
 * ================================
 *
 * ✔ PreparedStatement is used to execute SQL queries with parameters (?) safely.
 *
 * ✔ It is mainly used when:
 *      - You want to prevent SQL Injection attacks
 *      - You execute the SAME query multiple times with different values
 *      - You want faster performance (query is pre-compiled by the database)
 * 
 * ✔ Advantages over Statement:
 *      - Protects from SQL injection
 *      - Allows dynamic input using setInt(), setString(), etc.
 *      - Precompiled → faster execution
 */