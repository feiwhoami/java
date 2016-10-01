/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 */
package leetcode;

public class LeetCode066PlusOne {

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        boolean allNine = true;

        for (int i = 0; i < n; i++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }

        if (allNine) {
            int[] result = new int[n + 1];
            result[0] = 1;
            for (int i = 1; i < n + 1; i++) {
                result[i] = 0;
            }
            return result;
        } else {
            int[] result = new int[n];

            result[n - 1] = (digits[n - 1] + 1) % 10;
            int carry = (digits[n - 1] + 1) / 10;

            for (int i = n - 2; i >= 0; i--) {
                int sum = carry + digits[i];
                result[i] = sum % 10;
                carry = sum / 10;
            }
            return result;
        }
    }
}
