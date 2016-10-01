/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode068TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        if (null == words || words.length == 0) {
            return result;
        }

        int start = 0, end = 0;
        while (start < words.length) {
            int totalCurrentLength = 0;
            while (end < words.length && totalCurrentLength + words[end].length() <= maxWidth) {
                totalCurrentLength = totalCurrentLength + words[end].length() + 1;
                end++;
            }
            String newLine = createOneLine(words, start, end - 1, maxWidth);
            result.add(newLine);
            start = end;
        }

        return result;
    }

    private String createOneLine(String[] words, int start, int end, int maxWidth) {

        StringBuilder result = new StringBuilder();

        int totalWordsLength = 0;
        int countWords = end - start + 1;
        int totalSpaceLength = 0;

        for (int i = start; i <= end; i++) {
            totalWordsLength = totalWordsLength + words[i].length();
        }
        totalSpaceLength = maxWidth - totalWordsLength;

        if (countWords == 1) {
            result.append(words[start]);
            while (totalSpaceLength > 0) {
                result.append(" ");
                totalSpaceLength--;
            }

        } else if (end == words.length - 1) {
            for (int i = start; i <= end; i++) {
                result.append(words[i]);
                result.append(" ");
                totalSpaceLength--;
            }
            while (totalSpaceLength > 0) {
                result.append(" ");
                totalSpaceLength--;
            }

        } else {

            int[] spaceSize = new int[countWords - 1];
            int index = 0;
            while (totalSpaceLength > 0) {
                spaceSize[index % (countWords - 1)]++;
                totalSpaceLength--;
                index++;
            }
            index = 0;

            for (int i = start; i <= end; i++) {
                result.append(words[i]);
                while (index < spaceSize.length && spaceSize[index] > 0) {
                    result.append(" ");
                    spaceSize[index]--;
                }
                index++;
            }
        }

        return result.toString();
    }
}
