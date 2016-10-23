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

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        generateHelper(numRows - 1, first, result);
        return result;
    }

    private void generateHelper(int numRows, List<Integer> pre, List<List<Integer>> result) {
        if (numRows == 0) {
            return;
        }

        int len = pre.size();
        List<Integer> curr = new ArrayList<>();
        curr.add(1);

        for (int i = 1; i < len; i++) {
            curr.add(pre.get(i) + pre.get(i - 1));
        }

        curr.add(1);

        result.add(curr);

        generateHelper(numRows - 1, curr, result);
    }
}
