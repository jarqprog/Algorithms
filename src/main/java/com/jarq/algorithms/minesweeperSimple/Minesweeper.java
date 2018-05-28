package com.jarq.algorithms.minesweeperSimple;


import java.util.*;

/**
 * it's simple class that contains methods to:
 *  - create proper array filled with empty fields ('.') and mines ('*'),
 *      eg.:
 *
 *           . * .
 *           . * .
 *            . . .
 *
 *  - replace empty fields with number of nearby mines,
 *      eg.:
 *
 *           2 * 2
 *           2 * 2
 *           1 1 1
 *
 *  - draw board.
 */

public class Minesweeper implements IMinesweeper {

    private final char[][] board;
    private final int size;
    private final char MINE = '*';
    private final char EMPTY = '.';

    public Minesweeper(int size) {
        if(size < 3) {
            throw new IllegalArgumentException("size should be greater than 3!");
        }
        this.size = size;
        this.board = new char[size][size];
        fillBoard(generateFieldsAsList());
    }

    @Override
    public void draw() {
        System.out.println();
        for(char[] array : board) {
            for(char symbol : array) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean fillWithNumbers() {
        if(hasNumbers()) {  // fillWithNumbers() should be called only once
            throw new RuntimeException("board is already filled with numbers!");
        }

        int rowIndex = 0;
        int columnIndex;
        int calculatedSuccessfully = 0;  // helper variable to validate if method works properly

        for(char[] row : board) {
            columnIndex = 0;
            for(char field : row) {
                if(field == EMPTY) {
                    row[columnIndex] = '0';
                }

                else if(field == MINE) {
                    // incrementField method handles logic
                    calculatedSuccessfully += incrementField(rowIndex-1, columnIndex);
                    calculatedSuccessfully += incrementField(rowIndex-1, columnIndex-1);
                    calculatedSuccessfully += incrementField(rowIndex-1, columnIndex+1);

                    calculatedSuccessfully += incrementField(rowIndex, columnIndex-1);
                    calculatedSuccessfully += incrementField(rowIndex, columnIndex+1);

                    calculatedSuccessfully += incrementField(rowIndex+1, columnIndex);
                    calculatedSuccessfully += incrementField(rowIndex+1, columnIndex-1);
                    calculatedSuccessfully += incrementField(rowIndex+1, columnIndex+1);
                }
                columnIndex++;
            }
            rowIndex++;
        }
        return calculatedSuccessfully > getNumberOfMines()*3 - 4;  // condition to reconsider (validation isn't precise)
        // every mine should at least increment 3 fields unless it is in one of the four corners of the board
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(char[] array : board) {
            sb.append(Arrays.toString(array));
            sb.append("\n");
        }
        return sb.toString();
    }

    private void fillBoard(List<Character> fieldsAsList) {
        int listIndex = 0;
        for(char[] row : board) {
            for(int i=0; i<row.length; i++) {
                Character symbol = fieldsAsList.get(listIndex);
                row[i] = symbol;
                listIndex++;
            }
        }
    }

    private List<Character> generateFieldsAsList() {
        // generate list with fixed number of mines (don't want to rely on totally random mechanic
        // shuffle this plain board
        int listSize = size * size;

        List<Character> boardAsList = new ArrayList<>(listSize);

        int numberOfMines = getNumberOfMines();
        for(int i=0; i< listSize; i++) {  // fill list with mines & empty fields
            if(i < numberOfMines) {
                boardAsList.add(MINE);
            } else {
                boardAsList.add(EMPTY);
            }
        }
        Collections.shuffle(boardAsList);
        return boardAsList;
    }

    private int getNumberOfMines() {
        int minesFactor = 4;
        return size * size / minesFactor;
    }

    private int incrementField(int rowIndex, int columnIndex) {

        // border cases - would cause index out of bound exception
        if(rowIndex < 0 || rowIndex >= size || columnIndex < 0 || columnIndex >= size) {
            return 0;
        }

        char field = board[rowIndex][columnIndex];
        if(field != MINE) {
            if(field == EMPTY) {
                board[rowIndex][columnIndex] = '0';
            }
            board[rowIndex][columnIndex]++;
        }
        return 1;
    }

    private boolean hasNumbers() {
        for(char[] row : board) {
            for(char field : row) {
                if(field != EMPTY && field != MINE) {
                    return true;
                }
            }
        }
        return false;
    }
}

