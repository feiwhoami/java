/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * 
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * 
 * Call next() gets you 1, the first element in the list.
 * 
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * 
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 * 
 * Hint:
 * 
 * Think of "looking ahead". You want to cache the next element.
 * Is one variable sufficient? Why or why not?
 * Test your design with call order of peek() before next() vs next() before peek().
 */
package leetcode;

import java.util.Iterator;

public class LeetCode284PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer top;

    public LeetCode284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            this.top = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return top.intValue();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = top.intValue();
        if (iterator.hasNext()) {
            top = iterator.next();
        } else {
            top = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (top == null && !iterator.hasNext()) {
            return false;
        }
        return true;
    }

    @Override
    public void remove() {

    }

}
