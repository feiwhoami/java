/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        if (rowIndex < 0) {
            return null;
        }

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        even.add(1);

        for (int index = 1; index <= rowIndex; index++) {
            if (index % 2 == 0) { // even
                even.add(1);
                for (int i = 0; i < odd.size(); i++) {
                    if (i + 1 < odd.size()) {
                        even.add(odd.get(i) + odd.get(i + 1));
                    }
                }
                even.add(1);
                odd.clear();
            } else { // odd
                odd.add(1);
                for (int i = 0; i < even.size(); i++) {
                    if (i + 1 < even.size()) {
                        odd.add(even.get(i) + even.get(i + 1));
                    }
                }
                odd.add(1);
                even.clear();
            }
        }

        if (rowIndex % 2 == 0) {
            return even;
        } else {
            return odd;
        }
    }
}
