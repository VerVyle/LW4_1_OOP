package com.vervyle.lw4_oop.containers;

import com.vervyle.lw4_oop.drawable.CCircle;
import java.util.*;

public class Container {
    private List<CCircle> list;

    public Container() {
        list = new LinkedList<>();
    }

    public void add(CCircle circle) {
        list.add(circle);
    }

    public List<CCircle> getAll() {
        return list;
    }

    public CCircle getLast() {
        if (list.size() == 0) return null;
        return list.get(list.size() - 1);
    }

    public void delete(List<CCircle> toDelete) {
        Iterator<CCircle> iterator = toDelete.iterator();
        iterator.forEachRemaining(circle -> {
            list.remove(circle);
        });
    }

    public void delete(CCircle circle) {
        list.remove(circle);
    }
}
