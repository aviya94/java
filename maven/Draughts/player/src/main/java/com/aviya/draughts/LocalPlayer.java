package com.aviya.draughts;

import java.util.Scanner;

public class LocalPlayer implements Player {
    private Color playerColor;
    private Scanner scanner = new Scanner(System.in);
    private int soldiersCount = 12;

    public LocalPlayer(Color playerColor) {
        this.playerColor = playerColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    @Override
    public void decreaseSoldiersCount() {
        --soldiersCount;
    }

    @Override
    public int getSoldiersCount() {
        return soldiersCount;
    }

    @Override
    public Move playYourTurn() {
        int rowFrom = scanner.nextInt();
        int colFrom = scanner.nextInt();
        int rowTo = scanner.nextInt();
        int colTo = scanner.nextInt();
        return new Move(rowFrom, colFrom, rowTo, colTo, this);
    }

    @Override
    public String toString() {
        String str = "P-" + playerColor;
        return String.valueOf(str.charAt(0));
    }
}
