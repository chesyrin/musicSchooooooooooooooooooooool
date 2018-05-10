import java.util.Scanner;
import java.io.*;
public class Aaaaa{
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
    }
    System.out.println ("DONE");
    return students;
  }
  public static void main(String[] args) { 
    DoubleLinkedList<Person> students = readStudents();
    for (int i=0; i<students.size(); i++){
      System.out.println (students.get(i).getName());
    }
  } 
}
