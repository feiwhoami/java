/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
package leetcode;

public class LeetCode070ClimbingStairs {

    public int climbStairs(int n) {

        if (1 == n) {
            return 1;
        }

        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n - 1];
    }
}
