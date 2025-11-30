import java.sql.*;
//JDBS
//1.import java.sql.
//2. load and register the driver ->com.mysql.jdbc.Driver
//3. create connection
//4. create statement
//5. execute query
//6. process query
//7. close
public class DemoClass {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/db";
		String uname="root";
		String pass="*********";
//		String query="select username from student where userid=3";
//		String query="select * from student";
		String query="insert into student values(5,'Shivani')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection to the database
		Connection con=DriverManager.getConnection(url,uname, pass);
		 // Create a SQL statement object
		Statement st=con.createStatement();
		//Execute the SQL query and store the result in a ResultSet
		//ResultSet rs=st.executeQuery(query); //for DQL
		
		int count =st.executeUpdate(query); //used in DML (to find the number of rows getting affected
		
		//Move the cursor to the first row as it is not there by default
		//rs.next();
		
//		String name=rs.getString("username");
//		String userData=rs.getInt(1)+" : "+ rs.getString(2);
//		System.out.println(userData);
		
		//displaying all entries
//		String userData="";
//		while(rs.next()) {
//			userData=rs.getInt(1);
//			System.out.println(userData);
//		}
		
		//incase of insertion(DML)
		System.out.println(count + " rows affected");
		//rs.close();
		st.close();
		con.close();
	}
}


