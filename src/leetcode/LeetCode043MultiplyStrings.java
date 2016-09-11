/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 */
package leetcode;

public class LeetCode043MultiplyStrings {

    public String multiply(String num1, String num2) {

        if (null == num1 || null == num2) {
            return null;
        }

        int length1 = num1.length();
        int length2 = num2.length();
        int length3 = length1 + length2;
        int[] result = new int[length3];

        int i, j, product, carry;
        for (i = length1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = length2 - 1; j >= 0; j--) {
                product = carry + result[i + j + 1]
                        + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            result[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < length3 - 1 && result[i] == 0) {
            i++;
        }

        while (i < length3) {
            sb.append(result[i]);
            i++;
        }

        return sb.toString();
    }
}
