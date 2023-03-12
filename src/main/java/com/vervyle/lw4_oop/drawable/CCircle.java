package com.vervyle.lw4_oop.drawable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CCircle extends Element {

    private final double radius;

    @Override
    public boolean checkLocation(double x, double y) {
        return ((Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= Math.pow(radius, 2));
    }

    public CCircle(double x, double y, double radius, AnchorPane pane, Color color) {
        super(x, y, pane, color);
        this.radius = radius;
        this.shape = new Circle(this.x, this.y, this.radius, this.color);
        select();
    }

    public void paint() {
        pane.getChildren().add(shape);
    }

    public void delete() {
        pane.getChildren().remove(shape);
    }
}
