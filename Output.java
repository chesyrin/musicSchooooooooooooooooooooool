/*
 */
import java.io.*;
public class Output {
  public static void printFile(DoubleLinkedList<Items> array){
    try{
      PrintWriter printOut = new PrintWriter ("Tasha.txt");
      for (int i=0; i<array.size(); i++){
        printOut.print(array.get(i).getName()+" ");
        printOut.print(array.get(i).getCondition() + " ");
        printOut.print(array.get(i).getNum() + " ");
        if (array.get(i).getStu()!=null){
          printOut.print(array.get(i).getStu() + " ");
          printOut.print(array.get(i).getDueDate() + " *");
        }
        printOut.print(array.get(i).getDescr());
        printOut.println("");
      }
      printOut.close();
    }
    catch (Exception e){
      System.out.println ("Error!");
    }
  }
  
  public static void main(String[] args) { 
  } 
}
