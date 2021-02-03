package enrollment;
import java.sql.*;
import java.util.*;
public class enrollment {
    
    int studentid;
    String courseid;
    int term;
    int schoolyear;
    public  ArrayList<enrollment> enroList = new ArrayList<> ();
    
    public enrollment () 
    
    {
        studentid=0;
        courseid="";
        term=0;
        schoolyear=20202021;
        enroList.clear();
        
    };
    public int modRecord()  { 
    
    try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE enrollment   " +
                                                            "SET   courseid = ? , " + 
                                                            "      term  = ? ,  " + 
                                                            "      schoolyear=?  " +
                                                            "WHERE studentid = ?   ");
            // 5. Supply the statement with values
            
           
            pstmt.setString (1, courseid );
            pstmt.setInt    (2, term);
            pstmt.setInt    (3, schoolyear);
            pstmt.setInt(4, studentid);
            // 6. Execute the SQL Statement
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
        } 
    catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }         
    
    
    
    
    
    
    };
    public int delRecord()  { 
    
    
    try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM enrollment WHERE studentid=?");
            // 5. Supply the statement with values
            pstmt.setInt    (1, studentid);
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
    public int addRecord()  
    { 
        
        try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO enrollment(studentid,courseid,term,schoolyear) VALUES (?,?,?,?)");
            // 5. Supply the statement with values
            pstmt.setInt    (1, studentid);
            pstmt.setString (2, courseid);
            pstmt.setInt    (3, term);
            pstmt.setInt    (4, schoolyear);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enrollment WHERE studentid=?");
            // 5. Supply the statement with values
            pstmt.setInt    (1, studentid );
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();   
            
            // 7. Get the results
            while (rs.next()) {
                studentid = rs.getInt("studentid");
                courseid = rs.getString("courseid");
                term   = rs.getInt("term");
                schoolyear  = rs.getInt("schoolyear");
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
    
    
    public int viewAllEnrollment()
    {
        try {
            Connection conn; 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection Successful");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enrollment");
            ResultSet rs = pstmt.executeQuery();
            enroList.clear();
            while (rs.next()) {
                enrollment a = new enrollment();
                a.studentid = rs.getInt("studentid");
                a.courseid = rs.getString("courseid");
                a.term  = rs.getInt("term");
                a.schoolyear= rs.getInt("schoolyear");
               enroList.add(a);
            }
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }  
        
    };
    
    public static void main(String args[]) 
    {
        enrollment en= new enrollment();
        //en.studentid=10100005;
        //en.courseid="CCPROG3";
        //en.term=1;
        //en.schoolyear=20202021;
        //en.addRecord();
        
        //en.studentid=10100005;
        //en.viewRecord();
        //System.out.println(en.courseid);
        //System.out.println(en.schoolyear);
        //System.out.println(en.studentid);
        //System.out.println(en.term);

        //en.studentid=10100005;
        //en.delRecord();
        
        
       //en.studentid=10100005;
       //en.courseid="CCICOMP";
       //en.term=2;
       //en.schoolyear=20202021;
       //en.modRecord();
       
       
       en.viewAllEnrollment();
        for (int i=0; i<en.enroList.size(); i++) {
            enrollment a = new enrollment();
            a = en.enroList.get(i);
            
            System.out.println (a.studentid);
            System.out.println (a.courseid);
            System.out.println (a.term);
            System.out.println (a.schoolyear);
            System.out.println ("-----");    
        }
    }
}
