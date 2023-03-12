package com.vervyle.lw4_oop.controllers;

import com.vervyle.lw4_oop.containers.MyLinkedList;
import com.vervyle.lw4_oop.containers.MyList;
import com.vervyle.lw4_oop.drawable.CCircle;
import com.vervyle.lw4_oop.drawable.Element;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PaneController {

    private final AnchorPane pane;
    private final MyList<Element> container;
    private final MyList<Element> selectedGroup;

    public PaneController(AnchorPane pane) {
        this.pane = pane;
        container = new MyLinkedList<>();
        selectedGroup = new MyLinkedList<>();
    }

    public boolean anyFit(double x, double y) {
        Iterator<Element> iterator = container.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().checkLocation(x, y))
                return true;
        }
        return false;
    }

    public void selectAll(double x, double y) {
        Iterator<Element> iterator = container.iterator();
        iterator.forEachRemaining(element -> {
            element.select(x, y);
            if (element.checkLocation(x, y))
                selectedGroup.add(element);
        });
    }

    public boolean selectOne(double x, double y) {
        MyLinkedList<Element> list = (MyLinkedList<Element>)container;
        Iterator<Element> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            if (iterator.next().select(x, y))
                return true;
        }
        return false;
    }

    public void selectLastCreated() {
        Element element = container.getLast();
        if (element != null) element.select();
    }

    public void deselectAll() {
        Iterator<Element> iterator = container.iterator();
        iterator.forEachRemaining(Element::deselect);
    }

    public void addCircle(MouseEvent mouseEvent, double radius, Color color) {
        deselectAll();
        CCircle circle = new CCircle(
                mouseEvent.getX(),
                mouseEvent.getY(),
                radius,
                pane,
                color);
        container.add(circle);
        circle.paint();
    }

    public void delete() {
        Iterator<Element> iterator = container.iterator();
        MyList<Element> toDelete = new MyLinkedList<>();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if (element.isSelected) {
                element.delete();
                toDelete.add(element);
            }
        }
        container.remove(toDelete);
        selectLastCreated();
    }
}
