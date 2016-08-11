/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

package leetcode;

import java.util.HashSet;

public class LeetCode349IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (null == nums1 || null == nums2) {
            return null;
        }

        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> resultHash = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            hash1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hash1.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }

        int size = resultHash.size();
        int[] result = new int[size];
        int index = 0;

        for (Integer e : resultHash) {
            result[index++] = e;
        }

        return result;
    }
}
