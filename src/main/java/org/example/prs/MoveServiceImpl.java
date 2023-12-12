package org.example.prs;

import PRSGame.Domain.Move;
import PRSGame.Feature.MoveService.MoveService;
import PRSGame.Feature.MoveService.OnMoveReceived;
import java.util.Random;

public class MoveServiceImpl implements MoveService {
    OnMoveReceived onMoveReceived = null;
    @Override
    public void getMove() {
        onMoveReceived.onMoveReceived(generateComputerMove());
    }

    @Override
    public void setOnMoveReceivedListener(OnMoveReceived onMoveReceivedListener) {
        onMoveReceived = onMoveReceivedListener;
    }

    private Move generateComputerMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int randomIndex = random.nextInt(moves.length);
        return moves[randomIndex];
    }
}


