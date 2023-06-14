import java.util.*;

public class HW9_2 {
   public static void main(String[] args) {
      Solution sol = new Solution();
      // Your solution method will be tested with random input 
      // such as the following; the actual test cases will be 
      // different
      sol.put("app", 100); 
      System.out.println(sol.getSum("ap"));     // returns 100 as "ap" is a prefix  to "app"
      sol.put("ap", 1);
      System.out.println(sol.getSum("a"));      // returns 101 as "a" is a prefix to both keys in map
      System.out.println(sol.getSum("xyz"));    // returns 0 as "xyz" is not a prefix to any keys in map 
      sol.put("app", 8);    // replaces the value of the existing key "app" from 100 to 8
      System.out.println(sol.getSum("ap"));     // returns 9 as "ap" is a prefix to both keys in map 
   }
} 

class Solution {

   HashMap<String, Integer> map;

   public Solution() { 
    this.map = new HashMap<String, Integer>() ;
   } 

   /**
   * PURPOSE: inserts a (key, value) pair into the map
   * PARAMETERS: String key, int value
   * RETURN VALUES: n/a
   */ 
   
   public void put(String key, int value) { 
      map.put(key, value);
   } 

   /**
   * PURPOSE: returns a summation of all corresponding values 
   *          of the keys in map that start with such prefix  
   * PARAMETERS: String key
   * RETURN VALUES: int sum 
   */ 
   
   public int getSum(String key) { 
       int sum = 0; 
       for(String values: map.keySet()){ 
           if(values.startsWith(key)){ 
               sum += map.get(values);
           }
       }
    return sum;
   } 
}