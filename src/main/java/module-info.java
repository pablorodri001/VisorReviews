module com.example.exameord {
    requires javafx.controls;
    requires javafx.fxml;



    exports com.liceo.di.exameord.review;
    exports com.liceo.di.exameord.gui;
    opens com.liceo.di.exameord.gui to javafx.fxml;
}