package com.vervyle.lw4_oop.drawable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Element implements Drawable {

    protected Shape shape;
    protected double x;
    protected double y;
    public boolean isSelected;
    protected final Pane pane;
    protected Color color;

    protected Element(double x, double y, Pane pane, Color color) {
        this.x = x;
        this.y = y;
        this.pane = pane;
        this.color = color;
    }

    @Override
    public void select() {
        isSelected = true;
        shape.setStyle("-fx-stroke: #FF0000; -fx-stroke-width: 3px");
    }

    public abstract boolean checkLocation(double x, double y);

    @Override
    public boolean select(double x, double y) {
        if (checkLocation(x, y) && !isSelected) {
            select();
            return true;
        }
        return false;
    }

    @Override
    public void deselect() {
        isSelected = false;
        shape.setStyle("-fx-stroke: #000000; -fx-stroke-width: 3px");
    }

    public void paint() {
        pane.getChildren().add(shape);
    }

    public void delete() {
        pane.getChildren().remove(shape);
    }
}
