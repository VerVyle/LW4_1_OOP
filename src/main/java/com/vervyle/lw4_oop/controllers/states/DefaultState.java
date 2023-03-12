package com.vervyle.lw4_oop.controllers.states;

import com.vervyle.lw4_oop.controllers.PaneController;
import javafx.scene.input.MouseEvent;

public class DefaultState implements WorkspaceState {

    @Override
    public boolean selectElement(PaneController paneController, MouseEvent mouseEvent) {
        paneController.deselectAll();
        return paneController.selectOne(mouseEvent.getX(), mouseEvent.getY());
    }
}
