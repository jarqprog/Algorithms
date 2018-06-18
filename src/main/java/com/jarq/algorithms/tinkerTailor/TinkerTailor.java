package com.jarq.algorithms.tinkerTailor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TinkerTailor {

    public int[] execute(int numberOfPlayers, int gameCounter) {

        if (numberOfPlayers < 2 || gameCounter < 2) {
            throw new IllegalArgumentException("Invalid arguments!");
        }

        Set<Integer> usedPlayers = new HashSet<>(numberOfPlayers);  // to remember already used players
        int[] countedPlayers = new int[numberOfPlayers];  // output (last element is winner)

        int counter = 1;
        int currentIndex = 0;

        while (usedPlayers.size() < numberOfPlayers) {

            for (int playerNo=1; playerNo<=numberOfPlayers; playerNo++) {
                if (! usedPlayers.contains(playerNo) ) {
                    if (counter == gameCounter) {
                        counter = 1;
                        usedPlayers.add(playerNo);
                        countedPlayers[currentIndex] = playerNo;
                        currentIndex++;
                        continue;
                    }
                    counter++;
                }
            }
        }
        return countedPlayers;
    }
}
