/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
package leetcode;

import java.util.Stack;

public class LeetCode155MinStack {

    private Stack<Integer> fullStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public LeetCode155MinStack() {
        fullStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        fullStack.push(x);
        if (minStack.isEmpty() || minStack.peek().intValue() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.peek().intValue() == fullStack.peek().intValue()) {
            minStack.pop();
        }
        fullStack.pop();
    }

    public int top() {
        return fullStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
