/**
 * Read in the file
 * Add and remove students
 * 
 * Finished: txt file read in & saved to list
 * 
 * Changed: turned sign in and sign out into seperate methods
 */
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class Main {
  //saves the io file
  public static void printFile(DoubleLinkedList<Items> array){
    try{
      PrintWriter printOut = new PrintWriter ("Tasha.txt");
      for (int i=0; i<array.size(); i++){
        printOut.print(array.get(i).getName()+" ");
        printOut.print(array.get(i).getCondition() + " ");
        printOut.print(array.get(i).getNum() + " ");
        if (array.get(i).getPerson()!= -1){
          printOut.print(array.get(i).getPerson() + " ");
          printOut.print(array.get(i).getDate() + " ");
        }
        printOut.print("*" + array.get(i).getDescr());
        printOut.println();
      }
      printOut.close();
    }
    catch (Exception e){
      System.out.println ("Error 3");
    }
  }
  
  //signs in an item 
  public static void signIn(DoubleLinkedList<Items> list){
    Scanner input = new Scanner(System.in);
    System.out.println("What do you want to sign in?");
    String temp = input.nextLine();
    Items tempTemp = checkItem(temp, list);
    //checks if item is found
    if (tempTemp == null){
      System.out.println("Not found.");
    }
    else {
      tempTemp.setPerson(-1);
      tempTemp.setDate(null);
    }
  }//end of sign in
  //signs out an item
  public static void signOut(DoubleLinkedList<Person> students, DoubleLinkedList<Items> list){
    Scanner input = new Scanner(System.in);
    System.out.println("What do you want to sign out?");
    String temp = input.nextLine();
    Items tempTemp = checkItem(temp, list);
    //checks if item is found
    if (tempTemp == null){
      System.out.println("Not found.");
    }
    else {
      //checks if item is out on repairs
      if (tempTemp.getCondition() == false){
        System.out.println("This is currently out to repairs.");
      }
      else{
        System.out.println("Enter your student id.");
        temp = input.nextLine();
        
        //checks if item is already signed out by a different user
        if (tempTemp.getPerson() != -1 && tempTemp.getPerson() != Integer.parseInt(temp)){
          System.out.println("This is already signed out by someone else.");
        }
        else{
          Person tempStu = checkStudent(Integer.parseInt(temp),students);
          if (tempStu == null){
            System.out.println("Student not found.");
          }
          else {
            tempTemp.setPerson(tempStu.getNum());
            //finds current date
            String tempDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            //increases day by 1
            tempTemp.setDate(LocalDate.parse(tempDate).plusDays(1).toString());
          }
        }
      }
    }
  }//end of sign out
  
  //reads in students from txt
  public static DoubleLinkedList<Person> readStudents (){
    DoubleLinkedList<Person> students = new DoubleLinkedList<Person>();
    try{
      Scanner read = new Scanner (new File ("students.txt"));
      while (read.hasNextLine()){
        Person newPerson = new Person();
        newPerson.setNum(read.nextInt());
        newPerson.setName(read.nextLine());
        students.add(newPerson);
      }
    }
    catch(Exception e){
      System.out.println("Error 2");
    }
    return students;
  }
  //reads in items from txt
  public static DoubleLinkedList<Items> readItems(){
    DoubleLinkedList<Items> list = new DoubleLinkedList<Items>();
    try {
      File file = new File("Tasha.txt");
      Scanner fileInput = new Scanner(file);
      
      while (fileInput.hasNext()){
        String temp = fileInput.nextLine();
        Scanner stringInput = new Scanner(temp);
        
        Items tempItem = new Items(stringInput.next(), stringInput.nextBoolean(),
                                   stringInput.next());
        String tempTemp = stringInput.next();
        //if it has a student
        if (tempTemp.charAt(0) != '*'){
          tempItem.setPerson(Integer.parseInt(tempTemp));
          
          tempItem.setDate(stringInput.next());
        }
        //set description
        tempItem.setDescr(temp.substring(temp.indexOf('*')+1));       
        list.add(tempItem);
        
      }
    }
    catch(Exception E){
      System.out.println("Error 1");
    }
    return list;
  }
  //returns the searched student
  public static Person checkStudent (int num, DoubleLinkedList<Person> students){
    int index=0;
    while (index < students.size()){
      if (num==students.get(index).getNum()){
        return students.get(index);
      }
      index++;
    }
    return null;
  }
  //returns the searched item
  public static Items checkItem (String input, DoubleLinkedList<Items> list){
    for (int i = 0; i<list.size(); i++){
      if (input.equals(list.get(i).getName())){
        return list.get(i);
      }
    }
    return null;
  }
  
  public static void main(String[] args) { 
    
//read in the files----------------------------------
    DoubleLinkedList<Items> list = readItems();
    DoubleLinkedList<Person> students = readStudents();
    for (int i = 0; i< list.size(); i++){
      Items temp = list.get(i);
      temp.display(0);
      System.out.println();
    }
    
    for (int i=0; i<students.size(); i++){
      System.out.println (students.get(i).getNum());
    }
//------------------------------------------------------------------------
    
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    while (exit == false){
      System.out.println("Press 1 to sign out, press 2 to sign in, 3 if you want to see recent sign outs, and 4 to exit.");
      String temp = input.nextLine();
      if (temp.equals("1")){
        signOut(students, list);
        //display
        for (int i = 0; i< list.size(); i++){
          Items temp3 = list.get(i);
          temp3.display(0);
          System.out.println();
        }
      }
      else if (temp.equals("2")){
        signIn(list);
        //display
        for (int i = 0; i< list.size(); i++){
          Items temp3 = list.get(i);
          temp3.display(0);
          System.out.println();
        }
      }
      else if (temp.equals("3")){
        //sort the list
        DoubleLinkedList.sortChrono(list);
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        System.out.println ("Today's date: " + currentDate);
        
        System.out.println("Press 1 if you want to see general, 2 if you want to see for a specific student:");
        temp = input.nextLine();
        
        
        if (temp.equals("1")){
          int j = 0;
          while (j<list.size() && list.get(j).getDate().compareTo(currentDate)>=0){
            list.get(j).display(1);
            j++;
          }
          System.out.println ("\nOVERDUE:\n");
          while (j<list.size() && list.get(j).getPerson() != -1){
            list.get(j).display(1);
            j++;
          }
          
        }
        else if (temp.equals("2")){
          System.out.println("Which student do you want to see?");
          temp = input.nextLine();
          int j = 0;
          while (j<list.size() && list.get(j).getDate().compareTo(currentDate)>=0){
            list.get(j).display(Integer.parseInt(temp));
            j++;
          }
          System.out.println ("\nOVERDUE:\n");
          while (j<list.size() && list.get(j).getPerson() != -1){
            list.get(j).display(Integer.parseInt(temp));
            j++;
          }
        }
        
        DoubleLinkedList.sortAlpha(list);
      }
      else if (temp.equals("4")){
        printFile(list);
        System.out.println("Thank you!");
        exit = true;
      }
      
    }
  }
  
}
/*Txt file format:
 * Name condition(0/1) number description student dueDate
 */