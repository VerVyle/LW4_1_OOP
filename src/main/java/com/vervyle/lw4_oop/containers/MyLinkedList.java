package com.vervyle.lw4_oop.containers;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class MyLinkedList<T> implements MyList<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        final Node<T> newNode = new Node<>(last, element, null);
        Node<T> prev = last;
        last = newNode;
        if (prev != null)
            prev.next = newNode;
        else
            first = newNode;
        size++;
    }

    @Override
    public void add(T element, int where) {
        if (where > size)
            throw new RuntimeException("Out of range");
        if (where == size)
            add(element);
        Node<T> current = first;
        int iter = 0;
        while (iter < where) {
            current = current.next;
            iter++;
        }
        Node<T> prev = current.prev;
        Node<T> newNode = new Node<>(current.prev, element, current.next);
        current.prev = newNode;
        if (prev != null)
            prev.next = newNode;
        else
            first = newNode;
        size++;
    }

    private void linkNeighbours(Node<T> current) {
        Node<T> prev = current.prev;
        if (prev != null)
            prev.next = current.next;
        else
            first = current.next;
        Node<T> next = current.next;
        if (next == null)
            last = prev;
        else
            next.prev = prev;
    }

    @Override
    public void remove(T element) {
        Node<T> current = first;
        while (current != null) {
            if (current.value == element)
                break;
            current = current.next;
        }
        if (current == null)
            throw new RuntimeException("Element not found");
        linkNeighbours(current);
        size--;
    }

    @Override
    public void remove(int where) {
        if (where >= size || where < 0)
            throw new RuntimeException("Out of range");
        Node<T> current = first;
        for (int i = 0; i < where; i++) {
            current = current.next;
        }
        linkNeighbours(current);
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator(0);
    }

    @Override
    public void print() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    private class MyIterator implements Iterator<T> {
        private Node<T> next;
        private int nextIndex;

        public MyIterator(int index) {
            next = (index == size) ? null : first;
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return next.next != null;
        }

        @Override
        public T next() {
            if (next != null) {
                Node<T> current = next;
                next = next.next;
                nextIndex++;
                return current.value;
            }
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            while (nextIndex < size) {
                action.accept(next.value);
                nextIndex++;
                next = next.next;
            }
        }
    }
}
