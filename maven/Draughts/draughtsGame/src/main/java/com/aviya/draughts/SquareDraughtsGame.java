package com.aviya.draughts;

import com.aviya.draughts.soldier.Rules;

public final class SquareDraughtsGame {
    private final Color squareColor;
    private Rules soldier;

    public void setSoldier(Rules soldier) {
        this.soldier = soldier;
    }

    public void setPlayer(Color player) {
        this.player = player;
    }

    private Color player;

    public SquareDraughtsGame(Color squareColor, Rules soldier, Color player) {
        this.squareColor = squareColor;
        this.soldier = soldier;
        this.player = player;
    }

    public Color squareColor() {
        return squareColor;
    }

    public Rules soldier() {
        return soldier;
    }

    public Color player() {
        return player;
    }

}
