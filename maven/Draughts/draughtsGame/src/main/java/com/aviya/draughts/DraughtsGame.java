package com.aviya.draughts;


public class DraughtsGame {
    private DraughtsBoard draughtsBoard;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player turn;

    public DraughtsGame(DraughtsBoard draughtsBoard, Player firstPlayer, Player secondPlayer) {
        this.draughtsBoard = draughtsBoard;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        turn = firstPlayer;
    }

    public void startPlay() {
        while (isGameOver() == false) {
            System.out.println(draughtsBoard.toString());
            Boolean isLegalMove = false;

            while (isLegalMove == false) {
                Move move = turn.playYourTurn();
                var moveFromPlayer = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom()).player();

                if (moveFromPlayer.equals(turn.getPlayerColor())) {
                    SquareDraughtsGame from = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());
                    isLegalMove = from.soldier().move(move, draughtsBoard);
                }
            }
            turn = updateTurn();
        }
    }

    private Player updateTurn() {
        if (turn == firstPlayer) {
            return secondPlayer;
        } else {
            return firstPlayer;
        }
    }

    private boolean isGameOver() {
        return firstPlayer.getSoldiersCount() == 0 || secondPlayer.getSoldiersCount() == 0;
    }
}
