package org.example.prs;

import Feature.GameUseCaseImpl;
import UI.View.GameViewImpl;
import UI.ViewController.GameViewController;
import UI.ViewModel.GameViewModelImpl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    //move to factories
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private GameViewModelImpl viewModel = new GameViewModelImpl(
            new GameUseCaseImpl(new MoveServiceImpl()),
            PublishSubject.create(),
            PublishSubject.create());
    private GameViewController viewController = new GameViewController(viewModel, new GameViewImpl(), compositeDisposable);
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        viewController.showViewOn(primaryStage);
    }
}