/**
 * Given an array of characters, compress it in-place.
 *
 * <p>The length after compression must always be smaller than or equal to the original array.
 *
 * <p>Every element of the array should be a character (not int) of length 1.
 *
 * <p>After you are done modifying the input array in-place, return the new length of the array.
 *
 * <p>
 *
 * <p>Follow up: Could you solve it using only O(1) extra space?
 *
 * <p>
 *
 * <p>Example 1: Input: ["a","a","b","b","c","c","c"]
 *
 * <p>Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 *
 * <p>Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2: Input: ["a"]
 *
 * <p>Output: Return 1, and the first 1 characters of the input array should be: ["a"]
 *
 * <p>Explanation: Nothing is replaced. Example 3: Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 *
 * <p>Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 *
 * <p>Explanation: Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is
 * replaced by "b12". Notice each digit has it's own entry in the array.
 */
package leetcode;

public class LeetCode443StringCompression {
    public int compress(char[] chars) {
        int end = 0;
        int curr = 0;
        Integer count = 0;

        while (curr < chars.length) {
            if (chars[curr] == chars[end]) {
                curr++;
                count++;
            } else {
                end++;
                if (count != 1) {
                    for (int i = 0; i < count.toString().length(); i++) {
                        chars[end] = count.toString().charAt(i);
                        end++;
                    }
                }
                count = 0;
                chars[end] = chars[curr];
            }
        }

        if (count != 1) {
            end++;
            for (int i = 0; i < count.toString().length(); i++) {
                chars[end] = count.toString().charAt(i);
                end++;
            }
        }

        if (count == 1) {
            return end + 1;
        } else {
            return end;
        }
    }
}
