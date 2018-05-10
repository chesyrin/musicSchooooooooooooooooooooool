import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.Scanner;
public class Alerts {
  
  public static void main (String [] args){
    //convert today's date to String
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    //sort through list of sign outs based on date
    DoubleLinkedList<Items> studentItems = sortChrono (items);
    //display the items that arent due yet
    int i=0;
    while (i<studentItems.size() && studentItems.get(i).getDate().compareTo(curentDate)<=0){
        System.out.println (studentItems.get(i).getName());
        System.out.println (studentItems.get(i).getDate());
        i++;
    }
    System.out.println ("OVERDUE:");
    while (i<studentItems.size()){
      System.out.println (studentItems.get(i).getName());
      System.out.println (studentItems.get(i).getDate());
      i++;
    }
  }
}
