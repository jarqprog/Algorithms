package com.jarq.algorithms.nearbyElements;

public class NearbyIntegers implements NearbyElements<Integer> {

    private final int[][] data;

    public NearbyIntegers(int[][] data) {
        this.data = data;
    }

    @Override
    public Integer[] nearby(int rowIndex, int columnIndex, int range) {
        if(! validateArguments(rowIndex, columnIndex, range) ) {
            throw new IllegalArgumentException("Given arguments are invalid!");
        }

        return getNeighbors(rowIndex, columnIndex, range);
    }

    private boolean validateArguments(int rowIndex, int columnIndex, int range) {
        if(rowIndex < 0 || columnIndex < 0 || range <=0) {
            return false;
        }
        return rowIndex < data.length && columnIndex < data[rowIndex].length;
    }

    private Integer[] getNeighbors(int rowIndex, int columnIndex, int range) {

        int movesToTheLeft = calculateMovesToLeft(columnIndex, range);
        int movesToTheRight = calculateMovesToRight(rowIndex, columnIndex, range);
        int neighborsSize = movesToTheLeft + movesToTheRight;
        Integer[] neighbors = new Integer[neighborsSize];
        int startIndex = columnIndex - movesToTheLeft;
        int stopIndex = columnIndex + movesToTheRight;
        int neighborsIndex = 0;

        for(int i=startIndex; i<=stopIndex; i++) {
            if(i != columnIndex) {
                neighbors[neighborsIndex] = data[rowIndex][i];
                neighborsIndex++;
            }
        }
        return neighbors;
    }

    private int calculateMovesToLeft(int columnIndex, int range) {
        if(columnIndex >= range) {
            return range;
        }
        return range - (range-columnIndex);
    }

    private int calculateMovesToRight(int rowIndex, int columnIndex, int range) {
        int rowSize = data[rowIndex].length;
        int steps = columnIndex + range;
        if(steps <= rowSize) {
            return range;
        }
        int movesToRight  = range - (steps -(steps-rowSize)) -1;
        if(movesToRight < 0) {
            return 0;
        }
        return movesToRight;
    }
}

