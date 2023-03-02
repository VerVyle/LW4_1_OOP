package com.vervyle.lw4_oop.containers;

import java.util.Iterator;

public interface MyList<T> {

    boolean isEmpty();

    int size();

    void add(T val);

    void add(T val, int where);

    void remove(T val);

    void remove(int where);

    Iterator<T> iterator();

    void print();
}
