package com.robot.simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableTest {

    private Table table;

    @BeforeEach
    public void setUp() {
        table = new Table(5, 5);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1", "0, 1", "0, 2", "0, 3", "0, 4",
            "0, 0", "1, 0", "2, 0", "3, 0", "4, 0"
    })
    public void testIsValidPosition_ValidPositions(int x, int y) {
        assertTrue(table.isValidPosition(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0", "0, -1", "5, 5", "6, 3", "3, 6", "-1, -1", "5, 0", "0, 5"
    })
    public void testIsValidPosition_InvalidPositions(int x, int y) {
        assertFalse(table.isValidPosition(x, y), "Failed at position: (" + x + ", " + y + ")");
    }
}