package UI.ViewModel;
import Domain.*;
import Domain.GameResult;
import Feature.GameUseCase.GameUseCase;
import UI.ViewController.UIModels.GameButtonUIModel;
import UI.ViewController.UIModels.GameUIModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;

public class GameViewModelImpl implements GameViewModel {
    private GameUseCase gameUseCase;
    public PublishSubject<GameViewModelInput> input;
    public PublishSubject<GameUIModel> output;
    private GameUIModel gameUIModel;

    public GameViewModelImpl(GameUseCase gameUseCase,
                             PublishSubject<GameViewModelInput> input,
                             PublishSubject<GameUIModel> output) {
        this.gameUseCase = gameUseCase;
        this.input = input;
        this.output = output;
        subscribeToUseCaseOutput();
    }
    public Disposable bind() {
        return input
                .flatMap(this::transformInputToOutput)
                .subscribe(output::onNext);
    }
    @Override
    public PublishSubject<GameViewModelInput> getInput() {
        return input;
    }
    @Override
    public PublishSubject<GameUIModel> getOutput() {
        return output;
    }
    private Observable<GameUIModel> transformInputToOutput(GameViewModelInput viewModelInput) {
        Move playerMove = null;
        switch (viewModelInput){
            case PAPER_BUTTON_CLICKED -> playerMove = Move.PAPER;
            case ROCK_BUTTON_CLICKED -> playerMove = Move.ROCK;
            case SCISSORS_BUTTON_CLICKED -> playerMove = Move.SCISSORS;
            case VIEW_APPEARED -> {
                this.gameUIModel = createModel("");
                return Observable.just(gameUIModel);
            }
        }
        this.gameUseCase.playMove(playerMove);
        return Observable.empty();
    }

    private GameUIModel mapUseCaseOutputToVMOutput(GameResult result){
        this.gameUIModel.resultString = "Computer played: " + result.getComputerMove() + "\nResult: " + result.getResult();;
        return this.gameUIModel;
    };

    private void subscribeToUseCaseOutput(){
        gameUseCase.setGameUseCaseOutputListener(useCaseOutput -> {
            output.onNext(this.mapUseCaseOutputToVMOutput(useCaseOutput));
        });
    }

    private GameUIModel createModel(String resultString){
        ArrayList<GameButtonUIModel> buttons = new ArrayList<>();
        buttons.add(new GameButtonUIModel("Paper", "paper"));
        buttons.add(new GameButtonUIModel("Rock", "rock"));
        buttons.add(new GameButtonUIModel("Scissors", "scissors"));
        return new GameUIModel(resultString, buttons);
    }
}

