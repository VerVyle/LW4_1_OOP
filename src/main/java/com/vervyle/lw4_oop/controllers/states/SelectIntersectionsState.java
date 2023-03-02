package com.vervyle.lw4_oop.controllers.states;

import com.vervyle.lw4_oop.controllers.PaneController;
import javafx.scene.input.MouseEvent;

public class SelectIntersectionsState implements WorkspaceState {

    @Override
    public boolean selectElement(PaneController paneController, MouseEvent mouseEvent) {
        paneController.deselectAll();
        boolean res = paneController.selectOne(mouseEvent);
        paneController.selectAll(mouseEvent);
        return res;
    }
}
