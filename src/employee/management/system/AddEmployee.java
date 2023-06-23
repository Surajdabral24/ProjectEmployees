
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    Random rm = new Random();
    int number = rm.nextInt(999999);
    JTextField tfname,tffname,tfsalary,tfdesignation,tfphone,tfaddress,tfemail,tfaadhar;
    JDateChooser dcdob;
    JLabel lemployeeid;
    JComboBox cbeducation;
    JButton add,back;
    
    AddEmployee(){
      getContentPane().setBackground(Color.white);
      setLayout(null);
      
      JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
      heading.setBounds(320,30,500,50);
      heading.setFont(new Font("SAN_SARIF",Font.BOLD,25));
      add(heading);
      
      JLabel labelname = new JLabel("Name");
      labelname.setBounds(50,150,150,30);
      labelname.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelname);
      
      tfname = new JTextField();
      tfname.setBounds(200,150,150,30);
      add(tfname);
      
      JLabel labelfname = new JLabel("FName");
      labelfname.setBounds(450,150,150,30);
      labelfname.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelfname);
      
      tffname = new JTextField();
      tffname.setBounds(600,150,150,30);
      add(tffname);
      
      JLabel labeldob = new JLabel("DOB");
      labeldob.setBounds(50,200,150,30);
      labeldob.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labeldob);
      
      dcdob = new JDateChooser();
      dcdob.setBounds(200,200,150,30);
      add(dcdob);
      
      JLabel labelsalary = new JLabel("Salary");
      labelsalary.setBounds(450,200,150,30);
      labelsalary.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelsalary);
      
      tfsalary = new JTextField();
      tfsalary.setBounds(600,200,150,30);
      add(tfsalary);
      
      JLabel labeladdress = new JLabel("Address");
      labeladdress.setBounds(50,250,150,30);
      labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labeladdress);
      
      tfaddress = new JTextField();
      tfaddress.setBounds(200,250,150,30);
      add(tfaddress);
      
      JLabel labelphone = new JLabel("Phone No.");
      labelphone.setBounds(450,250,150,30);
      labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelphone);
      
      tfphone = new JTextField();
      tfphone.setBounds(600,250,150,30);
      add(tfphone);
      
      JLabel labelemail = new JLabel("Email Address");
      labelemail.setBounds(50,300,150,30);
      labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelemail);
      
      tfemail = new JTextField();
      tfemail.setBounds(200,300,150,30);
      add(tfemail);
      
      JLabel labeleducation = new JLabel("Highest Education");
      labeleducation.setBounds(450,300,150,30);
      labeleducation.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labeleducation);
      
      String course[] = {"10th","12th/Diploma","Under Graduation","Post Graduation"};
      cbeducation = new JComboBox(course);
      cbeducation.setBounds(600,300,150,30);
      add(cbeducation);
      
      JLabel labeldesignation= new JLabel("Designation");
      labeldesignation.setBounds(50,350,150,30);
      labeldesignation.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labeldesignation);
      
      tfdesignation = new JTextField();
      tfdesignation.setBounds(200,350,150,30);
      add(tfdesignation);
      
      JLabel labelaadhar = new JLabel("Aadhar No.");
      labelaadhar.setBounds(450,350,150,30);
      labelaadhar.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelaadhar);
      
      tfaadhar = new JTextField();
      tfaadhar.setBounds(600,350,150,30);
      add(tfaadhar);
      
      JLabel labelemployeeid= new JLabel("Employee Id");
      labelemployeeid.setBounds(50,400,150,30);
      labelemployeeid.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelemployeeid);
      
      lemployeeid = new JLabel("" + number);
      lemployeeid.setBounds(200,400,150,30);
      lemployeeid.setFont(new Font("SERIF",Font.PLAIN,20));
      add(lemployeeid);
      
      add = new JButton("Add Details");
      add.setBounds(250,500,150,30);
      add.setBackground(Color.BLACK);
      add.setForeground(Color.white);
      add.addActionListener(this);
      add(add);
      
      back = new JButton("Back");
      back.setBounds(450,500,150,30);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.white);
      back.addActionListener(this);
      add(back);
      
      setSize(900,650);
      setLocation(300,50);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String name = tfname.getText();
            String fname = tffname.getText();
            String d = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String employeeid = lemployeeid.getText();
            try{
                
                Conn con = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+d+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+employeeid+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                
               e.printStackTrace();
            }
        }else
        {
           setVisible(false);
           new Home();
        }
    }
    public static void main(String args[])
    {
        new AddEmployee();
    }
}
