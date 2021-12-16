package com.aviya.draughts;

public class Referee {
    private Player firstPlayer;
    private Player secondPlayer;

    public Referee(Player firstPlayer,Player secondPlayer) {
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
    }

    public boolean isGameOver() {
        return firstPlayer.getSoldiersCount() == 0 || secondPlayer.getSoldiersCount() == 0;
    }
}
