package enrollment;
import java.sql.*;

public class degree {
    public String degreeid;
    public String degreename;
    
    public degree () {
        degreeid = "";
        degreename = "";
    };
    public int modRecord()  {
        try {
                Connection conn;     
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

                System.out.println("Connection Successful");

                PreparedStatement pstmt = conn.prepareStatement("UPDATE degree   " +
                                                                "SET  degreename   = ?" + 
                                                                "WHERE degreeid = ?   ");
                pstmt.setString    (1, degreename );
                pstmt.setString    (2, degreeid );
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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM degree WHERE degreeid = ?");
            pstmt.setString    (1, degreeid );
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO degree(degreeid, degreename) VALUES (?,?)");
            // 5. Supply the statement with values
            pstmt.setString    (1, degreeid );
            pstmt.setString (2, degreename);
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
    public int viewRecord() { 
        try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT degreeid,degreename FROM degree WHERE degreeid=?");
            // 5. Supply the statement with values
            pstmt.setString    (1, degreeid );
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();   
            
            // 7. Get the results
            while (rs.next()) {
                degreeid  = rs.getString("degreeid");
                degreename  = rs.getString("degreename");
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    };
    
    public static void main(String args[]) {
//        degree tester = new degree();
//        tester.degreeid = "deg123";
//        tester.degreename = "name123";
//        tester.addRecord();
//        tester.viewRecord();
//        System.out.println(tester.degreename);
        //tester.degreename = "mod123";
        //tester.modRecord();
//       tester.delRecord();
    }
}
