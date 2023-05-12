module rummikub {
    requires javafx.controls;
    requires javafx.fxml;

    opens rummikub to javafx.fxml;
    exports rummikub;
}
