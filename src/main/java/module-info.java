module com.vervyle.lw4_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vervyle.lw4_oop to javafx.fxml;
    exports com.vervyle.lw4_oop;
    exports com.vervyle.lw4_oop.controllers;
    opens com.vervyle.lw4_oop.controllers to javafx.fxml;
    exports com.vervyle.lw4_oop.controllers.states;
    opens com.vervyle.lw4_oop.controllers.states to javafx.fxml;
}