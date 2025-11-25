/*main() 
   ↓
Create StudentDAO
   ↓
dao.getStudent(7)
   ↓
Create Student object
   ↓
Connect to MySQL
   ↓
Execute SQL query
   ↓
Map DB result → Student object
   ↓
Return Student object to main()
   ↓
Print the student name*/



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    public Student getStudent(int rollno) {

        Student s = new Student();
        s.rollno = rollno;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/db";
            String uname = "root";
            String pass = "*******";

            Connection con = DriverManager.getConnection(url, uname, pass);

            // FIXED column name
            String query = "select username from student where userid = " + rollno;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                // FIXED column name
                s.name = rs.getString("username");
            }

            rs.close();
            st.close();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return s;
    }
}

