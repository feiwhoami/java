/**
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input longegers?
 */
package leetcode;

public class LeetCode306AdditiveNumber {

    public boolean isAdditiveNumber(String num) {

        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length() - i - 1; j++) {
                String first = num.substring(0, i + 1);
                String second = num.substring(i + 1, j + 1);
                if (isAdditiveNumberHelper(j + 1, num, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumberHelper(int index, String num, String first, String second) {

        if (index == num.length()) {
            return true;
        }

        long f = Long.parseLong(first);
        long s = Long.parseLong(second);

        if (!Long.toString(f).equals(first) || !Long.toString(s).equals(second)) {
            return false;
        }

        long sum = f + s;
        String sumString = Long.toString(sum);

        if (index + sumString.length() > num.length()) {
            return false;
        }

        String third = num.substring(index, index + sumString.length());
        long t = Long.parseLong(third);

        if (!Long.toString(t).equals(third) || t != sum) {
            return false;
        }

        return isAdditiveNumberHelper(index + sumString.length(), num, second, third);
    }
}
