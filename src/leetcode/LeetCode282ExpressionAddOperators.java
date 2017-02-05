/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * 
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode282ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        addOperatorsHelper(num, target, "", 0, 0, result);

        return result;
    }

    private void addOperatorsHelper(String num, int target, String prevString, long prevRes, long prevNum,
            List<String> result) {

        if (prevRes == target && num.length() == 0) {
            String tmp = new String(prevString);
            result.add(tmp);
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String currString = num.substring(0, i);

            if (currString.length() > 1 && currString.charAt(0) == '0') {
                return;
            }

            String nextString = num.substring(i);
            long currNum = Long.valueOf(currString);

            if (prevString.length() != 0) {
                addOperatorsHelper(nextString, target, prevString + "*" + currString, (prevRes - prevNum) + currNum * prevNum,
                        currNum * prevNum, result);
                addOperatorsHelper(nextString, target, prevString + "+" + currString, prevRes + currNum, currNum, result);
                addOperatorsHelper(nextString, target, prevString + "-" + currString, prevRes - currNum, -currNum, result);
            } else {
                addOperatorsHelper(nextString, target, currString, currNum, currNum, result);
            }
        }
    }
}
