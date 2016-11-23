/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode215KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

}
