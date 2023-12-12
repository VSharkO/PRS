package org.example.prs.Decorators;
import PRSGame.Domain.GameResult;
import PRSGame.Domain.Move;
import PRSGame.Feature.GameUseCase.GameUseCase;
import PRSGame.Feature.GameUseCase.OnUseCaseOutputListener;

public class AnalyticsGameUseCaseDecorator implements GameUseCase, OnUseCaseOutputListener {
    private final GameUseCase decoratedUseCase;
    private OnUseCaseOutputListener outputListener;

    public AnalyticsGameUseCaseDecorator(GameUseCase decoratedUseCase) {
        this.decoratedUseCase = decoratedUseCase;
    }

    @Override
    public void setGameUseCaseOutputListener(OnUseCaseOutputListener outputListener) {
        this.outputListener = outputListener;
        decoratedUseCase.setGameUseCaseOutputListener(this);
    }

    @Override
    public void playMove(Move playerMove) {
        logAnalytics("Input: Player move - " + playerMove);
        decoratedUseCase.playMove(playerMove);
    }

    @Override
    public void gameUseCaseOutput(GameResult result) {
        logAnalytics("Output: Game result - " + result.getResult().name());
        if (outputListener != null) {
            outputListener.gameUseCaseOutput(result);
        }
    }

    private void logAnalytics(String message) {
        System.out.println("Analytics: " + message);
    }
}

