package com.vervyle.lw4_oop.drawable;

import javafx.scene.input.MouseEvent;

public interface Drawable {
    void select();

    void deselect();

    boolean select(double x, double y);
}
