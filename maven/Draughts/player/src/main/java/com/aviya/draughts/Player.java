package com.aviya.draughts;

public interface Player {
    Color getPlayerColor();

    Move playYourTurn();

    int getSoldiersCount();

     void decreaseSoldiersCount();
}
