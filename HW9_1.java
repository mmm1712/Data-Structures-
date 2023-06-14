public class HW9_1 {
	public static void main(String[] args) {
        Solution sol = new Solution();
        sol.put(1, 1);
        sol.put(2, 3);
        sol.put(3, 4);
        sol.put(4, 5);
        sol.put(5, 6);
        sol.put(20, 0);
        sol.put(90, 3);
        sol.put(12, 13);
        sol.put(72, 73);
        sol.put(28, 300);
        sol.put(23, 777);
        System.out.println(sol.get(3));     // returns 4
        System.out.println(sol.get(1));       // returns 1
        System.out.println(sol.get(30));      // returns -1 (not found)
        System.out.println(sol.get(5));      // returns 6
        System.out.println(sol.get(72));      // returns 73
        System.out.println(sol.get(28));      // returns 300
        System.out.println(sol.get(23));      // returns 777
        System.out.println(sol.get(20));       // returns 0
        sol.put(1, 100);  // update the existing value
        sol.put(20, 50);  // update the existing value
        System.out.println(sol.get(1));       // returns 100
        System.out.println(sol.get(20));       // returns 50
        sol.remove(2);    // removes the mapping for 2
        sol.remove(1);    // removes the mapping for 1
        sol.remove(20);   // removes the mapping for 20
        System.out.println(sol.get(2));       // returns -1 (not found)
        System.out.println(sol.get(1));       // returns -1 (not found)
        System.out.println(sol.get(20));       // returns -1 (not found)
    }
}
 
  class LinkedList {
	  int key,value; 
	  LinkedList next;
 
	  public LinkedList(int key, int value) {
		  this.key = key;
		  this.value = value;
	  }
  }
 
  class Solution {
  
	 int capacity = 10000;
	 LinkedList[] elements;
  
	 public Solution() { 
		this.elements = new LinkedList[capacity];
	 } 
  
	 /**
	 * PURPOSE: inserts a (key, value) pair into the map
	 * PARAMETERS: int key, int value
	 * RETURN VALUES: n/a
	 */ 
 
	 public void put(int key, int value) { 
	   while (elements[key] != null) {
		   if (elements[key].key == key) {
			   elements[key].value = value;
		   }
		   elements[key] = elements[key].next;
		 }
		 LinkedList node = new LinkedList(key,value);
		 if(elements[key] == null)
		 elements[key] = node;
		 else 
		 elements[key].next = node;
		 elements[key] = node;
	   }
  
	 /**
	 * PURPOSE: returns the corresponding value mapped to the input key
	 * PARAMETERS: int key 
	 * RETURN VALUES: value corresponding to the key / -1 if the value not found 
	 */    
 
	 public int get(int key) { 
		int resultValue = -1;
		LinkedList current = elements[key];
		while (current!= null) {
			if (current.key == key) {
				 resultValue = current.value;
			}
			current = current.next;
		}
		return resultValue;
	 } 
  
	 /**
	 * PURPOSE: removes the corresponding value mapped to the input key
	 * PARAMETERS: int key
	 * RETURN VALUES: n/a
	 */ 
 
	 public void remove(int key) { 
	  LinkedList current = elements[key];
	  if (current.key == key) {
		  elements[key] = current.next;
		  return;
	  }
	  if(current!= null){
		  if ((current.next.key == key) &&  current.next.next != null) {
			  current.next = current.next.next;
		  } else {
			  current.next = null;
		  }
		  }
		  current = current.next;
	  }
  }