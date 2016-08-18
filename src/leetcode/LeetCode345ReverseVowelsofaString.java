/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode345ReverseVowelsofaString {

    public String reverseVowels(String s) {

        if (null == s) {
            return null;
        }

        char[] c = s.toCharArray();

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        List<Integer> vowelsPosition = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelsPosition.add(i);
            }
        }

        if (vowelsPosition.isEmpty()) {
            return s;
        }

        for (int i = 0, j = vowelsPosition.size() - 1; i < j; i++, j--) {
            char tmp = c[vowelsPosition.get(i)];
            c[vowelsPosition.get(i)] = c[vowelsPosition.get(j)];
            c[vowelsPosition.get(j)] = tmp;
        }

        return new String(c);
    }
}
