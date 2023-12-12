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
        // Call the original getMove method on the decoratee
        decoratee.getMove();
    }

    @Override
    public void setOnMoveReceivedListener(OnMoveReceived onMoveReceivedListener) {
        // Set the listener on the decoratee
        decoratee.setOnMoveReceivedListener(move -> {
            // Save the move using the composite repository
            moveRepository.saveMove(move);

            // Trigger the listener provided by the decorator
            onMoveReceivedListener.onMoveReceived(move);
        });
    }
}


