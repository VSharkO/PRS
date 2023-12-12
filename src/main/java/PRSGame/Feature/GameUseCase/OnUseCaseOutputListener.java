package PRSGame.Feature.GameUseCase;

import PRSGame.Domain.GameResult;

@FunctionalInterface
public interface OnUseCaseOutputListener {
    void gameUseCaseOutput(GameResult result);
}
