import java.util.*;
public class HW10_2 {

        
        public static void main(String[] args) {
                
                Solution sol = new Solution();

              // Your solution methods will be tested with random input; the following is just
              // an example. The actual test cases will be different.
               int[] output = sol.getN(new int[]{1,2,3,4,5,6}, 3);


              // You may use this approach to print your output to console to validate
              System.out.println(Arrays.toString(output)); // combination of any 3 input integers
                                                           // [2,3,6], [1,2,3], [4,5,6], etc. 

              // If you wish to repeat with a different test case, you may as follows:
              output = sol.getN(new int[]{1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,6}, 3);
              System.out.println(Arrays.toString(output)); // [6,5,2] or them 3 in any order
              
              output = sol.getN(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2}, 1);
              System.out.println(Arrays.toString(output)); // [2]
              output = sol.getN(new int[]{1}, 1); 
              System.out.println(Arrays.toString(output)); // [1]
              output = sol.getN(new int[]{11,12,1,2,10,100}, 3); 
              System.out.println(Arrays.toString(output)); // [100,12,11]
              
        }
}
class Solution {

  // YOU MAY ADD ANY ADDITIONAL METHODS, VARIABLES, ETC., HERE

  /**
   * PURPOSE: function to print the N numbers with most occurrences
   * PARAMETERS: int[] input, in N
   * RETURN VALUES: array result  
   */

  public int[] getN(int[] input, int N) {

    int[] result = new int[N];
    HashMap < Integer, Integer > map = new HashMap < > ();
    Queue < Integer > heap = new PriorityQueue < > ();

    for (int i: input) {
      Integer count = map.get(i);
      map.put(i, count != null ? count + 1 : 1);
    }

    for (int i: map.keySet()) {
      heap.add(i);
      if (heap.size() > N) heap.poll();
    }
    if (N == input.length) {
      return input;
    }
    for (int i = N - 1; i >= 0; --i) {
      result[i] = heap.poll();
    }
    return result;
  }
}