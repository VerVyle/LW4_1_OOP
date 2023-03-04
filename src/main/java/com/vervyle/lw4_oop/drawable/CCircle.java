package com.vervyle.lw4_oop.drawable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CCircle extends Element{

    private final double radius;

    @Override
    public boolean checkLocation(MouseEvent mouseEvent) {
        if (x <= mouseEvent.getX() + radius && mouseEvent.getX() <= x + radius)
            return y <= mouseEvent.getY() + radius && mouseEvent.getY() <= y + radius;
        return false;
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
