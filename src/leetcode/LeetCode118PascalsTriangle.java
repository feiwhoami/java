/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }

        int[] first = new int[1];
        first[0] = 1;
        List<Integer> firstList = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            firstList.add(first[i]);
        }
        result.add(firstList);

        generateHelper(numRows - 1, first, result);
        return result;
    }

    private void generateHelper(int numRows, int[] pre, List<List<Integer>> result) {
        if (numRows == 0) {
            return;
        }

        int len = pre.length;
        int[] curr = new int[len + 1];
        curr[0] = 1;
        curr[len] = 1;

        for (int i = 1; i < len; i++) {
            curr[i] = pre[i] + pre[i - 1];
        }

        List<Integer> currList = new ArrayList<>();
        for (int i = 0; i < curr.length; i++) {
            currList.add(curr[i]);
        }

        result.add(currList);

        generateHelper(numRows - 1, curr, result);
    }
}
