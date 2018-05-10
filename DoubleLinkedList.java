/* DoubleLinkedList<E>.java
 * Julia Zhao and Tasha Xiao
 * May 03 2018
 * Version 1.0.0
 * Program for the double linked list
 */

class DoubleLinkedList<E> { 
  private Node<E> head;//first item in the list
  private Node <E> tail;//last item in the list
  
  public void add(E item) { //add an item to the list
    //no items in the list
    if (head==null) { //creates a new head with value item, next node is null
      head=new Node<E>(item);
      tail=head; //reference points to head
      return;
    }
    
    Node<E> tempNode=tail;
    tempNode.setNext(new Node<E>(item, tempNode, null));
    tail=tempNode.getNext();
    return;
  }
  
  public E get(int index) { //gets the value of item at index
    Node<E> tempNode = head;
    for (int i=0; i<index; i++){
      tempNode=tempNode.getNext();   
    }
    return tempNode.getItem();
  }
  
  public void set(int index, E item) { //gets the value of item at index
    Node<E> tempNode = head;
    for (int i=0; i<index; i++){
      tempNode=tempNode.getNext();   
    }
    tempNode.setItem(item);
  }
  
  public int indexOf(E item) { //returns index of item
    Node<E> tempNode = head;
    int counter=0;
    while (tempNode!=null){
      //compare the values
      if (tempNode.getItem().equals(item)){
        return counter;
      }
      tempNode=tempNode.getNext(); 
      counter++;
    }
    return counter;
  }
  
  public E remove(int index) { //removes an element of the list
    int counter=0;
    if (index==0 && head.getNext()!=null){ //if you need to remove the first item
      head=new Node<E>(head.getNext().getItem(), head, head.getNext().getNext());
    }
    else if (index==0 && head.getNext()==null){
      clear();
    }
    Node <E> tempNode=head;
    while (tempNode!=null){
      //compare the values
      if ((counter+1)==index){ //if the next item is what you want to remove
        System.out.println ("Removing: " + tempNode.getNext().getItem());
        if (tempNode.getNext().getNext()!=null){
          tempNode.setNext(tempNode.getNext().getNext());
        }                                
        else{ //last item in the list
          tempNode.setNext(null);
        }
      }
      tempNode=tempNode.getNext(); 
      counter++;
    }
    return null;
  }
  
  public void clear() { //clear the list
    head=null;
  }
  
  public int size() { //returns size of list
    Node <E> tempNode=head;
    int counter=0;
    while (tempNode!=null){
      counter++;
      tempNode=tempNode.getNext();
    }
    return counter;
  }
  
  //insertion
  public static void sortAlpha(DoubleLinkedList<Items> a){
    for (int i=1; i<a.size(); i++){ //starts at 2nd element
      int index=i-1;
      Items tempItem = a.get(i);
      String item = tempItem.getName(); //pivot element
      
      while (index>=0 && ((a.get(index)).getName()).compareTo(item)>0){
        a.set(index+1, a.get(index)); //move the element one position down
        index--;
      }
      
      a.set(index+1,tempItem); //insert item in proper position
    }
  }
  
  public static void sortChrono(DoubleLinkedList<Items> a){
    for (int i=1; i<a.size(); i++){ //starts at 2nd element
      int index=i-1;
      Items tempItem = a.get(i); //pivot element
      String item = tempItem.getDate();
      
      while (index>=0 && ((a.get(index)).getDate()).compareTo(item)<0){
        a.set(index+1, a.get(index)); //move the element one position down
        index--;
      }
      
      a.set(index+1,tempItem); //insert item in proper position
    }
  }
}