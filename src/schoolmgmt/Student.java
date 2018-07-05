package schoolmgmt;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Student {
   private int id,_class,rollNo,scholarNumber;

    public int getStudentClass() {
        return _class;
    }

    public int getRollNo() {
        return rollNo;
    }
    private double fees;
    private String dist,fname,lName,mName,fatherName,motherName,
                DOB,category,gender,
                studentContact,fatherContact,email,localAddress,permanentAddress,
                eadharNo,samagraId,familyId,city,pinCode,classCat,previousSchool,state,addmissionYear,
            bankName,accountNumber,IFSC;
    
    public String getBankName() {
        return bankName;
    }

    public void setClass(int _class) {
        this._class = _class;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIFSC() {
        return IFSC;
    }

    public int getId() {
        return id;
    }


    public void setIFSC(String IFSC) {
        this.IFSC = IFSC;
    }

    public String getAddmissionYear() {
        return addmissionYear;
    }

    public void setAddmissionYear(String addmissionYear) {
        this.addmissionYear = addmissionYear;
    }

    public int getScholarNumber() {
        return scholarNumber;
    }

    public void setScholarNumber(int scholarNumber) {
        this.scholarNumber = scholarNumber;
    }

    public String getClassCat() {
        return classCat;
    }

    public void setClassCat(String classCat) {
        this.classCat = classCat;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Student(){
    
    }
    public Student(ResultSet resSet) throws SQLException{
            id = resSet.getInt(1);
            fees = (resSet.getDouble("fees"));
           _class = (resSet.getInt("class"));
           classCat = resSet.getString("classcat");
           rollNo = (resSet.getInt("rollNo"));
           fname = (resSet.getString("fName"));
           mName = (resSet.getString("mName"));
           lName = (resSet.getString("lName"));
           fatherName = (resSet.getString("fatherName"));
           motherName = (resSet.getString("motherName"));
           DOB = (resSet.getString("DOB"));
           gender = (resSet.getString("gender"));
           category=(resSet.getString("category"));
           email = (resSet.getString("email"));
           localAddress =(resSet.getString("localAddress"));
           permanentAddress =(resSet.getString("PermanentAddress"));
           eadharNo = (resSet.getString("eadharNo"));
           samagraId = (resSet.getString("samagraId"));
           familyId = (resSet.getString("familyId"));
           studentContact = (resSet.getString("studentContact"));
           fatherContact = (resSet.getString("fatherContact"));
           city = (resSet.getString("city"));
           pinCode = (resSet.getString("pincode"));
           dist = (resSet.getString("dist"));
           scholarNumber = resSet.getInt("scholar_number");
           accountNumber  = resSet.getString("account_number");
           bankName  = resSet.getString("bank_name");
           IFSC  = resSet.getString("bank_ifsc");
           previousSchool  = resSet.getString("previous_school");
           state = resSet.getString("state");
    }
    public String getStudentContact() {
        return studentContact;
    }

    public String getFatherContact() {
        return fatherContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public void setFatherContact(String FatherContact) {
        this.fatherContact = FatherContact;
    }


    public String getDist() {
        return dist;
    }

    
    public double getFees() {
        return fees;
    }
    public String getFname() {
        return fname;
    }
    public String getlName() {
        return lName;
    }
    public String getmName() {
        return mName;
    }
    public String getFatherName() {
        return fatherName;
    }
    public String getMotherName() {
        return motherName;
    }
    public String getDOB() {
        return DOB;
    }
    public String getCategory() {
        return category;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public String getLocalAddress() {
        return localAddress;
    }
    public String getPermanentAddress() {
        return permanentAddress;
    }
    public String getEadharNo() {
        return eadharNo;
    }
    public String getSamagraId() {
        return samagraId;
    }
    public String getFamilyId() {
        return familyId;
    }
    public String getCity() {  return city; }
    public String getPinCode() {return pinCode;}

    public void setFees(double fees) {
        this.fees = fees;
    }



    public void setDist(String dist) {
        this.dist = dist;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setEadharNo(String eadharNo) {
        this.eadharNo = eadharNo;
    }

    public void setSamagraId(String samagraId) {
        this.samagraId = samagraId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
}



class Report{
    int id,reciptNo,sClass;
    double amount;
    String name,contactNo,through,time,purpose,comment,classcat;
    public Report(){}
    public Report(int id, int reciptNo, double amount, String name,int sClass, String contactNo, String through, String time, String purpose, String comment) {
        this.id = id;
        this.reciptNo = reciptNo;
        this.amount = amount;
        this.name = name;
        this.sClass = sClass;
        this.contactNo = contactNo;
        this.through = through;
        this.time = time;
        this.purpose = purpose;
        this.comment = comment;
    }

    public void setClasscat(String classcat) {
        this.classcat = classcat;
    }

    public String getClasscat() {
        return classcat;
    }

    public Report(ResultSet res){
        try{
            this.reciptNo = res.getInt(1);
            this.id = res.getInt(2);
            this.name = res.getString(3);
            this.sClass = res.getInt(4);
            this.contactNo = res.getString(5);
            this.through = res.getString(6);
            this.amount = res.getDouble(7);
            this.purpose= res.getString(8);
            this.comment = res.getString(9);
            this.time = String.valueOf(res.getTimestamp(10));
            this.classcat = res.getString(11);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public int getId() {
        return id;
    }

    public int getReciptNo() {
        return reciptNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReciptNo(int reciptNo) {
        this.reciptNo = reciptNo;
    }

    public void setsClass(int sClass) {
        this.sClass = sClass;
    }

    public int getsClass() {
        return sClass;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setThrough(String through) {
        this.through = through;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getThrough() {
        return through;
    }

    public String getTime() {
        return time;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getComment() {
        return comment;
    }
    
}
class Teacher {
    

  private  int id,leaves,experience;
  private  String name,contact,from,to,subject,qualification,address;

    public int getExperience() {
        return experience;
    }
    public Teacher (ResultSet res){
        try{
            id   = res.getInt(1);
            name = res.getString(2);
            contact = res.getString(3);
            salary  = res.getDouble(4);
            amount  = res.getDouble(5);
            leaves = res.getInt(6);
            from = String.valueOf(res.getDate(7));
            to   = String.valueOf(res.getDate(8));
            qualification = res.getString(10);
            experience = res.getInt(11);
            subject = res.getString(12);
            address = res.getString(13);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Teacher(int id, int leaves, int experience, String name, String contact, String from, String to, String subject, String qualification, String address,double salary, double amount) {
        this.id = id;
        this.leaves = leaves;
        this.experience = experience;
        this.name = name;
        this.contact = contact;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.qualification = qualification;
        this.salary = salary;
        this.amount = amount;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    double salary ,amount;

    public void setLeaves(int leaves) {
        this.leaves = leaves;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeaves() {
        return leaves;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double getAmount() {
        return amount;
    }
}


class StudentDetails{
    int id,student_id,year,cl;
    double percentage;
    String classcat,board,school;

    public StudentDetails(int student_id, int year, int cl, double percentage, String classcat, String board, String school) {
        this.student_id = student_id;
        this.year = year;
        this.cl = cl;
        this.percentage = percentage;
        this.classcat = classcat;
        this.board = board;
        this.school = school;
    }

    public StudentDetails(int id, int student_id, int year, int cl, double percentage, String classcat, String board, String school) {
        this.id = id;
        this.student_id = student_id;
        this.year = year;
        this.cl = cl;
        this.percentage = percentage;
        this.classcat = classcat;
        this.board = board;
        this.school = school;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setClasscat(String classcat) {
        this.classcat = classcat;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getYear() {
        return year;
    }

    public int getCl() {
        return cl;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getClasscat() {
        return classcat;
    }

    public String getBoard() {
        return board;
    }

    public String getSchool() {
        return school;
    }

}
class StaffPaymentRecipt{
    private int id,teacher_id;
    private String comment,date;
    private double amount;

    public StaffPaymentRecipt(int id, int teacher_id, String comment, String date, double amount) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.comment = comment;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}