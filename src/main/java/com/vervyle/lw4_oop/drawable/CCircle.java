package com.vervyle.lw4_oop.drawable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CCircle {

    private final Circle circle;
    private final AnchorPane pane;
    private final double radius;
    private final double x;
    private final double y;
    private final Color color;
    public boolean isSelected;

    public void select() {
        isSelected = true;
        circle.setStyle("-fx-stroke: #FF0000; -fx-stroke-width: 3px");
    }

    public void deselect() {
        isSelected = false;
        circle.setStyle("-fx-stroke: #000000; -fx-stroke-width: 3px");
    }

    private boolean checkLocation(MouseEvent mouseEvent) {
        if (x <= mouseEvent.getX() + radius && mouseEvent.getX() <= x + radius)
            return y <= mouseEvent.getY() + radius && mouseEvent.getY() <= y + radius;
        return false;
    }

    public boolean select(MouseEvent mouseEvent) {
        if (checkLocation(mouseEvent) && !isSelected) {
            select();
            return true;
        }
        return false;
    }

    public CCircle(double x, double y, double radius, Color color, AnchorPane pane) {
        this.pane = pane;
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
        circle = new Circle(this.x, this.y, this.radius, this.color);
        select();
    }

    public void paint() {
        pane.getChildren().add(circle);
    }

    public void delete() {
        pane.getChildren().remove(circle);
    }
}
