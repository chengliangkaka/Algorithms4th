package com.kaka;

import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;

import java.util.Iterator;

/**
 * Created by Administrator on 2016/6/3.
 */
public class ResizingArrayStack<Item> implements IStack<Item>, Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        // 稍后可以找相关的数组api实现类似的功能
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * N);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null; // 避免对象游离
        if (N > 0 && N == a.length / 4) { // 避免浪费更多的存储空间
            resize(a.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {

        }
    }
}
