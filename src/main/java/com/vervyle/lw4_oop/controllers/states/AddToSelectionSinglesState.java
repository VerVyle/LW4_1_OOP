package com.vervyle.lw4_oop.controllers.states;

import com.vervyle.lw4_oop.controllers.PaneController;
import javafx.scene.input.MouseEvent;

public class AddToSelectionSinglesState implements WorkspaceState {

    public static final WorkspaceState DEFAULT_STATE;

    @Override
    public boolean selectElement(PaneController paneController, MouseEvent mouseEvent) {
        if (!mouseEvent.isControlDown()) {
            DEFAULT_STATE.selectElement(paneController, mouseEvent);
        }
        return paneController.selectOne(mouseEvent.getX(), mouseEvent.getY());
    }

    static {
        DEFAULT_STATE = new DefaultState();
    }
}
