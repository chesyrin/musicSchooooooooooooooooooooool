import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RecentStudent {
  public RecentStudent(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setSize(300,400);
    JFrame frame2 = new JFrame();
    JPanel panel = new JPanel ();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JLabel label = new JLabel ("Recent Sign Outs:");
    JLabel overdue = new JLabel("----Overdue:---");
    
    String stuNum = JOptionPane.showInputDialog(frame2, "What's your name?");

    DoubleLinkedList<Items> list = MusicResource.getItems();
    DoubleLinkedList.sortChrono(list);
    JLabel signOuts[] = new JLabel[list.size()];
    
    for(int i = 0; i<list.size(); i++){
      if (list.get(i).getPerson() == Integer.parseInt(stuNum)){
      signOuts[i] = new JLabel(list.get(i).getName() + 
                               "\t Due: " + list.get(i).getDate() + 
                               "\t Name: " + list.get(i).getPerson());
      }
    }
    
    
    panel.add(label);
    
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    int j = 0;
    
    while (j<list.size() && (signOuts[j] != null) && list.get(j).getDate().compareTo(currentDate)>=0){
      panel.add(signOuts[j]);
      j++;
    }
    
    panel.add(overdue);
    
    while (j<list.size() && (signOuts[j] != null) && list.get(j).getPerson() != -1){
      panel.add(signOuts[j]);
      j++;
      System.out.println(j);
    }

    frame.add(panel);
    frame.setVisible(true);
    
  }
}