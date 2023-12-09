package org.example.prs;

import Feature.GameServiceImpl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import java.io.IOException;
import Domain.*;

public class HelloApplication extends Application {
    private GameViewModel viewModel = new GameViewModel(
            new GameServiceImpl(),
            PublishSubject.create(),
            PublishSubject.create());
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Paper-Rock-Scissors Game");

        Text resultText = new Text();
        var disposable = viewModel.output.subscribe(text -> {
            resultText.textProperty().set(text);
        });

        compositeDisposable.add(
                disposable
        );
        compositeDisposable.add(
                viewModel.bind()
        );

        Button paperButton = new Button("Paper");
        Button rockButton = new Button("Rock");
        Button scissorsButton = new Button("Scissors");

        rockButton.setOnAction(e -> viewModel.input.onNext(Move.ROCK));
        paperButton.setOnAction(e -> viewModel.input.onNext(Move.PAPER));
        scissorsButton.setOnAction(e -> viewModel.input.onNext(Move.SCISSORS));

        HBox buttonBox = new HBox(10, rockButton, paperButton, scissorsButton);
        buttonBox.setPadding(new Insets(20));

        VBox vbox = new VBox(10, buttonBox, resultText);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}