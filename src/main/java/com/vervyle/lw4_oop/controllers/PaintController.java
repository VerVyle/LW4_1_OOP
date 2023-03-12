package com.vervyle.lw4_oop.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventDispatchChain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class PaintController implements Initializable {
    private Workspace workspace;
    @FXML
    private AnchorPane main_pane;
    @FXML
    private CheckBox tool_ctrl_enable;
    @FXML
    private ListView<String> tool_element_list;
    @FXML
    private CheckBox tool_groups_enable;
    @FXML
    private Label tool_mouse_location;
    @FXML
    private Label tool_pane_size;
    @FXML
    private Button tool_scale_minus;
    @FXML
    private Button tool_scale_plus;

    private void onSave(ActionEvent actionEvent) {

    }

    private void onExit(ActionEvent actionEvent) {

    }

    private void mouseClickedHandler(MouseEvent mouseEvent) {
        if (!workspace.anyFit(mouseEvent.getX(), mouseEvent.getY())) {
            workspace.addElement(mouseEvent);
            return;
        }
        workspace.selectElement(mouseEvent);
    }

    private void keyPressedHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE)
            workspace.deleteSelectedElements();
    }

    private void initElementsGUI() {
        String [] elements = {
                "Circle",
                "Rectangle",
                "Arc",
                "Line",
                "Polygon"
        };
        tool_element_list.getItems().addAll(elements);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initElementsGUI();
    }

    //    private void workspaceInit() {
//        workspace = new Workspace(main_pane, tool_color, tool_radius);
//        ctrl_enable.selectedProperty().addListener((observableValue, oldVal, newVal) -> {
//            if (newVal && set_enable.isSelected()) {
//                workspace.setState(Workspace.ADD_TO_SELECTION_INTERSECTIONS_STATE);
//                return;
//            }
//            if (newVal && !set_enable.isSelected()) {
//                workspace.setState(Workspace.ADD_TO_SELECTION_SINGLES_STATE);
//                return;
//            }
//            if (oldVal && set_enable.isSelected()) {
//                workspace.setState(Workspace.SELECT_INTERSECTIONS_STATE);
//                return;
//            }
//            workspace.setState(Workspace.DEFAULT_STATE);
//        });
//        set_enable.selectedProperty().addListener((observableValue, oldVal, newVal) -> {
//            if (newVal && ctrl_enable.isSelected()) {
//                workspace.setState(Workspace.ADD_TO_SELECTION_INTERSECTIONS_STATE);
//                return;
//            }
//            if (newVal && !ctrl_enable.isSelected()) {
//                workspace.setState(Workspace.SELECT_INTERSECTIONS_STATE);
//                return;
//            }
//            if (oldVal && ctrl_enable.isSelected()) {
//                workspace.setState(Workspace.ADD_TO_SELECTION_SINGLES_STATE);
//                return;
//            }
//            workspace.setState(Workspace.DEFAULT_STATE);
//        });
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        menu_save.setOnAction(this::onSave);
//        menu_exit.setOnAction(this::onExit);
//        main_pane.setOnMouseClicked(this::mouseClickedHandler);
//        scroll_pane.setOnKeyPressed(this::keyPressedHandler);
//        workspaceInit();
//    }
}

