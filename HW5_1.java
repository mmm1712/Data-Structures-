import java.util.Stack;
public class HW5_1 {
    public static void main(String[] args) {
      Solution sol = new Solution();
        // your solution will be tested w/ random add()'s and remove()'s.
        // Observers like peek(), isEmpty() will be used along the way to validate.
        sol.add(5); 
        sol.add(3); 
        System.out.println(sol.peek());// 8, if you use System.out.print()
        sol.remove();  // 8
        sol.isEmpty(); // false
        sol.add(2); 
        sol.add(3); 
        sol.peek();
        System.out.println(sol.peek());
    }
}
class Solution {
    // PLEASE USE THESE GLOBAL STACKS FOR THIS PROBLEM
    private Stack < Integer > pushStack = new Stack < Integer > ();
    private Stack < Integer > popStack = new Stack < Integer > ();
    /*
     * ==================================== 
     * !!! DO NOT MODIFY ABOVE THIS LINE!!!
     * ====================================
     */
    /**
     * PURPOSE: add(x) inserts x to the back of queue. 
     * PARAMETERS: int x
     * RETURN VALUES: void
     */
    public void add(int x) {
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
    }
    /**
     * PURPOSE: remove() removes the head of queue and return the removed element
     * PARAMETERS: n/a
     * RETURN VALUES: removed element (int)
     */
    public int remove() {
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
    /**
     * PURPOSE: peek() retrieves and displays the head of queue 
     * PARAMETERS: n/a
     * RETURN VALUES: head od queue (int)
     */
    public int peek() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }
    /**
     * PURPOSE: isEmpty() returns whether the queue is empty
     * PARAMETERS: n/a
     * RETURN VALUES: true if queue is empty; false if quie is not empty 
     */
    public boolean isEmpty() {
        if (popStack.empty() && pushStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}