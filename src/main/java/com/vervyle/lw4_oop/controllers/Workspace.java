package com.vervyle.lw4_oop.controllers;

import com.vervyle.lw4_oop.controllers.states.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Workspace {

    public static final WorkspaceState ADD_TO_SELECTION_INTERSECTIONS_STATE;
    public static final WorkspaceState ADD_TO_SELECTION_SINGLES_STATE;
    public static final WorkspaceState DEFAULT_STATE;
    public static final WorkspaceState SELECT_INTERSECTIONS_STATE;

    protected final PaneController paneController;
    protected final ColorPicker tool_color;
    protected final TextField tool_radius;
    private WorkspaceState state;

    public Workspace(AnchorPane anchorPane, ColorPicker colorPicker, TextField textField) {
        paneController = new PaneController(anchorPane);
        tool_radius = textField;
        tool_color = colorPicker;
        state = DEFAULT_STATE;
    }

    public void addElement(MouseEvent mouseEvent) {
        paneController.addCircle(mouseEvent, Double.parseDouble(tool_radius.getText()), tool_color.getValue());
    }

    public boolean selectElement(MouseEvent mouseEvent) {
        return state.selectElement(paneController, mouseEvent);
    }

    public void deleteSelectedElements() {
        paneController.delete();
    }

    public void setState(WorkspaceState state) {
        this.state = state;
    }

    static {
        ADD_TO_SELECTION_INTERSECTIONS_STATE = new AddToSelectionIntersectionsState();
        ADD_TO_SELECTION_SINGLES_STATE = new AddToSelectionSinglesState();
        DEFAULT_STATE = AddToSelectionSinglesState.DEFAULT_STATE;
        SELECT_INTERSECTIONS_STATE = AddToSelectionIntersectionsState.SELECT_INTERSECTIONS_STATE;
    }
}
