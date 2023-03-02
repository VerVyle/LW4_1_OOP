package com.vervyle.lw4_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PaintController implements Initializable {
    @FXML
    private AnchorPane main_pane;
    @FXML
    private MenuItem menu_exit;
    @FXML
    private MenuItem menu_save;
    @FXML
    private ColorPicker tool_color;
    @FXML
    private TextField tool_radius;
    @FXML
    private CheckBox ctrl_enable;
    @FXML
    private CheckBox set_enable;
    @FXML
    private ScrollPane scroll_pane;
    private PaneManager paneManager;

    private void onSave(ActionEvent actionEvent) {

    }

    private void onExit(ActionEvent actionEvent) {

    }

    /**
     * @// TODO: 01.03.2023 fix logic
     * @param mouseEvent
     */
    private void mouseClickedHandler(MouseEvent mouseEvent) {
        paneManager.addCircle(mouseEvent, Double.parseDouble(tool_radius.getText()), tool_color.getValue());
        /*if (!ctrl_enable.isSelected() || !set_enable.isSelected() || !mouseEvent.isControlDown()) {
            paneManager.selectOne(mouseEvent);
            return;
        }*/
        if (ctrl_enable.isSelected() && set_enable.isSelected() && mouseEvent.isControlDown())
            paneManager.selectAll(mouseEvent);
    }

    private void keyPressedHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE)
            paneManager.delete();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tool_radius.deselect();
        menu_save.setOnAction(this::onSave);
        menu_exit.setOnAction(this::onExit);
        main_pane.setOnMouseClicked(this::mouseClickedHandler);
        scroll_pane.setOnKeyPressed(this::keyPressedHandler);
        paneManager = new PaneController(main_pane);
    }
}

