package com.robot.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testFrom() {
        assertEquals(Direction.NORTH, Direction.from("NORTH"));
        assertEquals(Direction.EAST, Direction.from("EAST"));
        assertEquals(Direction.SOUTH, Direction.from("SOUTH"));
        assertEquals(Direction.WEST, Direction.from("WEST"));
        assertNull(Direction.from("INVALID"));
    }

    @Test
    public void testChangeDirection() {
        assertEquals(Direction.EAST, Direction.NORTH.changeDirection(1));
        assertEquals(Direction.SOUTH, Direction.NORTH.changeDirection(2));
        assertEquals(Direction.WEST, Direction.NORTH.changeDirection(3));
        assertEquals(Direction.NORTH, Direction.NORTH.changeDirection(4));
        assertEquals(Direction.WEST, Direction.NORTH.changeDirection(-1));
    }
}