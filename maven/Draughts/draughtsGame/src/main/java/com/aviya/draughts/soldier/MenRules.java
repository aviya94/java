package com.aviya.draughts.soldier;

import com.aviya.draughts.Color;
import com.aviya.draughts.DraughtsBoard;
import com.aviya.draughts.Move;
import com.aviya.draughts.SquareDraughtsGame;

public class MenRules extends Rules {

    @Override
    public Boolean move(Move move, DraughtsBoard draughtsBoard) {
        if (basicRule(move, draughtsBoard) == false) {
            return false;
        }
        SquareDraughtsGame from = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());
        SquareDraughtsGame to = draughtsBoard.getIndexBoard(move.colFrom(), move.colTo());

        if (isLegalMove(move, from) || isLegalEatMove(move, draughtsBoard, from)) {

            if (move.rowTo() == 8) {
                from.setSoldier(new KingRules());
            }
            updateMove(from, to);
            return true;
        }
        return false;
    }

    private void updateMove(SquareDraughtsGame from, SquareDraughtsGame to) {
        to.setPlayer(from.player());
        to.setSoldier(from.soldier());
        from.setPlayer(null);
        from.setSoldier(null);
    }

    private boolean isLegalMove(Move move, SquareDraughtsGame from) {
        int step = getStep(from, 1);

        if ((move.rowFrom() + step == move.rowTo())) {
            if ((move.colFrom() == move.colTo() - 1 || move.colFrom() == move.colTo() + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLegalEatMove(Move move, DraughtsBoard draughtsBoard, SquareDraughtsGame from) {
        int step = getStep(from, 2);
        if (move.rowFrom() + step == move.rowTo()) {

            if (move.colFrom() == move.colTo() - 2) {
                SquareDraughtsGame toEat = draughtsBoard.getIndexBoard(move.rowFrom() + step / 2, move.colFrom() - 1);
                return isNotSamePlayer(move, toEat, from);

            } else if (move.colFrom() == move.colTo() + 2) ;
            {
                SquareDraughtsGame toEat = draughtsBoard.getIndexBoard(move.rowFrom() + 1, move.colFrom() + 1);
                return isNotSamePlayer(move, toEat, from);
            }
        }
        return false;
    }

    private int getStep(SquareDraughtsGame from, int stepNumber) {
        if (from.player().compareTo(Color.WHITE) == 0) {
            return stepNumber * (-1);
        }
        return stepNumber;
    }

    private boolean isNotSamePlayer(Move move, SquareDraughtsGame toEat, SquareDraughtsGame from) {

        if (toEat.player() == from.player()) {
            return false;
        } else {
            toEat.setPlayer(null);
            toEat.setSoldier(null);
            return true;
        }
    }

    @Override
    public String toString() {
        return "M";
    }

}
