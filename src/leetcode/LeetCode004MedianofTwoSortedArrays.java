/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
package leetcode;

public class LeetCode004MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (null == nums1 || null == nums2) {
            return 0;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;

        int sum = length1 + length2;
        double result;

        if (sum % 2 == 0) {
            result = (findKth(nums1, nums2, 0, 0, sum / 2) + findKth(nums1, nums2, 0, 0, sum / 2 + 1)) / 2.0;
        } else {
            result = findKth(nums1, nums2, 0, 0, sum / 2 + 1);
        }

        return result;
    }

    private int findKth(int[] nums1, int[] nums2, int index1, int index2, int k) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        if (index1 >= length1) {
            return nums2[index2 + k - 1];
        } else if (index2 >= length2) {
            return nums1[index1 + k - 1];
        }

        if (1 == k) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        int mid = k / 2 - 1;

        int nums1Mid, nums2Mid;

        if (index1 + mid >= length1) {
            nums1Mid = Integer.MAX_VALUE;
        } else {
            nums1Mid = nums1[index1 + mid];
        }

        if (index2 + mid >= length2) {
            nums2Mid = Integer.MAX_VALUE;
        } else {
            nums2Mid = nums2[index2 + mid];
        }

        if (nums1Mid < nums2Mid) {
            return findKth(nums1, nums2, index1 + k / 2, index2, k - k / 2);
        } else {
            return findKth(nums1, nums2, index1, index2 + k / 2, k - k / 2);
        }
    }
}
