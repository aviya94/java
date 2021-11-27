package com.experis;

import java.util.ArrayList;

public class GameRunning {
    private InitializeGame initializeGame;
    private BoardUpdater boardUpdater;
    private int[][] board;
    private ArrayList<Thread> threads = new ArrayList<>();

    public int[][] getBoard() {
        return board;
    }

    public GameRunning(double lifeCellPercent, int generations) {
        initializeGame = new InitializeGame();
        board= initializeGame.initialization(lifeCellPercent);
        boardUpdater = new BoardUpdater(board);
        run(generations);

    }

    public GameRunning(int[][] board, int generations) {
        this.board=board;
        boardUpdater = new BoardUpdater(board);
        run(generations);

    }

    private void addThreads() {
        threads.add(new Thread(() -> boardUpdater.update(0, 0, board.length / 2, board[0].length / 2)));
        threads.add(new Thread(() -> boardUpdater.update(board.length / 2, 0, board.length, board[0].length / 2)));
        threads.add(new Thread(() -> boardUpdater.update(0, board[0].length / 2, board.length / 2, board[0].length)));
        threads.add(new Thread(() -> boardUpdater.update(board.length / 2, board[0].length / 2, board.length, board[0].length)));
    }

    private void run(int generations) {

        for (int i = 0; i < generations; i++) {
            addThreads();
            runThreads();
            threads=new ArrayList<>();
            addThreads();
        }
        board=boardUpdater.getBoard();
    }

    private void runThreads() {

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boardUpdater.updateBoard();
    }
}
