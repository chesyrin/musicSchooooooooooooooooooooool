/* Instrument.class
 * Julia Zhao and Tasha Xiao
 * May 02 2018
 * Version 1.0.0
 * For the instrument object
 */

public class Instrument {
  private String name = "none";
  private int number = -1;
  private boolean goodCondition = true;
  private String description = "n/a"; //what is a description????
  
  public Instrument(){
  }
  
  //methods to get info
  public String getName(){
    return this.name;
  }
  
  public int getNum(){
    return this.number;
  }
  
  public boolean returnCondition(){
    return goodCondition;
  }
  
  public String getDescription(){
    return this.description;
  }
  
  //methdos to set info
  public void setName(String name){
    this.name=name;
  }
  
  public void setNum(int num){
    this.number=num;
  }
  
  public void setCondition(boolean condition){
    this.goodCondition=condition;
  }
  
  public void setDescription(String desc){
    this.description=desc;
  }
}
