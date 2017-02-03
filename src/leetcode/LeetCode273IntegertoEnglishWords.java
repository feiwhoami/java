/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * 
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * 
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
 */
package leetcode;

public class LeetCode273IntegertoEnglishWords {

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String[] word = { "", "Thousand", "Million", "Billion" };

        int i = 0;
        String result = new String();
        while (num > 0) {
            int temp = num % 1000;
            if (temp > 0) {
                if (i == 0) {
                    result = convert(temp);
                } else {
                    result = convert(temp) + " " + word[i] + (result.length() == 0 ? "" : " " + result);
                }
            }
            num = num / 1000;
            i++;
        }

        return result;
    }

    private String convert(int num) {
        String[] ten = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        String[] twenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };
        String[] hundred = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

        String result = new String();

        int first = num / 100;
        if (first != 0) {
            result = result + ten[first] + " " + "Hundred";
        }

        int second = num % 100 / 10;
        int third = num % 10;

        if (second >= 2) {
            if (result.isEmpty()) {
                result = hundred[second];
            } else {
                result = result + " " + hundred[second];
            }
            if (third != 0) {
                result = result + " " + ten[third];
            }
        } else if (second == 1) {
            if (result.isEmpty()) {
                result = twenty[third];
            } else {
                result = result + " " + twenty[third];
            }
        } else if (second == 0) {
            if (result.isEmpty()) {
                result = ten[third];
            } else {
                if (third != 0) {
                    result = result + " " + ten[third];
                }
            }
        }

        return result;
    }
}
