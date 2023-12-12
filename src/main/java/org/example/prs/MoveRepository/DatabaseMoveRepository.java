package org.example.prs.MoveRepository;

import PRSGame.Domain.Move;

public class DatabaseMoveRepository implements MoveRepository {
    @Override
    public void saveMove(Move move) {
        // Logic to save move in the database
        System.out.println("Saved in database: " + move.name());
    }
}
