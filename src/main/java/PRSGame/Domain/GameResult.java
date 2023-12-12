package PRSGame.Domain;

public class GameResult {
    Result result;
    Move computerMove;

    public GameResult(Result result, Move computerMove) {
        this.result = result;
        this.computerMove = computerMove;
    }

    public Result getResult() {
        return result;
    }

    public Move getComputerMove() {
        return computerMove;
    }
}
