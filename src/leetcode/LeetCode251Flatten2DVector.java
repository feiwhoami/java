/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example,
 * Given 2d vector =
 * 
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * 
 * Hint:
 * 
 * How many variables do you need to keep track?
 * Two variables is all you need. Try with x and y.
 * Beware of empty rows. It could be the first few rows.
 * To write correct code, think about the invariant to maintain. What is it?
 * The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
 * Not sure? Think about how you would implement hasNext(). Which is more complex?
 * Common logic in two different places should be refactored into a common method.
 */
package leetcode;

import java.util.Iterator;
import java.util.List;

public class LeetCode251Flatten2DVector {

    Iterator<List<Integer>> listIter;
    Iterator<Integer> curr;

    public LeetCode251Flatten2DVector(List<List<Integer>> vec2d) {
        listIter = vec2d.iterator();
    }

    public Integer next() {
        hasNext();
        return curr.next();
    }

    public boolean hasNext() {
        while ((null == curr || !curr.hasNext()) && listIter.hasNext()) {
            curr = listIter.next().iterator();
        }
        return curr != null && curr.hasNext();
    }
}
