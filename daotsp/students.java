/*
Created by: Patrick Ong
*/

package enrollment;
import java.sql.*;
import java.util.*;

public class students {
    public int studentid;
    public String completename;
    public String degreeid;
    public  ArrayList<students> studList = new ArrayList<> ();
    public students () 
    {
        
        studentid=0;
        completename=" ";
        degreeid=" ";
        studList.clear();
        
    
    };
    public int modRecord()  
    {  try {
            // 1. Instantiate a connection variable
            Connection conn;     
            // 2. Connect to your DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE students   " +
                                                            "SET   completename = ? , " + 
                                                            "      degreeid   = ?   " + 
                                                            "WHERE studentid = ?   ");
            // 5. Supply the statement with values
            pstmt.setString (1, completename );
            pstmt.setString    (2, degreeid);
            pstmt.setInt    (3, studentid);
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE studentid=?");
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
        try{
            
            //instantiate a connection variable
            Connection conn;
            //connect to database
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            //print a notice if succesfully connected
            System.out.println("Connection successful");
            //prepare insert statement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students(studentid,completename,degreeid) VALUES (?,?,?)");
            //supply the statement with values
            
            pstmt.setInt(1, studentid);
            pstmt.setString(2, completename);
            pstmt.setString(3, degreeid);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            return 1;
        }
        catch(SQLException e)
        {
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students WHERE studentid=?");
            // 5. Supply the statement with values
            pstmt.setInt    (1, studentid );
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();   
            
            // 7. Get the results
            while (rs.next()) {
                studentid = rs.getInt("studentid");
                completename = rs.getString("completename");
                degreeid    = rs.getString("degreeid");
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
    
    //eto ung bago
    //gets the individual student that will drop a certain course
    public int getAStudent()
    {
      try {
            Connection conn; 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection Successful");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students s WHERE s.studentid = ?");
            pstmt.setInt    (1, studentid );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                studentid = rs.getInt("studentid");
                completename = rs.getString("completename");
                degreeid  = rs.getString("degreeid");
             
            }
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }  
    };
    
    
    
    
    public static void main(String args[]) 
    {
//        students st= new students();
//        //st.studentid= 119;
//        //st.completename= "Tico";
//        //st.degreeid= "CS-ST";
//        //st.addRecord();
//        
//        //st.studentid=119;
//        //st.completename="kyle";
//        //st.degreeid="BS-CS";
//        //st.modRecord();
//        
//        //st.studentid=119;
//        //st.delRecord();
//        
//        
//        //st.studentid=10100005;
//        //st.viewRecord();
//        //System.out.println (st.completename);
//        //System.out.println (st.degreeid);
//        //System.out.println (st.studentid);
//        
//        
//        
//         st.getAllStudents();
//        for (int i=0; i<st.studList.size(); i++) {
//            students a = new students();
//            a = st.studList.get(i);
//            System.out.println (a.completename);
//            System.out.println (a.degreeid);
//            System.out.println (a.studentid);
//            System.out.println ("-----");    
//        }
//       
    }
}
