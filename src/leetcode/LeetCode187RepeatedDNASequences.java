/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode187RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new ArrayList<>();
        if (null == s || s.length() <= 10) {
            return result;
        }

        int len = s.length();
        Set<String> hash = new HashSet<>();

        for (int i = 0; i <= len - 10; i++) {
            String subStr = s.substring(i, i + 10);
            if (hash.contains(subStr) && !result.contains(subStr)) {
                result.add(subStr);
            } else {
                hash.add(subStr);
            }
        }
        return result;
    }
}
