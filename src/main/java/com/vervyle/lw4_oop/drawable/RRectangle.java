package com.vervyle.lw4_oop.drawable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RRectangle extends Element {

    protected double width;
    protected double length;

    @Override
    public boolean checkLocation(MouseEvent mouseEvent) {
        if (x <= mouseEvent.getX() + width / 2 && mouseEvent.getX() <= x + width / 2)
            return y <= mouseEvent.getY() + length / 2 && mouseEvent.getY() <= y + length / 2;
        return false;
    }

    public RRectangle(double x, double y, double width, double length, AnchorPane pane, Color color) {
        super(x, y, pane, color);
        this.length = length;
        this.width = width;
        shape = new Rectangle(x, y, length, width);
        shape.setFill(color);
        select();
    }
}
