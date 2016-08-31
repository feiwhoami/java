/**
 * Given an integer, convert it to a Roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
package leetcode;

public class LeetCode012IntegertoRoman {

    public String intToRoman(int num) {

        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I", };
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String result = "";
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                result = result + symbol[i];
                num = num - value[i];
            }
        }

        return result;
    }
}
