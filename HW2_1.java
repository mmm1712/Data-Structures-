import java.util.Stack;
public class HW2_1 {
   public static void main(String[] args) {
   Solution s = new Solution();
      
       int[] events_pushed = {1,2,3} ;
       int[] events_popped = {3,2,1} ;
       
       int[] events_pushed2 = {1,2,2} ;
       int[] events_popped2 = {1,2,3} ;
       
       int[] events_pushed3 = {1} ;
       int[] events_popped3 = {1} ;
       
      System.out.println("Answer: " + 
s.isSameEventSequence(events_pushed,events_popped));
      System.out.println("Answer: " + 
s.isSameEventSequence(events_pushed2,events_popped2));
      System.out.println("Answer: " + 
s.isSameEventSequence(events_pushed3,events_popped3));
      
   }
}
/**
 * PURPOSE: write a method isSameEventSequence() which compares two event sequences
 * PARAMETERS: events_pushed - array of integers being pushed, events_popped - 
array of integers being popped
 * RETURN VALUES: boolean : if match - true, else - false 
 */
class Solution {
    public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) { 
        
        boolean lengthCheck = (events_pushed.length > 100 || events_popped.length >
100);
        boolean lengthCheck2 = (events_pushed.length < 1 || events_popped.length < 
1);
        
        if (lengthCheck || lengthCheck2 ){
           return false;
       }
       
       for(int k = 0; k < events_pushed.length; k++) {
    int p = events_pushed[k];
          if(p <= 0 || p > 100){ return false; }
       }
       
       for(int k = 0; k < events_popped.length; k++) {
    int c = events_popped[k];
          if(c <= 0 || c > 100){ return false; }
       }
       
    Stack<Integer> st = new Stack<Integer>();
    int index = 0;
    for (int i = 0; i < events_pushed.length; i++) {
        st.push(events_pushed[i]);
        while(!st.empty() && st.peek() == events_popped[index]) {
           st.pop(); 
           index++;
        }}
            return (events_pushed.length == index);
        }
    }