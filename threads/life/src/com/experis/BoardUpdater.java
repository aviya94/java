package com.experis;

public class BoardUpdater {
    private int[][] board;
    private int[][] newBoard;

    public int[][] getBoard() {
        return board;
    }

    public BoardUpdater(int[][] board) {
        this.board = board;
        newBoard = new int[board.length][board[0].length];
    }

    public void update(int startRow, int startCol, int endRow, int endCol) {

        for (int i = startRow; i < endRow; i++) {

            for (int j = startCol; j < endCol; j++) {
                int neighborsCount = neighborCheck( i, j);
                updateBoard( i, j, neighborsCount);
            }
        }
    }

    private void updateBoard( int row, int col, int neighborsCount) {

        if (neighborsCount == 3 && board[row][col] == 0) {
            newBoard[row][col] = 1;

        } else if ((neighborsCount == 2 || neighborsCount == 3) && board[row][col] == 1) {
            newBoard[row][col] = 1;
        }
        else{
            newBoard[row][col] = 0;
        }
    }

    private int neighborCheck( int row, int col) {
        int count = 0;

        count = cellCheck( row, col - 1, count);
        count = cellCheck( row - 1, col, count);
        count = cellCheck( row - 1, col - 1, count);
        count = cellCheck( row + 1, col, count);
        count = cellCheck( row, col + 1, count);
        count = cellCheck( row + 1, col + 1, count);
        count = cellCheck( row - 1, col + 1, count);
        count = cellCheck( row + 1, col - 1, count);

        return count;
    }

    private int cellCheck( int row, int col, int count) {

        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {

            if (board[row][col] == 1) {
                count++;
            }
        }
        return count;
    }

    public void updateBoard(){
        board=newBoard;
        newBoard = new int[board.length][board[0].length];
    }

}
