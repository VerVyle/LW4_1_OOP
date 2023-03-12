package com.vervyle.lw4_oop.drawable;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RRectangle extends Element {

    protected double width;
    protected double length;

    @Override
    public boolean checkLocation(double x, double y) {
        if (this.x <= x + width / 2 && x <= this.x + width / 2)
            return this.y <= y + length / 2 && y <= this.y + length / 2;
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
