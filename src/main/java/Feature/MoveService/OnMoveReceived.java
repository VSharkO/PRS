package Feature.MoveService;

import Domain.Move;

@FunctionalInterface
public interface OnMoveReceived {
    void onMoveReceived(Move move);
}
