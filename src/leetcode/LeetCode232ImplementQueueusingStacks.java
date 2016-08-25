/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
package leetcode;

import java.util.Stack;

public class LeetCode232ImplementQueueusingStacks {

    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        while (!tail.isEmpty()) {
            head.push(tail.pop());
        }

        head.push(x);
        return;
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!head.isEmpty()) {
            tail.push(head.pop());
        }

        tail.pop();
        return;
    }

    // Get the front element.
    public int peek() {
        while (!head.isEmpty()) {
            tail.push(head.pop());
        }

        return tail.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }

}
