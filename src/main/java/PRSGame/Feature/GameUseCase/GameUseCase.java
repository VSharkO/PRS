package PRSGame.Feature.GameUseCase;

import PRSGame.Domain.Move;

public interface GameUseCase{
    void playMove(Move playerMove);
    void setGameUseCaseOutputListener(OnUseCaseOutputListener outputListener);
}

