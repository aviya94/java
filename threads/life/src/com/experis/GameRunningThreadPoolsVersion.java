package com.experis;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameRunningThreadPoolsVersion {
    private InitializeGame initializeGame;
    private BoardUpdater boardUpdater;
    private int[][] board;
    private ExecutorService executor;

    public int[][] getBoard() {
        return board;
    }

    public GameRunningThreadPoolsVersion(double lifeCellPercent, int generations) {

        initializeGame = new InitializeGame();
        board = initializeGame.initialization(lifeCellPercent);
        boardUpdater = new BoardUpdater(board);
        run(generations);

    }

    public GameRunningThreadPoolsVersion(int[][] board, int generations) {
        this.board = board;
        boardUpdater = new BoardUpdater(board);
        run(generations);
    }

    private void addThreads() {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executor.submit(new Thread(() -> boardUpdater.update(0, 0, board.length / 2, board[0].length / 2)));
        executor.submit(new Thread(() -> boardUpdater.update(board.length / 2, 0, board.length, board[0].length / 2)));
        executor.submit(new Thread(() -> boardUpdater.update(0, board[0].length / 2, board.length / 2, board[0].length)));
        executor.submit(new Thread(() -> boardUpdater.update(board.length / 2, board[0].length / 2, board.length, board[0].length)));
    }

    private void run(int generations) {

        for (int i = 0; i < generations; i++) {
            addThreads();
            executor.shutdown();

            try {
                executor.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boardUpdater.updateBoard();
            addThreads();
        }

        board = boardUpdater.getBoard();
    }
}
