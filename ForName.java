// Demonstration of how Class.forName() works

public class ForName {

    public static void main(String[] args) 
            throws Exception {

        /*
         * ==================================================
         * What does Class.forName("Pqr") do?
         * ==================================================
         *
         * ✔ It loads class Pqr into memory.
         * ✔ When a class is loaded, its STATIC BLOCK runs automatically.
         * ✔ It does NOT create an object → instance block does NOT run.
         *
         * This explains why, in JDBC, we use:
         *      Class.forName("com.mysql.cj.jdbc.Driver");
         *
         * → It loads the MySQL JDBC driver class
         * → The static block inside that driver registers it with DriverManager
         */
        
        // This will load class Pqr and execute only its static block
        Class.forName("Pqr");
        
        // If we want to see the instance block run, we must create an object:
        // new Pqr();  // uncomment this to see the instance block run
    }
}


/*
 * ==================================================
 * Class Pqr — used to demonstrate static + instance blocks
 * ==================================================
 */

class Pqr {
    
    // Static Block
    // Runs ONLY when the class is loaded into memory
    static {
        System.out.println("in Static");
    }

    // Instance Block
    // Runs each time an object of this class is created
    {
        System.out.println("in instance");
    }
}
