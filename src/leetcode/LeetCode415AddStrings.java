/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
package leetcode;

public class LeetCode415AddStrings {

    public String addStrings(String num1, String num2) {

        String result = new String();

        if ((null == num1 || num1.isEmpty()) && (null == num2 || num2.isEmpty())) {
            return result;
        }

        if (null == num1 || num1.isEmpty()) {
            return num2;
        }

        if (null == num2 || num2.isEmpty()) {
            return num1;
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carryOn = 0;
        while (i >= 0 && j >= 0) {
            int tmp = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carryOn;
            result = tmp % 10 + result;
            carryOn = tmp / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int tmp = num1.charAt(i) - '0' + carryOn;
            result = tmp % 10 + result;
            carryOn = tmp / 10;
            i--;
        }

        while (j >= 0) {
            int tmp = num2.charAt(j) - '0' + carryOn;
            result = tmp % 10 + result;
            carryOn = tmp / 10;
            i--;
            j--;
        }

        if (carryOn != 0) {
            result = carryOn + result;
        }

        return result;
    }
}
