module bombergame.master1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens uet.oop.bomberman to javafx.fxml;
    exports uet.oop.bomberman;
}