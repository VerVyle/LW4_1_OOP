package com.vervyle.lw4_oop.drawable;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RRectangle extends Element {

    public RRectangle(double x, double y, Color color, double length, double width, AnchorPane pane) {
        super(pane);
        this.x = x;
        this.y = y;
        shape = new Rectangle(x, y, length, width);
        shape.setFill(color);
        isSelected = false;
    }
}
