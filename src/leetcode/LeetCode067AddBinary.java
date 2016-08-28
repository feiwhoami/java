/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
package leetcode;

public class LeetCode067AddBinary {

    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carryon = 0;
        String result = "";

        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carryon;
            result = String.valueOf(sum % 2) + result;
            carryon = sum / 2;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = (a.charAt(i) - '0') + carryon;
            result = String.valueOf(sum % 2) + result;
            carryon = sum / 2;
            i--;
        }

        while (j >= 0) {
            int sum = (b.charAt(j) - '0') + carryon;
            result = String.valueOf(sum % 2) + result;
            carryon = sum / 2;
            j--;
        }

        if (1 == carryon) {
            result = "1" + result;
        }

        return result;

    }
}
