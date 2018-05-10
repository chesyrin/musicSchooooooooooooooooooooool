import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add extends JPanel implements ActionListener{
  JFrame frame2 = new JFrame("add");
  JPanel panel2 = new JPanel();
  JButton ok = new JButton("OK");
  JButton cancel = new JButton("Cancel");
  Items tempItem = new Items();
  
  JLabel nameLab = new JLabel("Name: ");
  JTextField name = new JTextField(10);
  JLabel descrLab = new JLabel("Description: ");
  JTextField descr = new JTextField(10);
  JLabel conditionLab = new JLabel("Condition: ");
  String[] condStrings = { "OK", "Not OK"};
  JComboBox condition = new JComboBox(condStrings);
  JLabel numLab = new JLabel("Number: ");
  JTextField num = new JTextField(10);
  JLabel statusLab = new JLabel("Status: ");
  String[] statStrings = { "Sheet music", "Instrument", "Other"};
  JComboBox status = new JComboBox(statStrings);
  
  DoubleLinkedList<Items> list = MusicResource.getItems();
  
  public Add(){

    frame2.setVisible(false);
    frame2.setSize(500,500);
    
    
    ok.addActionListener(this);
    cancel.addActionListener(this);
    
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
    panel2.add(nameLab);
    panel2.add(name);
    panel2.add(descrLab);
    panel2.add(descr);
    panel2.add(conditionLab);
    panel2.add(condition);
    panel2.add(numLab);
    panel2.add(num);
    panel2.add(statusLab);
    panel2.add(status);
    panel2.add(ok);
    panel2.add(cancel);
    
    frame2.add(panel2);
    frame2.setVisible(true);
    
    
  }

public void actionPerformed(ActionEvent e){
  if (e.getSource()== ok){
    Items tempItem = new Items();
    //check if num is numeric
    try  
    {
      int d = Integer.parseInt(num.getText()); 
      //check if name is already in list
      if (MusicResource.checkItem(name.getText(), list) != null){
        JOptionPane.showMessageDialog(null, "Cannot use this name; already in inventory.");
      }
      else{
      tempItem.setName(name.getText());
      tempItem.setDescr(descr.getText());
      String cond = (String)condition.getSelectedItem();
      if (cond.equals("OK")){
        tempItem.setCondition(true);
      }
      else if (cond.equals("Not OK")){
        tempItem.setCondition(false);
      }
      tempItem.setNum(num.getText());
      
      tempItem.setStatus((String)status.getSelectedItem());
      
      list.add(tempItem);
      DoubleLinkedList.sortAlpha(list);
      
      this.setVisible(false);
      frame2.dispose();
      }
    }  
    catch(NumberFormatException nfe)  
    {  
      JOptionPane.showMessageDialog(null, "Number must be numeric!");
    }
  }
  else{
    this.setVisible(false);
    frame2.dispose();
  }
  
}
}