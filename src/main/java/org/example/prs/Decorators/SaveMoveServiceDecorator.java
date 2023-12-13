package org.example.prs.Decorators;

import PRSGame.Feature.MoveService.MoveService;
import PRSGame.Feature.MoveService.OnMoveReceived;
import org.example.prs.MoveRepository.MoveRepository;

public class SaveMoveServiceDecorator implements MoveService {
    private final MoveService decoratee;
    private final MoveRepository moveRepository;

    public SaveMoveServiceDecorator(MoveService decoratee, MoveRepository moveRepository) {
        this.decoratee = decoratee;
        this.moveRepository = moveRepository;
    }

    @Override
    public void getMove() {
        decoratee.getMove();
    }

    @Override
    public void setOnMoveReceivedListener(OnMoveReceived onMoveReceivedListener) {
        decoratee.setOnMoveReceivedListener(move -> {
            moveRepository.saveMove(move);
            onMoveReceivedListener.onMoveReceived(move);
        });
    }
}


