import java.util.*;
public class HW11_1 {
   public static void main(String[] args) {
      Solution sol = new Solution();

      // Your solution may be tested with random input like this. 
      // The actual test cases will vary. 
      int[][] lines = new int[][] {
        //  {1,2},{1,3},{0,1},{0,3} // 4
          // {0,1},{0,3},{1,2},{1,3},{2,3},{2,4} // 5
         {0,1},{1,2},{2,3},{2,4},{5,6},{5,7} // 5

      };
      System.out.println(sol.getMaxCoverage(lines, 50 )); 
   }
}

/**
* PURPOSE:  returns the maximum coverage of the power line s
* PARAMETERS: int[][] lines, int k
* RETURN VALUES: int result 
*/ 

class Solution {
    
   public int getMaxCoverage(int[][] lines, int k) {
     int result = 0;
     int [] ar = new int[k]; 
     boolean [][] hasConnection = new boolean[k][k];

     for(int i = 0; i < lines.length; i++) { 
         int l1 = lines[i][0]; 
         int l2 = lines[i][1];
       if ((hasConnection [l1][l2] = true) && (hasConnection [l2][l1] = true )) {
         ar[l1]++;
         ar[l2]++;
     }}
     
     if (lines == null || lines.length == 0) { 
             return 0;
        }
        
        for (int i = 0; i < k ; i++) {
            for (int j = i + 1; j < k; j++) {
               int value = ar[i] + ar[j];
               

             value = ar[i] + ar[j] - (hasConnection[i][j] == true ? 1 : 0);
             result = (result>value)?result:value;
}
        }
return result;
}
}
