/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmt;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author kapil
 */
public class Sql {
    private Connection conn;
    private Statement stmt;
    private ResultSet resSet;
    private PreparedStatement pstmt;
    private JFrame window; 
    public Sql(){
    
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost","root","");
        stmt = conn.createStatement();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    public Sql(JFrame window){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost","root","");
        stmt = conn.createStatement();
        this.window=window;
        }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(window, "Sql server not Connecting");
            e.printStackTrace();}
    }
    public LinkedList<Student> getStudent(){
        LinkedList<Student> student = new LinkedList<Student>();
        int _class;
        String name ,father,father_mobile,city;
        try{
           String  sql= "select * from school_mgmt.student where flag=1 order by rollNo ";
           resSet = stmt.executeQuery(sql);
           while(resSet.next()){
           Student st = new Student(resSet);
           student.add(st);
           }
        }
        catch(Exception e) {
            e.printStackTrace(); 
            return null;
        }
        finally{
        return student;
        }
       
    }
    public LinkedList<Student> getStudentsByClass(int Cl,String classcat){
        try{
        LinkedList<Student> s = new LinkedList<>();
        pstmt = conn.prepareCall("select * from school_mgmt.student where class = ? and classcat = ? and flag=1");
        pstmt.setInt(1, Cl);
        pstmt.setString(2, classcat);
        resSet = pstmt.executeQuery();
           while(resSet.next()){
           Student st = new Student(resSet);
           s.add(st);
           }
        return s;
       }
    catch(Exception e){
         e.printStackTrace();
        }
      return null;
 } 
    public LinkedList<Student> searchStudent(String key){
            LinkedList<Student> student = new LinkedList<Student>();
            int _class,intKey;
            try{
                key = "%"+key+"%";
               pstmt = conn.prepareCall("select * from school_mgmt.student where CONCAT(id,fName,lName,fatherName,motherName,studentContact,fatherContact,eadharNo,city,dist,account_number,rollNo)LIKE ? and flag=1");
               pstmt.setString(1, key);
               resSet = pstmt.executeQuery();
               while(resSet.next()){
                       student.add(new Student(resSet));
              }

            }

            catch(Exception e) {
                e.printStackTrace(); 
                return null;
            }
            finally{
            return student;
            }
        }
    public boolean addStudent(Student student){
        try{
        PreparedStatement pStmt = conn.prepareCall("insert into school_mgmt.student(fName,mName,lName,class,classcat,rollNo,fees,fatherName,motherName,DOB,gender,category,email,localAddress,permanentAddress,eadharNo,samagraId,familyId,studentContact,fatherContact,city,pincode,dist,scholar_number,account_number,bank_name,bank_ifsc,previous_school,state,addmissionYear,id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pStmt.setString(5, student.getClassCat());
        pStmt.setInt(6,0);
        pStmt.setInt(4, student.getStudentClass());
        pStmt.setDouble(7, student.getFees());
        pStmt.setString(1,student.getFname());
        pStmt.setString(2,student.getmName());
        pStmt.setString(3,student.getlName());
        pStmt.setString(8,student.getFatherName());
        pStmt.setString(9,student.getMotherName());
        pStmt.setDate(10,Date.valueOf(student.getDOB()));
        pStmt.setString(11,student.getGender());
        pStmt.setString(12,student.getCategory());
        pStmt.setString(19,student.getStudentContact());
        pStmt.setString(20,student.getFatherContact());
        pStmt.setString(13,student.getEmail());
        pStmt.setString(14,student.getLocalAddress());
        pStmt.setString(15,student.getPermanentAddress());
        pStmt.setString(21,student.getCity());
        pStmt.setString(23,student.getDist());
        pStmt.setString(22,student.getPinCode());
        pStmt.setString(16,student.getEadharNo());
        pStmt.setString(17,student.getSamagraId());
        pStmt.setString(18,student.getFamilyId());
        pStmt.setString(25,student.getAccountNumber());
        pStmt.setString(26,student.getBankName());
        pStmt.setString(27,student.getIFSC());
        pStmt.setInt(24,student.getScholarNumber());
        pStmt.setString(28,student.getPreviousSchool());
        pStmt.setString(30,student.getAddmissionYear());
        pStmt.setString(29,student.getState());
        pStmt.setInt(31, student.getScholarNumber());
        pStmt.execute();
        return true;
     }
        catch(Exception e){e.printStackTrace();return  false;}
        
        }
    
    public boolean updateStudent(Student student){
        try{
           PreparedStatement pStmt = conn.prepareCall("update school_mgmt.student set  fName=?,mName=?,lName=?,"
                   + "class=?,classcat=?,fatherName=?,"
                   + "motherName=?,DOB=?,gender=?,category=?,email=?,localAddress=?,permanentAddress=?,eadharNo=?,"
                   + "samagraId=?,familyId=?,studentContact=?,fatherContact=?,city=?,pincode=?,dist=?,scholar_number=?,"
                   + "account_number=?,bank_name=?,bank_ifsc=?,previous_school=?,state=?,addmissionYear=? where id=?");
            pStmt.setString(5, student.getClassCat());
            pStmt.setInt(4, student.getStudentClass());
            pStmt.setString(1,student.getFname());
            pStmt.setString(2,student.getmName());
            pStmt.setString(3,student.getlName());
            pStmt.setString(6,student.getFatherName());
            pStmt.setString(7,student.getMotherName());
            pStmt.setDate(8,Date.valueOf(student.getDOB()));
            pStmt.setString(9,student.getGender());
            pStmt.setString(10,student.getCategory());
            pStmt.setString(17,student.getStudentContact());
            pStmt.setString(18,student.getFatherContact());
            pStmt.setString(11,student.getEmail());
            pStmt.setString(12,student.getLocalAddress());
            pStmt.setString(13,student.getPermanentAddress());
            pStmt.setString(19,student.getCity());
            pStmt.setString(21,student.getDist());
            pStmt.setString(20,student.getPinCode());
            pStmt.setString(14,student.getEadharNo());
            pStmt.setString(15,student.getSamagraId());
            pStmt.setString(16,student.getFamilyId());
            pStmt.setString(23,student.getAccountNumber());
            pStmt.setString(24,student.getBankName());
            pStmt.setString(25,student.getIFSC());
            pStmt.setInt(22,student.getScholarNumber());
            pStmt.setString(26,student.getPreviousSchool());
            pStmt.setString(28,student.getAddmissionYear());
            pStmt.setString(27,student.getState());
            pStmt.setInt(29, student.getId());
            pStmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
        e.printStackTrace();
        return false;
        }
    }
    public Student getStudentByRollNo(int roll_no){
      Student st=null;
           try{
         pstmt = conn.prepareCall("select * from school_mgmt.student where rollNo =? and flag=1");
         pstmt.setInt(1, roll_no);
         resSet = pstmt.executeQuery();
        if(resSet.next())
            st = new Student(resSet);
    }
       catch(Exception e){
       st = null;
       JOptionPane.showMessageDialog(window,"roll number not found");
       }
       finally{

           return st;

       }
    }
    void removeStudent(int id){
        try{
            pstmt = conn.prepareCall("update school_mgmt.student set flag=0 where id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            JOptionPane.showMessageDialog(window, "Student Removed");
        }
        catch(Exception e){e.printStackTrace();
        JOptionPane.showMessageDialog(window,"Cannot Remove Student.");
        }
    }
    public  Student getStudentByID(int id){
        Student student = null;
        try{
        pstmt = conn.prepareCall("select * from school_mgmt.student where id=? ");
        pstmt.setInt(1, id);
        resSet = pstmt.executeQuery();
        if(resSet.next())
        student = new Student(resSet);
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(window,"Student is not found.");
         e.printStackTrace();
        }
        return student;
    }
    public void insertFees(Report rp){
        try{
            pstmt = conn.prepareCall("insert into school_mgmt.fees_report(student_id,amount,purpose,comment,name,class,through,contact,classcat) values(?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, rp.getId());
            pstmt.setDouble(2,rp.getAmount());
            pstmt.setString(3, rp.getPurpose());
            pstmt.setString(4, rp.getComment());
            pstmt.setString(5, rp.getName());
            pstmt.setInt(6, rp.getsClass());
            pstmt.setString(7, rp.getThrough());
            pstmt.setString(8, rp.getContactNo());
            pstmt.setString(9,rp.getClasscat());
            pstmt.execute();
            pstmt  = conn.prepareCall("update school_mgmt.student set fees= fees - ? where id=?");
            pstmt.setDouble(1, rp.getAmount());
            pstmt.setInt(2, rp.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e ){
        e.printStackTrace();
        JOptionPane.showMessageDialog(window,"cannot Update Fees");
        try{
        stmt.executeQuery("ROLLBACK");
        }catch(Exception s){
        s.printStackTrace();
        }
        }
        }
    public void backupDataBase(){
        try{
            String query = "BACKUP DATABASE 'school_mgmt' TO DISK = 'c:\\backup'";
           stmt.execute(query);

        }
        catch(Exception e){e.printStackTrace();}
        }
    public double getFess(int cl,String classcat) {
       try{
           
            pstmt = conn.prepareCall("select fees from school_mgmt.fees where class=? and classcat=?");
            pstmt.setInt(1, cl);
            pstmt.setString(2, classcat);
            resSet = pstmt.executeQuery();
            if(resSet.next()){
                 return resSet.getDouble(1);
        }
       }catch(Exception e){
           e.printStackTrace();
       }
       return 0; 
    } 
    public LinkedList<Report> getReports(String date1,String date2){
        try{
             LinkedList<Report> rp = new LinkedList<Report>();
             pstmt = conn.prepareCall("select * from school_mgmt.fees_report where time >= ? AND time <= ?'23:59:59'");
             pstmt.setDate(1, Date.valueOf(date1));
             pstmt.setDate(2, Date.valueOf(date2));
             resSet = pstmt.executeQuery();
             while(resSet.next()){
             rp.add(new Report(resSet));
            }
            return rp;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(window,"Cannot Get Record , Sql Error");
            e.printStackTrace();
            return null;
        }

    }
    public LinkedList<Report> getReportsByClass(String date1,String date2,int cl,String classcat){
                try{
                      LinkedList<Report> rp = new LinkedList<Report>();
                      pstmt = conn.prepareCall("select * from school_mgmt.fees_report where time >= ? AND time <= ?'23:59:59' and class=? and classcat=?");
                      pstmt.setDate(1, Date.valueOf(date1));
                      pstmt.setDate(2, Date.valueOf(date2));
                      pstmt.setInt(3, cl);
                      pstmt.setString(4, classcat);
                      resSet = pstmt.executeQuery();
                      while(resSet.next()){
                      rp.add(new Report(resSet));
                     }
                     return rp;
                 }
                 catch(Exception e){
                     JOptionPane.showMessageDialog(window,"Cannot Get Record , Sql Error");
                     e.printStackTrace();
                     return null;
                 }
    }
    public Report getReportByReciptNumber(int r){
        try{
            pstmt = conn.prepareCall("select * from school_mgmt.fees_report where id=?");
            pstmt.setInt(1, r);
            resSet = pstmt.executeQuery();
            if(resSet.next()){
                Report rp = new Report(resSet);
                return rp;
            }
            return null;
        }catch(Exception e){
             e.printStackTrace();
             return null;
        }
    }
    public void test(){
    String a [] = {"kapil","vishwakarma"};
    }
    public void rollNumberAllocation() {
        try{
        stmt.execute("update school_mgmt.student set classcat=' N' where classcat='N'");
     ResultSet   resSet = stmt.executeQuery("select * from school_mgmt.student where flag=1 order by class,classcat, fname,lName");
        int count=0;
        String cl = " ";
        while(resSet.next()){
            if(!cl.equals(resSet.getString("class"))){
                count=1;
            }
            else{
                count++;
            }
            cl  = resSet.getString("class");
            String roll;
            int id = resSet.getInt("id");
            if(count < 10)
                roll = resSet.getString("class")+"00"+String.valueOf(count);
            else{
                roll = resSet.getString("class")+"0"+String.valueOf(count);
            }
            pstmt = conn.prepareCall("update school_mgmt.student set rollNo=? where id =?");
            pstmt.setString(1, roll);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
        
        stmt.execute("update school_mgmt.student set classcat='N' where classcat=' N'");
             JOptionPane.showMessageDialog(window, "RollNumber Allocation Successfully Done");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(window,"Error in RollNumber Allocation");
            e.printStackTrace();
        }
    }
    public boolean setFees(int cl , String classcat, double fees){
        try{
            pstmt = conn.prepareCall("update school_mgmt.fees set fees=? where class=? and classcat=?");
            pstmt.setInt(2, cl);
            pstmt.setDouble(1, fees);
            pstmt.setString(3, classcat);
            pstmt.execute();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean setStudentFees(int id,double fees){
        try{
            pstmt = conn.prepareCall("update school_mgmt.student set fees = ? where id=?");
            pstmt.setDouble(1, fees);
            pstmt.setInt(2, id);
            pstmt.execute();
            return true;            
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
//    staff
    public LinkedList<Teacher> getTeachers(){
    LinkedList<Teacher> list = new LinkedList<>();
    try{
        resSet = stmt.executeQuery("select * from school_mgmt.staff where flag=1");
        while(resSet.next()){
            Teacher t = new Teacher(resSet);
            list.add(t);
        }
        return list;
    }catch(Exception e){
        e.printStackTrace();
        return list;
    }  
  }
    public Teacher getTeacher(int id){
        try{
            Teacher teacher = null;
            pstmt = conn.prepareCall("select * from school_mgmt.staff where id=?");
            pstmt.setInt(1, id);
            resSet = pstmt.executeQuery();
            while(resSet.next()){
                teacher = new Teacher(resSet);
            }
            return teacher;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean addTeacher(Teacher teacher){
    try{
        pstmt = conn.prepareCall("insert into school_mgmt.staff(name,contact,salary,leaves,qualification,experience,subject,address) values(?,?,?,?,?,?,?,?)");
        pstmt.setString(1, teacher.getName());
        pstmt.setString(2,teacher.getContact());
        pstmt.setDouble(3, teacher.getSalary());
        pstmt.setInt(4, teacher.getLeaves());
        pstmt.setString(5, teacher.getQualification());
        pstmt.setInt(6, teacher.getExperience());
        pstmt.setString(7, teacher.getSubject());
        pstmt.setString(8,teacher.getAddress());
        pstmt.execute();
        return true;
    }
    catch(Exception e){
        e.printStackTrace();
        return false;
   }
  }  
    public boolean editTeacher(Teacher teacher){
        try{
            pstmt = conn.prepareCall("update school_mgmt.staff set name=? , contact=?, salary=?, leaves=? , qualification=?, experience=?,subject=?, address=? where id=?");
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getContact());
            pstmt.setDouble(3, teacher.getSalary());
            pstmt.setInt(4, teacher.getLeaves());
            pstmt.setString(5, teacher.getQualification());
            pstmt.setInt(6, teacher.getExperience());
            pstmt.setString(7, teacher.getSubject());
            pstmt.setString(8, teacher.getAddress());
            pstmt.setInt(9, teacher.getId());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeTeacher(int id){
        try{
            pstmt = conn.prepareCall("update school_mgmt.staff set flag=0 where id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //Student details
    public boolean addStudentDeatils(StudentDetails sd){
        try{
            pstmt = conn.prepareCall("insert into school_mgmt.student_details(student_id,class,classcat,board,school,year,percentage) values(?,?,?,?,?,?,?)");
            pstmt.setInt(1, sd.getStudent_id());
            pstmt.setInt(2, sd.getCl());
            pstmt.setString(3, sd.getClasscat());
            pstmt.setString(4, sd.getBoard());
            pstmt.setString(5,sd.getSchool());
            pstmt.setInt(6, sd.getYear());
            pstmt.setDouble(7, sd.getPercentage());
            pstmt.execute();
            return true;
        }catch(Exception e){
        
            e.printStackTrace();
            return false;
        }
    }  
    public boolean deleteStudentDeatils(int id){
        try{
            pstmt = conn.prepareCall("delete from school_mgmt.student_details where id=?");
            pstmt.setInt(1, id);
            pstmt.execute();
            return true;
        }catch(Exception e){
        
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateStudentDeatils(StudentDetails sd){
        try{
            pstmt = conn.prepareCall("update school_mgmt.student_details set class=?,classcat=?,board=?,school=?,year=?,percentage=? where id=?");
            pstmt.setInt(1, sd.getCl());
            pstmt.setString(2, sd.getClasscat());
            pstmt.setString(3, sd.getBoard());
            pstmt.setString(4,sd.getSchool());
            pstmt.setInt(5, sd.getYear());
            pstmt.setDouble(6, sd.getPercentage());
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
        
            e.printStackTrace();
            return false;
        }
    }
    public LinkedList<StudentDetails> getStudentDetails(int sid){
        try{
            LinkedList<StudentDetails> list = new LinkedList<>();
            pstmt = conn.prepareCall("select * from school_mgmt.student_details where student_id=?");
            pstmt.setInt(1, sid);
            resSet = pstmt.executeQuery();
            while(resSet.next()){
                StudentDetails sd = new StudentDetails(resSet.getInt(1), resSet.getInt(2), resSet.getInt(7), resSet.getInt(3), resSet.getDouble(8), resSet.getString(4), resSet.getString(5), resSet.getString(6));
                list.add(sd);
            }
            return list;
        }catch(Exception e){
            JOptionPane.showMessageDialog(window, "Cannot Get Student Scholar Details.");
            e.printStackTrace();
            return null;
            
        }
    }
    
    //staff_attendance
    public boolean setStaffAttendance(String d,int id,int present){
        try{
            pstmt = conn.prepareCall("select * from school_mgmt.staff_attendance where date =? and teacher_id=?");
            pstmt.setString(1, d);
            pstmt.setInt(2, id);
            resSet = pstmt.executeQuery();
             if(resSet.next()){
                return false;            
             }
            pstmt = conn.prepareCall("insert into school_mgmt.staff_attendance(date,teacher_id ,present) values(?,?,?)");
            pstmt.setString(1, d);
            pstmt.setInt(2, id);
            pstmt.setInt(3, present);
            pstmt.execute();
            return true;
        }
        catch(Exception e){
        e.printStackTrace();
        return false;
        }
    }
    public int getFacultyAttendance(int id,int month,int year){
        try{
        int n=0;
        String date1 = year+"-"+month+"-01";
        String date2 = year+"-"+month+"-31";
        pstmt = conn.prepareCall("select id from school_mgmt.staff_attendance where teacher_id=? and date>=? and date<=? and present=1");
        pstmt.setInt(1, id);
        pstmt.setString(2, date1);
        pstmt.setString(3, date2);
        resSet = pstmt.executeQuery();
            
        while(resSet.next()){
            n++;
        }
        return n;
        }catch(Exception e){
        e.printStackTrace();
        return 0;
        }
    }
    public int getWorkingDays(int month,int year){
        try{
            int n=0;
                String date1 = year+"-"+month+"-01";
                String date2 = year+"-"+month+"-31";
                String date=" ";
                pstmt = conn.prepareCall("select date from school_mgmt.staff_attendance where date>=? and date<=?");
                pstmt.setString(1, date1);
                pstmt.setString(2, date2);
                resSet = pstmt.executeQuery();
                while(resSet.next()){ 
                    if(!date.equals(resSet.getString("date"))){
                        n++;
                        date = resSet.getString("date");
                    }
                }
            return n;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public boolean removeFaculty(int id){
        try{
            pstmt = conn.prepareCall("update school_mgmt.staff set flag=0  where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean facultyAmountChange(int teacherId, double amount){
        try{
            pstmt = conn.prepareCall("update school_mgmt.staff set amount= amount + ? where id=?");
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, teacherId);
            pstmt.executeUpdate();
            System.out.println(teacherId+" "+amount);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public double calculateMonthlySalary(int teacherId, int month, int year){
        try{
            double amount=0;
            Teacher teacher = getTeacher(teacherId);
            int workingDays = getWorkingDays(month, year);
            int attendance = getFacultyAttendance(teacherId, month, year);
            double perDayAmount  = Double.valueOf(teacher.getSalary() / (double)workingDays);
            amount = attendance*perDayAmount;
            return amount;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0.0;
        }
    }
    public boolean addSalary(int month, int year,Double amount){
        try{
            pstmt = conn.prepareCall("insert into school_mgmt.salarytable(month_year,month,year,amount) values(?,?,?,?)");
            pstmt.setInt(1, Integer.valueOf(month+""+year));
            pstmt.setInt(2, month);
            pstmt.setInt(3, year);
            pstmt.setDouble(4, amount);
            pstmt.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkForSalaryMonth(int val){
        try{
            pstmt = conn.prepareCall("select * from school_mgmt.salarytable where month_year=?");
            pstmt.setInt(1, val);
            resSet = pstmt.executeQuery();
            while(!resSet.next()){
                return true;
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
//   staff_payment
    public boolean addStaffPayment(StaffPaymentRecipt rp){
        try{
            pstmt = conn.prepareCall("insert into school_mgmt.staff_payment(teacher_id,comment,amount) values(?,?,?)");
            pstmt.setInt(1,rp.getTeacher_id());
            pstmt.setString(2, rp.getComment());
            pstmt.setDouble(3, rp.getAmount());
            pstmt.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public LinkedList<StaffPaymentRecipt> getStaffPaymentRecipts(String date1,String date2){
        try{
            LinkedList<StaffPaymentRecipt> list = new LinkedList<>();
            pstmt = conn.prepareCall("select * from school_mgmt.staff_payment where date >= ? AND date <= ?'23:59:59'");
             pstmt.setDate(1, Date.valueOf(date1));
             pstmt.setDate(2, Date.valueOf(date2));
             resSet = pstmt.executeQuery();
             while(resSet.next()){
             list.add(new StaffPaymentRecipt(resSet.getInt(1), resSet.getInt(2), resSet.getString(4), String.valueOf(resSet.getTimestamp(5)), resSet.getDouble(3)));          
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public LinkedList<StaffPaymentRecipt> getStaffPaymentReciptsByTeacherId(String date1,String date2,int id){
        try{
            LinkedList<StaffPaymentRecipt> list = new LinkedList<>();
            pstmt = conn.prepareCall("select * from school_mgmt.staff_payment where date >= ? AND date <= ?'23:59:59' AND teacher_id=?");
             pstmt.setDate(1, Date.valueOf(date1));
             pstmt.setDate(2, Date.valueOf(date2));
             pstmt.setInt(3, id);
             resSet = pstmt.executeQuery();
             while(resSet.next()){
             list.add(new StaffPaymentRecipt(resSet.getInt(1), resSet.getInt(2), resSet.getString(4), String.valueOf(resSet.getTimestamp(5)), resSet.getDouble(3)));          
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean deleteStaffPaymentRecipt(int id){
        try{
            pstmt = conn.prepareCall("delete from school_mgmt.staff_payment where id=?");
            pstmt.setInt(1, id);
            pstmt.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}   
 