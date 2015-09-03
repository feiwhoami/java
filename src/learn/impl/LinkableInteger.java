package learn.impl;

public class LinkableInteger implements LinkedStack.Linkable {
    // Here's the node's data and constructor
    int i;

    public LinkableInteger(int i) {
        this.i = i;
    }

    // Here are the data and methods required to implement the interface
    LinkedStack.Linkable next;

    public LinkedStack.Linkable getNext() {
        return next;
    }

    public void setNext(LinkedStack.Linkable node) {
        next = node;
    }

    public int getInteger() {
        return i;
    }

}
