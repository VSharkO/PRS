package org.example.prs;

import PRSGame.Domain.Move;
import PRSGame.Feature.MoveService.MoveService;
import PRSGame.Feature.MoveService.OnMoveReceived;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteMoveService implements MoveService {
    private OnMoveReceived onMoveReceived = null;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private MoveService fallbackMoveService;

    public RemoteMoveService(MoveService fallbackMoveService) {
        this.fallbackMoveService = fallbackMoveService;
    }

    @Override
    public void getMove() {
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                Move generatedMove = generateComputerMove();
                onMoveReceived.onMoveReceived(generatedMove);
            } catch (Exception e) {
                fallbackMoveService.setOnMoveReceivedListener(onMoveReceived);
                fallbackMoveService.getMove();
            }
        });
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

    public void shutdown() {
        executorService.shutdown();
    }
}
