package com.kaka;

import java.util.Iterator;

/**
 * Created by Administrator on 2016/6/28.
 */
public class LinkedStack<Item> implements IStack<Item>,Iterable<Item> {
    private Node first; // 栈顶元素
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public Item pop() {
        Item item =first.item;
        first=first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;
        private Node current=first;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            Item item=current.item;
            current=current.next;
            i--;
            return item;
        }

        public void remove() {

        }
    }
}
