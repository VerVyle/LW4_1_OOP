package com.vervyle.lw4_oop.controllers.states;

import com.vervyle.lw4_oop.controllers.PaneController;
import javafx.scene.input.MouseEvent;

public interface WorkspaceState {
    boolean selectElement(PaneController paneController, MouseEvent mouseEvent);
}
