package UI.ViewController;

import UI.ViewModel.GameViewModel;
import UI.ViewModel.GameViewModelInput;
import io.reactivex.disposables.CompositeDisposable;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameViewController {
    private final CompositeDisposable compositeDisposable;
    GameViewModel viewModel;
    GameView view;
    public GameViewController(GameViewModel viewModel,
                              GameView view,
                              CompositeDisposable compositeDisposable) {
        this.viewModel = viewModel;
        this.view = view;
        this.compositeDisposable = compositeDisposable;
        bindViewModel();
    }

    public void showViewOn(Stage stage){
        Scene scene = new Scene(view.getView(), 300, 200);
        stage.setTitle("Paper-Rock-Scissors Game");
        stage.setScene(scene);
        stage.show();
        viewModel.getInput().onNext(GameViewModelInput.VIEW_APPEARED);
    }

    void bindViewModel(){
        compositeDisposable.add(
                viewModel.getOutput().subscribe(gameUiModel -> {
                    view.configureView(gameUiModel);
                })
        );

        compositeDisposable.add(
                viewModel.bind()
        );

        this.view.setOnButtonClickListener(id -> {
            switch (id){
                case "paper" -> viewModel.getInput().onNext(GameViewModelInput.PAPER_BUTTON_CLICKED);
                case "rock" -> viewModel.getInput().onNext(GameViewModelInput.ROCK_BUTTON_CLICKED);
                case "scissors" -> viewModel.getInput().onNext(GameViewModelInput.SCISSORS_BUTTON_CLICKED);
                }
        });
    }


}
