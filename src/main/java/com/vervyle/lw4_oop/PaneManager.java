package com.vervyle.lw4_oop;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public interface PaneManager {
    void selectAll(MouseEvent mouseEvent);

    void selectOne(MouseEvent mouseEvent);

    void addCircle(MouseEvent mouseEvent, double diameter, Color color);

    void delete();
}
