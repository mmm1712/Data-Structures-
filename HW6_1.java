public class HW6_1 {
  public static void main(String[] args) {
    // your solution method will be tested as such, with random sequential input
    // TEST CASE #1: instantiate a queue of capacity = 1

    System.out.println("TEST CASE #1:" + "\n");

    Solution sol = new Solution(1);

    System.out.println(sol.getFront()); // -1
    System.out.println(sol.getRear()); // -1
    sol.add(523);
    System.out.println(sol.getFront()); // 0
    System.out.println(sol.getRear()); // 0
    System.out.println(sol.peek()); // 8
    System.out.println(sol.remove()); // 8
    System.out.println(sol.isEmpty()); // true
    System.out.println(sol.getFront()); // -1, when queue is empty
    System.out.println(sol.getRear()); // -1, when queue is empty

    // TEST CASE #2: instantiate a queue of capacity = 3
    sol = new Solution(3);
    sol.add(1);
    sol.add(2);
    sol.add(3);

    System.out.println("\n" + "TEST CASE #2:" + "\n");

    System.out.println(sol.getFront()); // 0
    System.out.println(sol.getRear()); // 2
    System.out.println(sol.remove()); // 1
    System.out.println(sol.getFront()); // 1
    System.out.println(sol.getRear()); // 2
    System.out.println(sol.remove()); // 2
    System.out.println(sol.remove()); // 3
    System.out.println(sol.isEmpty()); // true
    System.out.println(sol.getFront()); // -1, when queue is empty
    System.out.println(sol.getRear()); // -1, when queue is empty

  }
}

class Solution {
  // Dynamic array size
  private int capacity;
  // Queue
  private int[] elements;
  // Dynamic queue size
  private int numElements = 0;
  // Dynamic index for the front of queue, defaulting to -1 when the queue is empty
  private int front = -1;
  // Dynamic index for the rear of queue, defaulting to -1 when the queue is empty
  private int rear = -1;

  // Constructor
  public Solution(int capacity) {
    this.capacity = capacity;
    this.elements = new int[this.capacity];
  }
  // Get the front index
  public int getFront() {
    return this.front;
  }
  // Get the rear index
  public int getRear() {
    return this.rear;
  }

  /* =====================================
   /* !!! DO NOT MODIFY ABOVE THIS LINE!!!
   /* ====================================

  
  /**
   * PURPOSE: add(int x) - enqueue an integer into the queue
   * PARAMETERS: int x
   * RETURN VALUES: void
  */

  public void add(int x) {
    if (front == -1 && rear == -1) {
      front = rear = 0;
      elements[rear] = x;
    } else {
      rear++;
      elements[rear] = x;
    }
  }

  /**
   * PURPOSE: remove() - dequeue first element from the queue
   * PARAMETERS: n/a
   * RETURN VALUES: int, first element from the queue 
   */

  public int remove() {
    int removedElement = elements[front];
    if (front == rear) {
      front = rear = -1;
    } else {
      front++;
    }
    return removedElement;
  }

  /**
   * PURPOSE: peek() - returns the value of the top of the collection
   * without removing the element from the collection
   * PARAMETERS: n/a
   * RETURN VALUES: int, element int the front of the queue
   */

  public int peek() {
    return elements[front];
  }

  /**
   * PURPOSE: isEmpty() - returns whether the queue is empty
   * PARAMETERS: n/a
   * RETURN VALUES: true if the queue is empty; false if quie is not empty 
   */

  public boolean isEmpty() {
    return numElements == 0;
  }
}