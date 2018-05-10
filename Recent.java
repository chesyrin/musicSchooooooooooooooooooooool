import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Recent {
  public Recent(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setSize(300,400);
    JPanel panel = new JPanel ();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JLabel label = new JLabel ("\tRecent Sign Outs:");
    DoubleLinkedList<Items> list = MusicResource.getItems();
    DoubleLinkedList.sortChrono(list);
    
    JLabel overdue = new JLabel("----Overdue:----");
    JLabel signOuts[] = new JLabel[list.size()];
    
    for(int i = 0; i<list.size(); i++){
      if (list.get(i).getPerson() != -1){
        signOuts[i] = new JLabel("\t" + list.get(i).getName() + 
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