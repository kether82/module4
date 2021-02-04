/* 
    Author: Ivan Lim
*/
package enrollment;
import java.sql.*;

public class coursedegree {
    public String courseid;
    public String degree;
    
    public coursedegree () {
        courseid = "";
        degree = "";
    };
    public int modRecord()  {
        try {
                Connection conn;     
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

                System.out.println("Connection Successful");

                PreparedStatement pstmt = conn.prepareStatement("UPDATE coursedegree " +
                                                                "SET  courseid = ?" + 
                                                                "WHERE courseid = ?");
                pstmt.setString    (1, courseid );
                pstmt.setString    (2, courseid );
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
    public int delRecord()  { 
        try {
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM coursedegree WHERE courseid = ?");
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
    }
    public int addRecord()  {
        try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO coursedegree(courseid, degree) VALUES (?,?)");
            // 5. Supply the statement with values
            pstmt.setString    (1, courseid );
            pstmt.setString (2, degree);
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

            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid,degree FROM coursedegree WHERE courseid = ?");

            pstmt.setString    (1, courseid);

            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                courseid = rs.getString("courseid");
                degree = rs.getString("degree");
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
    
    public static void main(String args[]) {
//       coursedegree tester = new coursedegree();
//       tester.courseid = "id123";
//       tester.degree = "deg123";
//       tester.addRecord(); done
//       tester.viewRecord();
//       System.out.println(tester.degree);
//       tester.degree = "deg123";
//       tester.viewRecord();
//       System.out.println(tester.degree);
//       tester.modRecord();
//       tester.delRecord();
    }
}
