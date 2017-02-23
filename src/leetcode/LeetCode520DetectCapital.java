/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * 
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
package leetcode;

public class LeetCode520DetectCapital {

    public boolean detectCapitalUse(String word) {
        
        if (null == word) {
            return false;
        }

        boolean allCap = !Character.isLowerCase(word.charAt(0));
        boolean allLow = Character.isLowerCase(word.charAt(0));
        boolean firstCap = !Character.isLowerCase(word.charAt(0));
        
        for (int i = 1; i < word.length(); i++) {
            allCap = allCap && !Character.isLowerCase(word.charAt(i));
            allLow = allLow && Character.isLowerCase(word.charAt(i));
            firstCap = firstCap && Character.isLowerCase(word.charAt(i));
            
            if (!allCap && !allLow && !firstCap) {
                return false;
            }
        }

        return true;
    }

}
