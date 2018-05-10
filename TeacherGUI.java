import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TeacherGUI extends JPanel{
  JFrame frame = new JFrame ("Music Sign Out");
  public TeacherGUI(){
    frame.setSize(400,300);
    
    JPanel panel = new JPanel();
    JLabel question = new JLabel ("What would you like to do?");
    JButton back = new JButton("Go back");
    JButton recent = new JButton ("View recent actions");
    JButton edit = new JButton ("Edit items");
    JButton delete = new JButton ("Delete item"); //delete the item that the user is on right now
    JButton add = new JButton ("Add item");
    
    recent.addActionListener(new RecentListener());
    edit.addActionListener(new EditListener());
    add.addActionListener(new AddListener());
    delete.addActionListener(new DeleteListener());
    back.addActionListener(new BackListener());
    
    panel.add(question);
    panel.add(back);
    panel.add(recent);
    panel.add(edit);
    panel.add(add);
    panel.add(delete);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.setVisible (true);
  }
  class BackListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      frame.setVisible(false);
      frame.dispose();
      new MenuGUI();
    }
  }
  class EditListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new Edit();
    }
  }
  class RecentListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new Recent();
    }
  }
  
  class AddListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new Add();
    }
  }
  //deletes the item that the user is on
  class DeleteListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      //there are items in the list
      if (MusicResource.getItems().size()>0){ 
        String name = JOptionPane.showInputDialog(frame, "Name of the item to be deleted?");
        if (name != null){
          DoubleLinkedList<Items> list = MusicResource.getItems();
          //check if item exists
          Items tempItem = MusicResource.checkItem(name, list);
          if (tempItem == null){
            JOptionPane.showMessageDialog(null, "Not found");
          }
          else {
            //check if item is taken out or at repairs
            if (tempItem.getCondition()==false ||tempItem.getPerson()!=-1 ){
              JOptionPane.showMessageDialog(null, "Item is currently taken out or at repairs! Cannot delete.");
            }
            //item is free and in good condition
            else{
              MusicResource.getItems().remove(list.indexOf(tempItem)); //remove the item
              JOptionPane.showMessageDialog(null, "Item successfully removed!");
            }
          }
        }
      }
    }
  }
}