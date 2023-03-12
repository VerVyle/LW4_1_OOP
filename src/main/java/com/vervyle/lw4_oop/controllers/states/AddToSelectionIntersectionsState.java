package com.vervyle.lw4_oop.controllers.states;

import com.vervyle.lw4_oop.controllers.PaneController;
import javafx.scene.input.MouseEvent;

public class AddToSelectionIntersectionsState implements WorkspaceState {

    public static final WorkspaceState SELECT_INTERSECTIONS_STATE;

    @Override
    public boolean selectElement(PaneController paneController, MouseEvent mouseEvent) {
        if (!mouseEvent.isControlDown()) {
            SELECT_INTERSECTIONS_STATE.selectElement(paneController, mouseEvent);
        }
        boolean res = paneController.selectOne(mouseEvent.getX(), mouseEvent.getY());
        paneController.selectAll(mouseEvent.getX(), mouseEvent.getY());
        return res;
    }

    static {
        SELECT_INTERSECTIONS_STATE = new SelectIntersectionsState();
    }
}
