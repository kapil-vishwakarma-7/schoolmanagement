package schoolmgmt;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
/**
 *
 * @author kapil
 */
public class SchoolMgmt extends Thread {
  public static String schoolName="Shree Gandhi Kabir Higher Secoundary School, Chandbad, Sehore(M.P.) " ;
  public static String date ;
  public static String dateSql;
  public static void main(String[] args) {
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  DateFormat dateFormatSql = new SimpleDateFormat("yyyy-MM-dd");
  Date  d  = new Date();
  dateSql = String.valueOf(dateFormatSql.format(d));
  date=String.valueOf(dateFormat.format(d));
//  new Sql().rollNumberAllocation();
//  new MainWindow11();
//System.out.println(""+new Sql().checkForSalaryMonth(62017));
//new Staff();
  //new EditStudent();
//  new EditStudent();
//new Features().setVisible(true);
//  new DocxReader();
new LoginWindow();
//new StaffReports();
//new Staff();
//new AddFaculty();
//new StaffAttendance();
//new SAttendance();
//new ScholarDetails();
//new Profiler();

   
  }
  
}
