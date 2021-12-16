package com.aviya.draughts.soldier;

import com.aviya.draughts.Color;
import com.aviya.draughts.DraughtsBoard;
import com.aviya.draughts.Move;
import com.aviya.draughts.SquareGame;

public class MenRules extends Rules {

    @Override
    public Boolean move(Move move, DraughtsBoard draughtsBoard) {
        if (basicRule(move, draughtsBoard) == false) {
            return false;
        }
        SquareGame from = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());
        SquareGame to = draughtsBoard.getIndexBoard(move.colFrom(), move.colTo());

        if (isLegalMove(move, from) || isLegalEatMove(move, draughtsBoard, from)) {
            updateKing(from, to,move);
            updateMove(from, to);
            return true;
        }
        return false;
    }

    private void updateKing(SquareGame from, SquareGame to,Move move) {
        if(from.player()==Color.BLACK) {
            updateKingIfSoldierInOtherSide(from, move,8);
        }
        else {
            updateKingIfSoldierInOtherSide(from, move,0);
        }
    }

    private void updateKingIfSoldierInOtherSide(SquareGame from, Move move,int otherSize) {
        if (move.rowTo() == otherSize) {
            from.setSoldier(new KingRules());
        }
    }

    private void updateMove(SquareGame from, SquareGame to) {
        to.setPlayer(from.player());
        to.setSoldier(from.soldier());
        from.setPlayer(null);
        from.setSoldier(null);
    }

    private boolean isLegalMove(Move move, SquareGame from) {
        int step = getStep(from, 1);

        if ((move.rowFrom() + step == move.rowTo())) {
            if ((move.colFrom() == move.colTo() - 1 || move.colFrom() == move.colTo() + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLegalEatMove(Move move, DraughtsBoard draughtsBoard, SquareGame from) {
        int step = getStep(from, 2);
        if (move.rowFrom() + step == move.rowTo()) {

            if (move.colFrom() == move.colTo() - 2) {
                SquareGame toEat = draughtsBoard.getIndexBoard(move.rowFrom() + step / 2, move.colFrom() - 1);
                return isNotSamePlayer(move, toEat, from);

            } else if (move.colFrom() == move.colTo() + 2) ;
            {
                SquareGame toEat = draughtsBoard.getIndexBoard(move.rowFrom() + 1, move.colFrom() + 1);
                return isNotSamePlayer(move, toEat, from);
            }
        }
        return false;
    }

    private int getStep(SquareGame from, int stepNumber) {
        if (from.player().compareTo(Color.WHITE) == 0) {
            return stepNumber * (-1);
        }
        return stepNumber;
    }

    private boolean isNotSamePlayer(Move move, SquareGame toEat, SquareGame from) {

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
