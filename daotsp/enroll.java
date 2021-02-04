package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    public students                 Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
    
        // perform all the necessary data loading from DB
    public enroll() {
        this.Student = new students();
        this.EnrollmentList.clear();
        this.CourseList.clear();
    };      
    
       // clears enrollment data of the student 
    public int clearEnrollment ()   { 
        EnrollmentList.clear();
        return 0;
    }
    
       // load valid courses into the course list
    public int loadCourses ()       {   
        try {
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            // get all the courses that the student is eligible to take and have not taken
            // student id and courseid not in enroll AND degreeid of student is same as degreeid of course
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid,degree FROM coursedegree cd WHERE degree = ? AND courseid NOT IN (SELECT courseid FROM enrollment e WHERE studentid = ? AND cd.courseid = e.courseid)");
            pstmt.setString    (1, Student.degreeid );
            pstmt.setInt       (2, Student.studentid);
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                coursedegree temp = new coursedegree();
                temp.courseid = rs.getString("courseid");
                temp.degree = rs.getString("degree");
                //System.out.println(temp.courseid);
                CourseList.add(temp);
            }
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    }
    
     // saves enrollment data into the Database
    public int confirmEnrollment()  { 
        for(enrollment e: EnrollmentList)
            e.addRecord();
        clearEnrollment();
        return 1;
    }  
    
    public static void main(String args[]){
//        students student_test = new students();
//        student_test.completename = "Complete Name";
//        student_test.degreeid = "BSCS";
//        student_test.studentid = 11912312;
//        enroll enroll_test = new enroll();
//        enroll_test.Student = student_test;
//        enroll_test.loadCourses();
//        for(coursedegree cd : enroll_test.CourseList){
//            System.out.println(cd.courseid + " " + cd.degree + "\n");
//        }
//        
    }
    
}
