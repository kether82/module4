/* 
    Author: Nathan Rodriguez
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class drop {
  
    public students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<enrollment>    DropList        = new ArrayList<> ();

    public drop() {
    this.Student = new students();
    this.EnrollmentList.clear();
    this.DropList.clear();
    };                                   // perform all the necessary data loading from DB
    public int clearDrop ()         {   
        DropList.clear();
        return 0;
    }   // clears dropping data of the student
    public int loadEnrollment ()    {   
    try {
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            // get all the courses that the student is eligible to take and have not taken
            // student id and courseid not in enroll AND degreeid of student is same as degreeid of course
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, term, schoolyear FROM enrollment e WHERE studentid = ?");
            pstmt.setInt    (1, Student.studentid );
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                enrollment temp = new enrollment();
                temp.studentid = Student.studentid;
                temp.studentid=Student.studentid;

                temp.courseid = rs.getString("courseid");
                temp.term = rs.getInt("term");
                temp.schoolyear = rs.getInt("schoolyear");
                
                EnrollmentList.add(temp);
            }
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    }   // load enrollment data of the student 
    
    public int confirmDrop()        {   
    for(enrollment e: DropList)
        e.delRecord();
    return 1;
    }   // saves dropping data into the Database
    
    public static void main(String[] args){
//        students test = new students();
//        
//        test.studentid = 10100001;
//        test.completename = "Angela Reyes";
//        test.degreeid = "BSCS";
//        
//        drop droptest = new drop();
//        
//        droptest.Student = test;
//        droptest.loadEnrollment();
//        for(enrollment e:droptest.EnrollmentList)
//        {
//            System.out.println(e.courseid);
//            System.out.println(e.term);
//            System.out.println(e.schoolyear);
//            System.out.println("------------");
//        }
//        
    }
}