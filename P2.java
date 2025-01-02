
import java.sql.*;

class Student {
    int rollno;
    String name;
    int marks;

    public Student(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
}

public class P2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/p2db";
        String username = "root";
        String password = "root123";
        String query = "INSERT INTO students(rollno, name, marks) VALUES (?, ?, ?)";

        // Load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create students
            Student s1 = new Student(12, "Ankit", 97);
            Student s2 = new Student(13, "Anuj", 78);
            Student s3 = new Student(14, "Abhi", 86);

            // Use PreparedStatement for executing the query
            PreparedStatement pstmt = con.prepareStatement(query);

            // Insert each student's data
            pstmt.setInt(1, s1.rollno);
            pstmt.setString(2, s1.name);
            pstmt.setInt(3, s1.marks);
            pstmt.executeUpdate();

            pstmt.setInt(1, s2.rollno);
            pstmt.setString(2, s2.name);
            pstmt.setInt(3, s2.marks);
            pstmt.executeUpdate();

            pstmt.setInt(1, s3.rollno);
            pstmt.setString(2, s3.name);
            pstmt.setInt(3, s3.marks);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully!");

            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

