package com.aviya.draughts;


public class DraughtsGame {
    private DraughtsBoard draughtsBoard;
    private Player[] players;
    private Referee referee;

    public DraughtsGame(DraughtsBoard draughtsBoard, Player firstPlayer, Player secondPlayer) {
        this.draughtsBoard = draughtsBoard;
        players = new Player[]{firstPlayer, secondPlayer};
        referee=new Referee(firstPlayer,secondPlayer);
    }

    public void startPlay() {
        int index = 0;
        while (referee.isGameOver() == false) {
            System.out.println(draughtsBoard.toString());
            Boolean isLegalMove = false;

            while (isLegalMove == false) {
                Move move = players[index].playYourTurn();
                var moveFromPlayer = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom()).player();

                if (moveFromPlayer.equals(players[index].getPlayerColor())) {
                    SquareDraughtsGame from = draughtsBoard.getIndexBoard(move.rowFrom(), move.colFrom());
                    isLegalMove = from.soldier().move(move, draughtsBoard);
                }
            }
            index = updateTurn(index);
        }
    }

    private int updateTurn(int index) {
        if (index == 0) {
            return 1;
        }
        return 0;
    }

}
