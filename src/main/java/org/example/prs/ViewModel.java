package org.example.prs;
import Domain.*;
import Feature.*;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

class GameViewModel {
    private GameService gameService;
    public PublishSubject<Move> input;
    public PublishSubject<String> output;

    public GameViewModel(GameService gameService,
                         PublishSubject<Move> input,
                         PublishSubject<String> output) {
        this.gameService = gameService;
        this.input = input;
        this.output = output;
    }

    public Disposable bind() {
        return input.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .map(this::transformInputToOutput)
                .subscribe(output::onNext);
    }

    private String transformInputToOutput(Move playerMove) {
        Move computerMove = generateComputerMove();
        Result result = this.gameService.playMove(playerMove, computerMove);
        return "Computer played: " + computerMove + "\nResult: " + result;
    }

    private Move generateComputerMove() {
        Move[] moves = Move.values();
        int randomIndex = (int) (Math.random() * moves.length);
        return moves[randomIndex];
    }
}

