/*
 */
public class Search {
  public static int search (DoubleLinkedList<Items> items, int start, int end, String item){
    if (end-start>=0){
      int mid = (end+start)/2; //middle element of the array
      
      if (items.get(mid).getName().equals(item)){
        return mid;
      }
      
      if (items.get(mid).getName().compareTo(item)>0){
        return search (items, start, mid-1, item); 
      }
      else{
        return search (items, mid+1, end, item);
      }
    }
    //not in the array
    return -1;
  }
  
  public static void main(String[] args) { 
    DoubleLinkedList<Items> instrum = new DoubleLinkedList<Items>();
    instrum.add (new Items("aaa", true, "1"));
    instrum.add (new Items("bbb", false, "2"));
    instrum.add (new Items("ddd", true, "3"));
    
    System.out.println (search(instrum, 0, instrum.size()-1, "aaa"));
  }
}
