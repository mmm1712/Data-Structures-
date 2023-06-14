import java.util.*;
public class HW10_1 {
   public static void main(String[] args) {

      // Your solution methods will be tested with 
      // random tree input; the following is just
      // an example. The actual test cases will be different.

      // EXAMPLE: max heap; arraylist representation in 
      // Breadth-First Traversal is [5,4,3,2,1]
      //       5
      //      / \
      //     4   3
      //    / \
      //   2   1

      // First, take the above array representation of the 
      // input heap and convert it into an ArrayList 
      // instance via the following:
      ArrayList < Integer > list = new ArrayList < > (Arrays.asList(5, 4, 3, 2, 1));

      // Then, create an instance of solution by passing 
      // this list in. Note this solution class is basically
      // a heap wrapper, using ArrayList as its buffer to store/manipulate data.
      Solution sol = new Solution(list);

      // Test the operations: enqueue(element) & dequeue(). You may use print() to 
      // display your ArrayList instance in String. 
      sol.enqueue(6);
      System.out.println(sol.print()); // [6,4,5,2,1,3]
      sol.dequeue(); // [5,4,3,2,1]
      System.out.println(sol.list);
      sol.enqueue(5);
      System.out.println(sol.print()); // [5,4,5,2,1,3]
      // etc.
   }
}

class Solution {
   ArrayList < Integer > list;
   public Solution(ArrayList < Integer > list) {
      this.list = list;
   }
   // This method is for printing the heap's buffer
   public String print() {
      return Arrays.toString(list.toArray());
   }
   // -------------------------------------------
   // !!! PLESE DO NOT MODIFY THE ABOVE !!!
   //     - CONSTRUCTOR 
   //     - ARRAYLLIST DECLARATION
   //     - PRINT METHOD
   // !!! PLESE DO NOT MODIFY THE ABOVE !!!
   // -------------------------------------------

   // YOU MAY ADD ANY ADDITIONAL METHODS, 
   // VARIABLES, ETC., HERE

   /**
    * PURPOSE: enqueues an integer element into heap
    * PARAMETERS: int element
    * RETURN VALUES: n/a
    */

   public void enqueue(int element) {
      list.add(list.size(), element);
      reheapUp(list.size() - 1);
   }

   /**
    * PURPOSE: dequeues the highest priority element from heap.
    * PARAMETERS: n/a
    * RETURN VALUES: n/a
    */
   public void dequeue() {
      int removing = list.set(0, list.get(list.size() - 1));
      int moving = list.remove(list.size() - 1);

      reheapDown(0);
   }

   /**
    * PURPOSE: shifts the element up the tree to "reheap" it
    * PARAMETERS: int x 
    * RETURN VALUES: n/a 
    */
   private void reheapUp(int x) {
      int hole = x;
      while (list.get(hole) > list.get((hole - 1) / 2)) {
         Collections.swap(list, hole, (hole - 1) / 2);
         hole = (hole - 1) / 2;
      }
   }

   /**
    * PURPOSE: shifts the element down the tree to "reheap" it
    * PARAMETERS: int x 
    * RETURN VALUES: n/a
    */
   private void reheapDown(int x) {
      int lastIndex = list.size() - 1;
      int element = x;
      int left = (x * 2) + 1;
      int right = (x * 2) + 2;

      if (left < lastIndex)
         if (list.get(left) > list.get(x))
            element = left;

      if (right < lastIndex)
         if (list.get(right) > list.get(x))
            element = right;

      if (x != element) {
         swap(x, element);
      }
   }
   private void swap(int a, int b) {
      int temp = list.get(a);
      list.set(a, list.get(b));
      list.set(b, temp);
   }
}