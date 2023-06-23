
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
    JTextField tuser,tpassword;
    Login()
    {
      getContentPane().setBackground(Color.white);
      setLayout(null);
      
      JLabel user=new JLabel("USERNAME");
      user.setBounds(40,20,100,30);
      add(user);
      
      tuser=new JTextField();
      tuser.setBounds(150,20,150,30);
      add(tuser);
      
      JLabel password=new JLabel("PASSWORD");
      password.setBounds(40,70,100,30);
      add(password);
      
      tpassword=new JTextField();
      tpassword.setBounds(150,70,150,30);
      add(tpassword);
      
      JButton login=new JButton("LOGIN");
      login.setBounds(150,140,150,30);
      login.setBackground(Color.black);
      login.setForeground(Color.white);
      login.addActionListener(this);
      add(login);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
      Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(350,20,200,200);
      add(image);
              
      setSize(600,300);
      setLocation(400,100);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       try{
           String username = tuser.getText();
           String pwd = tpassword.getText();
         
          Conn a = new Conn();
          String query = "select * from login where username = '"+username+"'and password = '"+pwd+"'";
        
          ResultSet rs;
           rs = a.s.executeQuery(query);
          
          if (rs.next())
          {
              setVisible(false);
              new Home();
              // next class
          }
         else
           {
              JOptionPane.showMessageDialog(null,"invalid username and password");
              setVisible(false);
            }
        }
        catch(Exception e)
       {
          e.printStackTrace();
       }
    }
    public static void main(String args[])
    {
        new Login();
    }
}
