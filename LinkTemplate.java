//**********A template  for a simple linked list ********

class LinkTemplate {
  public static void display(DoubleLinkedList<String> myList){
    for (int i=0; i<myList.size(); i++){
      System.out.println (myList.get(i));
    }
    System.out.println ("");
  }//end of display
  
  public static void main(String[] args) {     //the main method
    DoubleLinkedList<String> myList = new DoubleLinkedList<String>();   //you can use your list similar to an ArrayList
    
    myList.add("111111");
    myList.add("22222");
    myList.add("33333");
    myList.add("44444");
    myList.add("2");
    myList.add("assss");
    display (myList);
    myList.sortChrono(myList);
    display(myList);
    
    System.out.println ("Index of Sam: " + myList.indexOf("Sam"));
    System.out.println("Size: " + myList.size());
    myList.remove(0);//
    display (myList);
    myList.clear();
    System.out.println ("Cleared list: ");
    display (myList);
  }
}
