package com.vervyle.lw4_oop.factories;

import com.vervyle.lw4_oop.drawable.Element;

public interface ElementFactory {
    Element createCircle(double x, double y, double radius);

    Element createRectangle(double x, double y, double length, double width);

    Element createEllipse(double x, double y, double radius1, double radius2);

    Element createTriangle(double x, double y, double radius);

    Element createLine(double x, double y, double x2, double y2);

    Element createArc(double x, double y, double x2, double y2, double radius);
}
