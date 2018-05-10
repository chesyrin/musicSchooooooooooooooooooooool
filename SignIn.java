/* SignIn.java
 * Julia Zhao and Tasha Xiao
 * May 06 2018
 * Version 1.0.0
 * The GUI interface for a student who wants to sign an object in
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignIn {
  JFrame frame = new JFrame("Music Sign Out");
  JTextField question = new JTextField ("What would you like to sign in?");
  
  public SignIn(){
    frame.setSize (400,300);
    //Print to file once the window is closed
    frame.addWindowListener(new WindowAdapter(){
      public void windowClosing(java.awt.event.WindowEvent windowEvent){
        MusicResource.printFile(MusicResource.getItems());
      }
    });
    JPanel panel = new JPanel();

    JButton ok = new JButton ("OK");
    JButton back = new JButton ("Back");
    
    ok.addActionListener(new OkListener());
    back.addActionListener(new BackListener());
    
    panel.add(question);
    panel.add(ok);
    panel.add(back);
    frame.add(panel);
    frame.setVisible (true);
  }
  
  class OkListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      String name = question.getText();
      Items item = MusicResource.checkItem(name, MusicResource.getItems());
      //checks if item is found
      if (item == null){
        MenuGUI.createPopUp("This is not in the inventory!");
      }
      else{
        if (item.getPerson()==-1){
          MenuGUI.createPopUp("This has not been signed out!");
        }
        else{
          item.setPerson(-1);
          item.setDate(null);    
          MenuGUI.createPopUp("The database has been updated!");
        }
      }
    }
  }
  
  class BackListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      frame.setVisible(false);
      frame.dispose();
      new StudentGUI();
    }
  }
  public static void main (String [] args){
    new SignIn();
  }
}
