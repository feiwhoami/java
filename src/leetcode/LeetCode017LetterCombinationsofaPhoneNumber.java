/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode017LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return result;
        }
        String curr = "";
        letterCombinationsHelper(digits, 0, curr, result);

        return result;
    }

    private void letterCombinationsHelper(String digits, int index, String curr, List<String> result) {

        if (index > digits.length()) {
            return;
        }

        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        char c = digits.charAt(index);

        if (c == '0') {
            letterCombinationsHelper(digits, index + 1, curr, result);
        } else if (c == '1') {
            letterCombinationsHelper(digits, index + 1, curr, result);
        } else if (c == '2') {
            curr = curr + 'a';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'b';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'c';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '3') {
            curr = curr + 'd';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'e';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'f';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '4') {
            curr = curr + 'g';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'h';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'i';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '5') {
            curr = curr + 'j';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'k';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'l';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '6') {
            curr = curr + 'm';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'n';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'o';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '7') {
            curr = curr + 'p';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'q';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'r';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 's';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '8') {
            curr = curr + 't';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'u';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'v';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        } else if (c == '9') {
            curr = curr + 'w';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'x';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'y';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);

            curr = curr + 'z';
            letterCombinationsHelper(digits, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
