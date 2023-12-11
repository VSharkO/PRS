module org.example.prs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires io.reactivex.rxjava2;

    opens org.example.prs to javafx.fxml;
    exports org.example.prs;
    exports UI.View;
    opens UI.View to javafx.fxml;
    exports UI.ViewModel;
    opens UI.ViewModel to javafx.fxml;
    exports UI.ViewController;
    opens UI.ViewController to javafx.fxml;
    exports UI.ViewController.UIModels;
    opens UI.ViewController.UIModels to javafx.fxml;
}