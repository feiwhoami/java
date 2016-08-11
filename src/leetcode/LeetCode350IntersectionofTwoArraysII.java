/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode350IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (null == nums1 && null == nums2) {
            return null;
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (null == map1.get(nums1[i])) {
                map1.put(nums1[i], 1);
            } else {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (null != map1.get(nums2[i]) && map1.get(nums2[i]) > 0) {
                resultList.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
            }
        }

        int size = resultList.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
