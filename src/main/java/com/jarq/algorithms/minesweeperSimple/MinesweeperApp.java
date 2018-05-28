package com.jarq.algorithms.minesweeperSimple;

public class MinesweeperApp {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(30);
        minesweeper.draw();
        minesweeper.fillWithNumbers();
        minesweeper.draw();
    }
}
