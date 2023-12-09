module org.example.prs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires io.reactivex.rxjava2;

    opens org.example.prs to javafx.fxml;
    exports org.example.prs;
}