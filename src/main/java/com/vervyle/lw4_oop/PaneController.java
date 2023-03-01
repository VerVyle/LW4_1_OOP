package com.vervyle.lw4_oop;

import com.vervyle.lw4_oop.drawable.CCircle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PaneController implements PaneManager {

    private final AnchorPane pane;
    private final Container container;

    public PaneController(AnchorPane pane) {
        this.pane = pane;
        container = new Container();
    }

    @Override
    public void selectAll(MouseEvent mouseEvent) {
        Iterator<CCircle> iterator = container.getAll().iterator();
        iterator.forEachRemaining(cCircle -> {
            cCircle.select(mouseEvent);
        });
    }

    @Override
    public void selectOne(MouseEvent mouseEvent) {
        LinkedList<CCircle> list = new LinkedList<>(container.getAll());
        Iterator<CCircle> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            if (iterator.next().select(mouseEvent))
                return;
        }
    }

    private void selectLastCreated() {
        CCircle cCircle = container.getLast();
        if (cCircle != null) cCircle.select();
    }

    private void deselectAll() {
        Iterator<CCircle> iterator = container.getAll().iterator();
        iterator.forEachRemaining(CCircle::deselect);
    }

    @Override
    public void addCircle(MouseEvent mouseEvent, double radius, Color color) {
        deselectAll();
        CCircle circle = new CCircle(
                mouseEvent.getX(),
                mouseEvent.getY(),
                radius,
                color,
                pane);
        container.add(circle);
        circle.paint();
    }

    @Override
    public void delete() {
        Iterator<CCircle> iterator = container.getAll().listIterator();
        List<CCircle> toDelete = new LinkedList<>();
        while (iterator.hasNext()) {
            CCircle cCircle = iterator.next();
            if (cCircle.isSelected) {
                cCircle.delete();
                toDelete.add(cCircle);
            }
        }
        container.delete(toDelete);
        selectLastCreated();
    }
}
