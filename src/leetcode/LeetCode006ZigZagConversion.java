/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
package leetcode;

public class LeetCode006ZigZagConversion {

    public String convert(String s, int numRows) {

        if (null == s || 0 == s.length() || numRows < 0) {
            return "";
        }

        if (1 == numRows) {
            return s;
        }

        int size = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + size) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int tmp = j + size - 2 * i;
                    if (tmp < s.length()) {
                        sb.append(s.charAt(tmp));
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
