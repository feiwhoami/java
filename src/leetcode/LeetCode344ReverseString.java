/**
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 */

package leetcode;

public class LeetCode344ReverseString {

    public String reverseString(String s) {

        char[] c = s.toCharArray();

        int i = 0;
        int j = c.length - 1;

        while (i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }

        return new String(c);
    }

}
