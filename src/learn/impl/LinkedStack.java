package learn.impl;

import java.util.Iterator;

public class LinkedStack {
    // This static member interface defines how objects are linked
    // The static keyword is optional: all nested interfaces are static
    public interface Linkable {
        public Linkable getNext();

        public void setNext(Linkable node);
    }

    // The head of the list is a Linkable object
    Linkable head;

    // Method bodies omitted
    public void push(Linkable node) {
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.getNext();
    }

    public Linkable top() {
        return head;
    }

    // This method returns an Iterator object for this LinkedStack
    public Iterator<Linkable> iterator() {
        return new LinkedIterator();
    }

    // Here is the implementation of the Iterator interface,
    // defined as a nonstatic member class.
    protected class LinkedIterator implements Iterator<Linkable> {
        Linkable current;

        // The constructor uses a private field of the containing class
        public LinkedIterator() {
            current = head;
        }

        // The following 3 methods are defined by the Iterator interface
        public boolean hasNext() {
            return current != null;
        }

        public Linkable next() {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            Linkable value = current;
            current = current.getNext();
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
