package org.example.prs.MoveRepository;

import PRSGame.Domain.Move;

public class LocalMoveRepository implements MoveRepository {
    @Override
    public void saveMove(Move move) {
        // Logic to save move locally
        System.out.println("Saved locally: " + move.name());
    }
}
