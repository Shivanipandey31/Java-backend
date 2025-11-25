//DAO= Data Access Object
/*It is a design pattern used to separate:
✔ Business logic (what your program does)
from
✔ Database logic (how data is fetched)
So your main code doesn’t contain SQL.
All SQL is inside a separate class called DAO. */

public class JdbcDaoDemo {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        Student s1 = dao.getStudent(2);

        System.out.println("Student Name : " + s1.name);
    }
}
