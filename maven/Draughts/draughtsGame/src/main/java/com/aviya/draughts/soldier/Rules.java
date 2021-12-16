package com.aviya.draughts.soldier;

import com.aviya.draughts.DraughtsBoard;
import com.aviya.draughts.Move;
import com.aviya.draughts.SquareGame;

public abstract class Rules {
    public abstract Boolean move(Move move, DraughtsBoard draughtsBoard);

    public Boolean basicRule(Move move, DraughtsBoard draughtsBoard) {
        SquareGame to;
        try {
            to = draughtsBoard.getIndexBoard(move.rowTo(), move.colTo());
            draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());

        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        if (to.soldier() == null) {
            return true;
        }
        return false;
    }
}
