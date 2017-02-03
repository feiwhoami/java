/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * 
 * Hint:
 * 
 * Expected runtime complexity is in O(log n) and the input is sorted.
 */
package leetcode;

public class LeetCode275HIndexII {

    public int hIndex(int[] citations) {

        int n = citations.length;
        int i = n - 1;

        for (; i >= 0; i--) {
            if (n - i <= citations[i]) {
                ;
            } else {
                return n - i - 1;
            }
        }

        return n;
    }

}
