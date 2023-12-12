package PRSGame.Feature.MoveService;

import PRSGame.Domain.Move;

@FunctionalInterface
public interface OnMoveReceived {
    void onMoveReceived(Move move);
}
