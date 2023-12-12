module org.example.prs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires io.reactivex.rxjava2;

    opens org.example.prs to javafx.fxml;
    exports org.example.prs;
    exports PRSGame.UI.View;
    opens PRSGame.UI.View to javafx.fxml;
    exports PRSGame.UI.ViewModel;
    opens PRSGame.UI.ViewModel to javafx.fxml;
    exports PRSGame.UI.ViewController;
    opens PRSGame.UI.ViewController to javafx.fxml;
    exports PRSGame.UI.ViewController.UIModels;
    opens PRSGame.UI.ViewController.UIModels to javafx.fxml;
    exports PRSGame.Feature;
    opens PRSGame.Feature to javafx.fxml;
    exports org.example.prs.Decorators;
    opens org.example.prs.Decorators to javafx.fxml;
    exports org.example.prs.MoveRepository;
    opens org.example.prs.MoveRepository to javafx.fxml;
}