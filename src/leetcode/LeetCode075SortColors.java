/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
package leetcode;

public class LeetCode075SortColors {

    public void sortColors(int[] nums) {

        int len = nums.length;

        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else if (nums[i] == 1) {
                countOne++;
            } else if (nums[i] == 2) {
                countTwo++;
            }
        }

        int index = 0;
        while (countZero > 0) {
            nums[index] = 0;
            index++;
            countZero--;
        }
        while (countOne > 0) {
            nums[index] = 1;
            index++;
            countOne--;
        }
        while (countTwo > 0) {
            nums[index] = 2;
            index++;
            countTwo--;
        }

        return;
    }

    public void sortColors2(int[] nums) {

        int len = nums.length;
        int zeroIndex = 0;
        int twoIndex = len - 1;

        int index = 0;
        while (index < twoIndex + 1) {

            if (nums[index] == 0) {
                nums[index] = nums[zeroIndex];
                nums[zeroIndex] = 0;
                zeroIndex++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex--;
            } else {
                index++;
            }
        }

        return;
    }
}
