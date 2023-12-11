package Feature.GameUseCase;

import Domain.Move;

public interface GameUseCase{
    void playMove(Move playerMove);
    void setGameUseCaseOutputListener(OnUseCaseOutputListener outputListener);
}

