package com.kaka;

/**
 * Created by Administrator on 2016/6/3.
 */
public interface IStack<Item> {
    boolean isEmpty();

    int size();

    void push(Item item);

    Item pop();
}
