package com.jarq.algorithms.tinkerTailor;

import org.junit.Test;

import static org.junit.Assert.*;

public class TinkerTailorTest {

    private TinkerTailor game = new TinkerTailor();

    @Test
    public void execute() {

        int[] expected = {3, 1, 5, 2, 4};
        int[] output = game.execute(5, 3);

        assertArrayEquals(expected, output);
    }
}