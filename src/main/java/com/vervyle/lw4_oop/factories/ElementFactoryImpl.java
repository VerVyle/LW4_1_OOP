package com.vervyle.lw4_oop.factories;

import com.vervyle.lw4_oop.drawable.CCircle;
import com.vervyle.lw4_oop.drawable.Element;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class ElementFactoryImpl implements ElementFactory{
    private final AnchorPane pane;
    private Color fill;

    public ElementFactoryImpl(AnchorPane pane) {
        this.pane = pane;
        fill = Color.BLACK;
    }

    @Override
    public Element createCircle(double x, double y, double radius) {
        return null;
    }

    @Override
    public Element createRectangle(double x, double y, double length, double width) {
        return null;
    }

    @Override
    public Element createEllipse(double x, double y, double radius1, double radius2) {
        return null;
    }

    @Override
    public Element createTriangle(double x, double y, double radius) {
        return null;
    }

    @Override
    public Element createLine(double x, double y, double x2, double y2) {
        return null;
    }

    @Override
    public Element createArc(double x, double y, double x2, double y2, double radius) {
        return null;
    }
}
