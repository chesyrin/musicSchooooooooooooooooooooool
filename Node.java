// ********************** A Node in the linked list *********
class Node<T> { //T is a placeholder, represents a generic type
  private T item; //item of type T
  private Node<T> next;
  private Node<T> previous;

  public Node(T item) { //contructor for the head
  this.item=item;
  this.next=null;
  this.previous=null;
}

public Node(T item, Node<T> previous, Node<T> next) { 
  this.item=item;
  this.previous=previous;
  this.next=next;
}

public Node<T> getNext(){ //gets value of next
  return this.next;
}

public Node<T> getPrevious(){ //gets value of next
  return this.previous;
}

public void setNext(Node<T> next){ //sets the value of next
  this.next = next;
}

public void setPrevious(Node<T> previous){ //sets the value of next
  this.previous = previous;
}

public T getItem(){ //gets the value of item
  return this.item;
}

public void setItem(T item){
  this.item=item;
}

}