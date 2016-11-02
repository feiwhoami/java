/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146LRUCache {

    private class DoubleListNode {
        private int key;
        private int val;
        DoubleListNode prev;
        DoubleListNode next;

        public DoubleListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    private int capacity;
    private DoubleListNode head;
    private DoubleListNode tail;
    private Map<Integer, DoubleListNode> map;

    public LeetCode146LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = head;
        map = new HashMap<>();

    }

    public int get(int key) {

        if (map.containsKey(key)) {
            DoubleListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            DoubleListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleListNode newNode = new DoubleListNode(key, value);
            if (map.size() < capacity) {
                setHead(newNode);
                map.put(key, newNode);
            } else {
                map.remove(tail.key);
                removeNode(tail);
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }

    private void removeNode(DoubleListNode node) {
        DoubleListNode prev = node.prev;
        DoubleListNode next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
    }

    private void setHead(DoubleListNode node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = node;
        }
    }
}
