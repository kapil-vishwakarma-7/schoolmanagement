/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmt;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Kapil
 */
public class SAttendance extends JFrame{
    private Container container;
       public SAttendance(){
        setVisible(true);
           setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Staff Attendance");
        init();
        add(container);
        revalidate();
    
    }
    private void init(){
        container = new Container();
        setData();
    }
    private void setData(){
        LinkedList<Teacher> list = new Sql(this).getTeachers();
        LinkedList<JCheckBox> jc = new LinkedList<>();
        int x=10,y=100;
        for(int i=0;i<list.size();i++){
            Teacher t = list.get(i);
            JCheckBox j = new JCheckBox(t.getName(),true);
            j.setBounds(10,i*70, 100,100);
            jc.add(j);
            container.add(j);

        }
        JButton btn = new JButton("Submit");
        btn.setBounds(120, 350, 150, 50);
        container.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markAttendance(list,jc);
            }
        });
        
        
    }
    
    private void markAttendance(LinkedList<Teacher> list, LinkedList<JCheckBox> jc){
        for(int i=0;i<list.size();i++){
            Teacher teacher = list.get(i);
            JCheckBox j = jc.get(i);
            int present = (j.isSelected() ? 1 : 0);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date  d  = new java.util.Date();
            
            if(new Sql(this).setStaffAttendance(dateFormat.format(d),teacher.getId(),present)){
            }
            else{
                JOptionPane.showMessageDialog(this, "Attendance cannot updated.");
                return;
            }
                
        }
        JOptionPane.showMessageDialog(this, "Attendance is Updated.");
    }
    
}
