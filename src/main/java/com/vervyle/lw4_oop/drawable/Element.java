package com.vervyle.lw4_oop.drawable;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class Element implements Drawable {

    protected Shape shape;
    protected double x;
    protected double y;
    public boolean isSelected;
    protected final Pane pane;

    protected Element(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void select() {
        isSelected = true;
        shape.setStyle("-fx-stroke: #FF0000; -fx-stroke-width: 3px");
    }

    protected abstract boolean checkLocation(MouseEvent mouseEvent);

    @Override
    public boolean select(MouseEvent mouseEvent) {
        if (checkLocation(mouseEvent) && !isSelected) {
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

    @Override
    public void paint() {
        pane.getChildren().add(shape);
    }

    @Override
    public void delete() {
        pane.getChildren().remove(shape);
    }
}
