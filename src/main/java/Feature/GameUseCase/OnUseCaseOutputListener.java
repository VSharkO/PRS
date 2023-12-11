package Feature.GameUseCase;

import Domain.GameResult;

@FunctionalInterface
public interface OnUseCaseOutputListener {
    void gameUseCaseOutput(GameResult result);
}
