package com.aviya.draughts;

import com.aviya.draughts.soldier.MenRules;

public class DraughtsBoard {
    private SquareGame[][] board = new SquareGame[8][8];

    public SquareGame getIndexBoard(int row, int col) {
        return board[row][col];
    }

    public DraughtsBoard() {
        initialize();

        System.out.println(toString());
    }

    private void initialize() {
        Color squareColor = Color.BLACK;

        for (int i = 0; i < board.length; i++) {
            squareColor = getSquareColor(squareColor);

            for (int j = 0; j < board[i].length; j++) {
                squareColor = getSquareColor(squareColor);
                FillTheBoard(squareColor, i, j);
            }
        }

    }

    private void FillTheBoard(Color squareColor, int i, int j) {
        if (squareColor == Color.BLACK) {

            if (i <= 2) {
                {
                    board[i][j] = new SquareGame(squareColor, new MenRules(), Color.BLACK);
                }

            } else if (i >= 5) {
                board[i][j] = new SquareGame(squareColor, new MenRules(), Color.WHITE);
            }

        }

        if ((i > 2 && i < 5) || squareColor == Color.WHITE) {
            board[i][j] = new SquareGame(squareColor, null, null);
        }
    }

    private Color getSquareColor(Color squareColor) {
        if (squareColor == Color.BLACK) {
            squareColor = Color.WHITE;
        } else {
            squareColor = Color.BLACK;
        }
        return squareColor;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            stringBuilder.append("\n");

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].player() == null) {
                    stringBuilder.append(board[i][j].squareColor() + "        | ");
                } else {
                    stringBuilder.append(board[i][j].squareColor() + " p-" +
                            board[i][j].player().toString().charAt(0) + " s-" + board[i][j].soldier().toString()
                            + "| ");
                }
            }
        }
        return String.valueOf(stringBuilder);
    }
}
