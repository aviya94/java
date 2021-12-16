package com.aviya.draughts.soldier;

import com.aviya.draughts.DraughtsBoard;
import com.aviya.draughts.Move;
import com.aviya.draughts.SquareGame;

public class KingRules extends Rules {
    @Override
    public String toString() {
        return "K";
    }

    @Override
    public Boolean move(Move move, DraughtsBoard draughtsBoard) {
        if (basicRule(move, draughtsBoard) == false) {
            return false;
        }
        SquareGame from = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());
        SquareGame to = draughtsBoard.getIndexBoard(move.colFrom(), move.colTo());

        return true;
    }
}
