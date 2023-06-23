package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfeducation,tffname,tfsalary,tfdesignation,tfphone,tfaddress,tfemail,tfaadhar;
    JLabel lemployeeid;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId = empId;
      getContentPane().setBackground(Color.white);
      setLayout(null);
      
      JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
      heading.setBounds(320,30,500,50);
      heading.setFont(new Font("SAN_SARIF",Font.BOLD,25));
      add(heading);
      
      JLabel labelname = new JLabel("Name");
      labelname.setBounds(50,150,150,30);
      labelname.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelname);
      
      JLabel lblname = new JLabel();
      lblname.setBounds(200,150,150,30);
      add(lblname);
      
      JLabel labelfname = new JLabel("FName");
      labelfname.setBounds(450,150,150,30);
      labelfname.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelfname);
      
      JLabel lblfname = new JLabel();
      lblfname.setBounds(600,150,150,30);
      add(lblfname);
      
      JLabel labeldob = new JLabel("DOB");
      labeldob.setBounds(50,200,150,30);
      labeldob.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labeldob);
      
      JLabel lbldob = new JLabel();
      lbldob.setBounds(200,200,150,30);
      add(lbldob);
      
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
      
      tfeducation = new JTextField();
      tfeducation.setBounds(600,300,150,30);
      add(tfeducation);
      
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
      
      JLabel lblaadhar = new JLabel();
      lblaadhar.setBounds(600,350,150,30);
      add(lblaadhar);
      
      JLabel labelemployeeid= new JLabel("Employee Id");
      labelemployeeid.setBounds(50,400,150,30);
      labelemployeeid.setFont(new Font("SERIF",Font.PLAIN,20));
      add(labelemployeeid);
      
      lemployeeid = new JLabel();
      lemployeeid.setBounds(200,400,150,30);
      lemployeeid.setFont(new Font("SERIF",Font.PLAIN,20));
      add(lemployeeid);
      
      try{
          Conn c = new Conn();
          String query ="Select * from employee where employeeid = '"+empId+"'";
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next()){
            lblname.setText(rs.getString("name"));
            lblfname.setText(rs.getString("fname"));
            lbldob.setText(rs.getString("d"));
            tfsalary.setText(rs.getString("salary"));
            tfaddress.setText(rs.getString("address"));
            tfphone.setText(rs.getString("phone"));
            tfemail.setText(rs.getString("email"));
            tfeducation.setText(rs.getString("education"));
            tfdesignation.setText(rs.getString("designation"));
            lblaadhar.setText(rs.getString("aadhar"));
            lemployeeid.setText(rs.getString("employeeid"));
            
          }
      }catch(Exception e){
        e.printStackTrace();
      }
      add = new JButton("Update Details");
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
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
     
            try{
                
                Conn con = new Conn();
                String query = "update employee set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where employeeid = '"+empId+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details update successfully");
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
        new UpdateEmployee("");
    }
}

