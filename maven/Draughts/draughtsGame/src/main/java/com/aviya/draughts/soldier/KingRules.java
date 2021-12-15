package com.aviya.draughts.soldier;

import com.aviya.draughts.DraughtsBoard;
import com.aviya.draughts.Move;
import com.aviya.draughts.SquareDraughtsGame;

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
        SquareDraughtsGame from = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());
        SquareDraughtsGame to = draughtsBoard.getIndexBoard(move.colFrom(), move.colTo());

        return true;
    }
}
