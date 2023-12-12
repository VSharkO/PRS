package org.example.prs.MoveRepository;

import PRSGame.Domain.Move;

import java.util.ArrayList;
import java.util.List;

public class CompositMoveRepository implements MoveRepository {
    private final List<MoveRepository> repositories = new ArrayList<>();

    public void addRepository(MoveRepository repository) {
        repositories.add(repository);
    }

    @Override
    public void saveMove(Move move) {
        // Save the move in each repository
        for (MoveRepository repository : repositories) {
            repository.saveMove(move);
        }
    }
}


