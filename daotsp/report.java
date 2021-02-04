/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ccslearner
 */
public class report 
{
    
    public int term;
    public int schoolyear;
    public  ArrayList<enrollment> courseList = new ArrayList<> (); 
    public ArrayList<Integer> countList= new ArrayList<> (); 
    
    
    public report()
    {
       courseList.clear();
       countList.clear();
    }
    
    
    public int resetReport()
    {
       courseList.clear();
       countList.clear();
       return 1;
    }
    
    
    public int fillCourses()
    {
        try {
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            // get all the courses that the student is eligible to take and have not taken
            // student id and courseid not in enroll AND degreeid of student is same as degreeid of course
            PreparedStatement pstmt = conn.prepareStatement("SELECT distinct courseid FROM enrolldb.enrollment where schoolyear=? AND term=?");
            pstmt.setInt(1,schoolyear );
            pstmt.setInt(2,term);
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                enrollment temp= new enrollment();
                temp.schoolyear=schoolyear;
                temp.term=term;
                temp.courseid=rs.getString("courseid");
                courseList.add(temp);
                
             }
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    }
    
    
    
    public int fillCount()
    {
        try {
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            for(enrollment e : courseList)
            {
                 PreparedStatement pstmt = conn.prepareStatement("SELECT count(courseid) FROM enrolldb.enrollment where courseid= ? AND schoolyear=? AND term=?");
            pstmt.setString(1,e.courseid);
            pstmt.setInt(2,e.schoolyear );
            pstmt.setInt(3,e.term);
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                
                countList.add(rs.getInt("count(courseid)"));
                
             }
            
            pstmt.close();
                
            }
            // get all the courses that the student is eligible to take and have not taken
            // student id and courseid not in enroll AND degreeid of student is same as degreeid of course
           
           conn.close();
            
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    }
    
    
    public int generateReport()
    {
        resetReport();
        fillCourses();
        fillCount();
        return 1;
    }
    
    
    public static void main(String[] args)
    {
        report r= new report();
        
        r.schoolyear=20192020;
        r.term=2;
        
        
        r.generateReport();
        
        
         for(int i=0; i<r.courseList.size();i++)
         {
             String e= r.courseList.get(i).courseid;
             int num= r.countList.get(i);
             
             System.out.print(e + " "+  num);
         }
        
        
        
        
        
            
    }
    
}
