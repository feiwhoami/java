/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 */
package leetcode;

public class LeetCode338CountingBits {

    public int[] countBits(int num) {

        int[] result = new int[num + 1];

        result[0] = 0;

        for (int i = 1; i < num + 1; i++) {
            if ((i & i - 1) == 0) {
                result[i] = 1;
            } else if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else if (i % 2 == 0) {
                int onesAtTail = 0;
                int j = i - 1;
                while (j % 2 == 1) {
                    onesAtTail++;
                    j = j / 2;
                }
                result[i] = result[i - 1] - onesAtTail + 1;
            }
        }

        return result;
    }
}
