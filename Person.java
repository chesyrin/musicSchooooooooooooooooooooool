public class Person {
  
  private boolean status;//whether the person is a student or a teacher
  private String name = "";
  private int personNum;
  
  public Person (){
  }
  
  public Person(String name, int num) {
    this.name = name;
    this.personNum = num;
  }
    public Person(String num) {
    this.personNum = Integer.parseInt(num);
  }
  
  public String getName(){
    return this.name;
  }
  
  public int getNum(){
    return personNum;
  }
  
  public void setNum (int num){
    personNum = num;
  }
  
  public void setName(String name){
    name=name;
  }
}