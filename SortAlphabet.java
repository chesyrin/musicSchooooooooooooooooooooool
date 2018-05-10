/**
 * Insertion sort
 * Complexity:
 *       Best case O(n)
 *       Worst case (
 */
public class SortAlphabet { 
  public static void main(String[] args) { 
    char [] a = {'z','y','o','n','m','a'};
    for (int i=1; i<a.length; i++){ //start at 2nd element
      int index=i-1; //index is the one before i
      char item=a[i]; //the pivot element
      
      while (index >=0 && a[index]>item){  //the current item is less than pivot
        a[index+1]=a[index]; //move the element one position down
        index--;
      }
     a[index+1]=item; //insert the item into the proper position
    }
    
    //display
    for (int i = 0; i<a.length; i++){
      System.out.print (a[i] + " ");
    }
  }
}
