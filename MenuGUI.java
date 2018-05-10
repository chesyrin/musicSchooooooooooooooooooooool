/* MenuGUI.java
 * Julia Zhao and Tasha Xiao
 * May 02 2018
 * Version 1.0.0
 * GUI program for the menu
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuGUI extends JPanel{
  JFrame frame = new JFrame ("Music Sign Out");
  JButton teacher = new JButton ("Teacher");
  JButton student = new JButton ("Student");
  JButton inventory = new JButton ("Inventory");
  JButton quit = new JButton ("QUIT");
  
  public MenuGUI(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    JPanel panel = new JPanel (new FlowLayout ());
    JLabel label = new JLabel ("What would you like to do?");
    
    teacher.addActionListener(new TeacherListener());
    student.addActionListener(new StudentListener());
    inventory.addActionListener(new InventoryListener());
    quit.addActionListener(new QuitListener());
    
    panel.add(label);
    panel.add(teacher);
    panel.add(student);
    panel.add(inventory);
    panel.add(quit);
    frame.add(panel);
    
    frame.setVisible(true);
  }
  
  public static void createPopUp(String msg){
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel (msg);
    
    panel.add(label);
    frame.add(panel);
    
    frame.setSize(400, 100);
    frame.setVisible(true);
  }
  
  class StudentListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new StudentGUI();
      frame.dispose();
    }
  }
  class TeacherListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      //new TeacherGUI();
      frame.dispose();
    }
  }
  class InventoryListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new Inventory();
      frame.dispose();
    }
  }
  class QuitListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      MusicResource.printFile(MusicResource.getItems());
      //thank you
      System.exit(0);
    }
  }
  
//  public static void main(String[]args){
//    new MenuGUI();
//  }
  
}
