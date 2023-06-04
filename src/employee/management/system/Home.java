

package employee.management.system;

import javax.swing.*;
import java.awt.*;
public class Home extends JFrame {
    
    Home()
    {
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
       Image i2 = i1.getImage().getScaledInstance(750, 650,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,750,650);
       add(image);
       
       setVisible(true);
       setSize(750,650);
       setLocation(250,60);
    }
    
    public static void main(String args[])
    {
       new Home();
    }
}
