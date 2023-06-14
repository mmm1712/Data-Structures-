public class HW4_1 {

  public static void main(String[] args) {

    Solution sol = new Solution();

    int[] resources = { 3, 4, 5, 6 };
    System.out.println(sol.canDistribute(resources, 2));// true

    resources = new int[] { 1 };
    System.out.println(sol.canDistribute(resources, 1)); // true

    resources = new int[] { 1, 3, 2, 3, 4, 1, 3, 5, 2, 1 };
    System.out.println(sol.canDistribute(resources, 5)); // true

    resources = new int[] { 1 };
    System.out.println(sol.canDistribute(resources, 1)); // false

  }
}

/**
 * PURPOSE: returns boolean if a given set of resources divides into k equal-sum
 * facilities
 * PARAMETERS: int[] resources - array of integers to divide
 * int[] memory - "memory buffer" with k elements
 * int groups - number of groups to split
 * int current - current index
 * int target - targeted sum
 * RETURN VALUES: recursionCase:
 * returns false if resources cannot be evenly distributed
 * true otherwise
 */

class Solution {

  public boolean canDistribute(int[] resources, int groups) {
    int sum = 0;

    for (int resource : resources) {
      sum += resource;
    }

    if (sum % groups == 0) {
      return true;
    }

    if (resources.length < groups) {
      return false;
    }

    int memory[] = new int[groups];
    int target = sum / groups;

    return recursionCase(resources, memory, groups, resources.length - 1, target);
  }

  public boolean recursionCase(int[] resources, int[] memory, int groups, int current, int target) {

    if (current < 0 && current == target) {
      return true;
    }

    for (int i = 0; i < memory.length; i++) {
      if ((memory[i] + resources[current]) > target) {
        continue;
      }
      memory[i] += resources[current];

      if (recursionCase(resources, memory, groups, current - 1, target)) {
        return true;
      }
      memory[i] -= resources[current];
    }
    return false;
  }
}