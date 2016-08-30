/**
 * Shuffle a set of numbers without duplicates.
 */
package leetcode;

import java.util.Random;

public class LeetCode384ShuffleanArray {

    private int[] origin;
    private int[] output;
    private Random random = new Random();

    public LeetCode384ShuffleanArray(int[] nums) {

        this.origin = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            origin[i] = nums[i];
        }
        this.output = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        for (int i = 0; i < output.length; i++) {
            int j = random.nextInt(output.length);

            if (i != j) {
                int tmp = output[i];
                output[i] = output[j];
                output[j] = tmp;
            }

        }

        return output;
    }
}
