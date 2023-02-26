module com.vervyle.lw4_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vervyle.lw4_oop to javafx.fxml;
    exports com.vervyle.lw4_oop;
}