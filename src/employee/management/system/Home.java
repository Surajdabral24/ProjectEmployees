

package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton add,update,remove,view;
    Home()
    {
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1100, 630,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1100,630);
       add(image);
       
       JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
       heading.setBounds(100,30,450,60);
       heading.setFont(new Font("Raleway",Font.BOLD,25));
       heading.setForeground(Color.white);
       image.add(heading);
       
       add = new JButton("Add Employee");
       add.setBounds(100, 100, 140, 40);
       add.addActionListener(this);
       image.add(add);
       
       update = new JButton("Update Employee");
       update.setBounds(100,200,140,40);
       update.addActionListener(this);
       image.add(update);
       
       view = new JButton("View Employee");
       view.setBounds(330,100,140,40);
       view.addActionListener(this);
       image.add(view);
       
       remove = new JButton("Remove Employee");
       remove.setBounds(330, 200, 140, 40);
       remove.addActionListener(this);
       image.add(remove);
       
       setVisible(true);
       setSize(1100,630);
       setLocation(200,60);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()== add){
           setVisible(false);
           new AddEmployee();
       
       }else if(ae.getSource()== update){
           setVisible(false);
           new ViewEmployee();
       
       }else if(ae.getSource()== view){
           setVisible(false);
           new ViewEmployee();
       
       }else{
           setVisible(false);
           new RemoveEmployee();
       }
    }
    
    public static void main(String args[])
    {
       new Home();
    }
}
