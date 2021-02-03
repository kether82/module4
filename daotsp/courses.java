package enrollment;
import java.sql.*;
import java.util.*;

public class courses {
    String courseid;
    String coursename;
    String department;
    ArrayList<courses> courses_list = new ArrayList<>();
    public courses () {
        courseid = "";
        coursename ="";
        department ="";
        courses_list.clear();
    };
    public int modRecord()  {
        try {
                Connection conn;     
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

                System.out.println("Connection Successful");

                PreparedStatement pstmt = conn.prepareStatement("UPDATE courses   " +
                                                                "SET  coursename = ?, department = ?" + 
                                                                "WHERE courseid = ?   ");
                pstmt.setString    (1, coursename );
                pstmt.setString    (2, department );
                pstmt.setString    (3, courseid);
                // 6. Execute the SQL Statement
                pstmt.executeUpdate();   
                pstmt.close();
                conn.close();
                return 1;
            } catch (SQLException e) {
                System.out.println(e.getMessage());  
                return 0;
            } 
    }
    public int delRecord()  { 
        try {
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM courses WHERE courseid = ?");
            pstmt.setString    (1, courseid );
            // 6. Execute the SQL Statement
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        } 
    };
    public int addRecord()  {
        try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO courses(courseid, coursename, department) VALUES (?,?,?)");
            // 5. Supply the statement with values
            pstmt.setString    (1, courseid );
            pstmt.setString    (2, coursename);
            pstmt.setString    (3, department);
            // 6. Execute the SQL Statement
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        } 
    }
    public int viewRecord() { 
    try {
            Connection conn;  
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses WHERE courseid = ?");

            pstmt.setString    (1, courseid);

            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                courseid = rs.getString("courseid");
                coursename = rs.getString("coursename");
                department = rs.getString("department");
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }    
    }
    public int viewAllRecords(){
        try {
            Connection conn;  
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses");

            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                courses tmp = new courses();
                tmp.courseid = rs.getString("courseid");
                tmp.coursename = rs.getString("coursename");
                tmp.department = rs.getString("department");
                courses_list.add(tmp);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        } 
    }
    // add get all courses
    public static void main(String args[]) {
        courses tester = new courses();
//        tester.courseid = "id123";
//        tester.coursename = "name123";
//        tester.department = "dep123";
//        tester.addRecord();
//        tester.department = "dep123";
//        tester.viewRecord();
//        System.out.println(tester.department);
//      tester.degreename = "mod123";
//        tester.modRecord();
//        tester.delRecord();
//         tester.viewAllRecords();
//         for(int i = 0; i < tester.courses_list.size(); i++){
//             System.out.println(tester.courses_list.get(i).courseid);
//         }
    }
}
