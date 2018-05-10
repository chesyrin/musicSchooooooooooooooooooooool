/**
 * Template for insturments, equipment and sheet music
 */

public class Items {
  private boolean condition = true;
  private String name = "";
  private String descr = "";
  private String num = "";
  private String status = "";
  
  private int stu = -1;
  private String dueDate = "";//change into appropriate thing later
  
  /********************************************************* the constructors ***********************************************/
  //default constructor
  public Items() { 
  }
  
  public Items(String name, String condition, String num, String status){
    this.condition = Boolean.parseBoolean(condition);
    this.name = name;
    this.num = num;
    this.status = status;
  }
  
  //a = mode
  public void display(int a){
    //displays all items
    if (a == 0){
      System.out.println("Name: " + this.name);
      System.out.println("Num: " + this.num);
      System.out.println("Condition: " + this.condition);
      System.out.println("Description: "+ this.descr);
      System.out.println("Status: " + this.status);
      if(this.stu != -1){
        System.out.println("Student: " + this.stu);
//      Date date = new Date();
//      System.out.println("Due date: " + this.dueDate.format(date));
        System.out.println("Due date: " + this.dueDate);
      }
    }
    //doesn't display an item if it isn't signed out by a student
    else if (a == 1){
      if (dueDate.equals("") == false){
        System.out.println("Name: " + this.name);
        System.out.println("Num: " + this.num);
        System.out.println("Condition: " + this.condition);
        System.out.println("Description: "+ this.descr);
        System.out.println("Status: " + this.status);
        if(this.stu != -1){
          System.out.println("Student: " + this.stu);
          System.out.println("Due date: " + this.dueDate);
        }
      }
    }
    //doesn't display an item if it isn't signed out by a SPECIFIC student
    else{
      if (a == this.stu){
        System.out.println("Name: " + this.name);
        System.out.println("Num: " + this.num);
        System.out.println("Condition: " + this.condition);
        System.out.println("Description: "+ this.descr);
        System.out.println("Status: " + this.status);
        if(this.stu != -1){
          System.out.println("Student: " + this.stu);
          System.out.println("Due date: " + this.dueDate);
        }
      }
    }
  }
  /********************************************************* the get methods ***********************************************/
  public boolean getCondition(){
    return this.condition;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getDescr(){
    return this.descr;
  }
  
  public String getNum(){
    return this.num;
  }
  
  public String getStatus(){
    return this.status;
  }
  
  public int getPerson(){
    return this.stu;
  }
  
  public String getDate(){
    return this.dueDate;
  }
  /********************************************************* the set methods ***********************************************/
  public void setName(String name){
    this.name = name;
  }
  
  public void setCondition(boolean cond){
    this.condition = cond;
  }
  
  public void setNum(String num){
    this.num = num;
  }
  
  public void setStatus(String status){
    this.status = status;
  }
  
  public void setPerson(int student){
    this.stu = student;
  }
  
  public void setDescr(String descr){
    this.descr = descr;
  }
  
  public void setDate(String date){
    this.dueDate = date;
  }
  
}