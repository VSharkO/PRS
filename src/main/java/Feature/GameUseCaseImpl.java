package Feature;
import Domain.*;
import Domain.GameResult;
import Feature.GameUseCase.GameUseCase;
import Feature.GameUseCase.OnUseCaseOutputListener;
import Feature.MoveService.MoveService;

public class GameUseCaseImpl implements GameUseCase {
    OnUseCaseOutputListener output;
    private MoveService moveService;
    Move playerMove = null;
    public GameUseCaseImpl(MoveService moveService) {
        this.moveService = moveService;

        moveService.setOnMoveReceivedListener(move -> {
            output.gameUseCaseOutput(getGameResult(this.playerMove, move));
        });
    }
    @Override
    public void setGameUseCaseOutputListener(OnUseCaseOutputListener outputListener) {
        this.output = outputListener;
    }
    @Override
    public void playMove(Move playerMove) {
        moveService.getMove();
        this.playerMove = playerMove;
    }
    private GameResult getGameResult(Move playerMove, Move computerMove){
        if (playerMove == computerMove) {
            return new GameResult(Result.DRAW, computerMove);
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
                (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
                (playerMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            return new GameResult(Result.WIN, computerMove);
        } else {
            return new GameResult(Result.LOSS, computerMove);
        }
    }
}

