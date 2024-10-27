package com.robot.simulation;

import com.robot.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    private Robot robot;
    private Table table;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
        table = new Table(5, 5);
    }

    @Test
    public void testPlace() {
        robot.place(1, 1, Direction.NORTH);
        assertTrue(robot.isPlaced());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testMove() {
        robot.place(1, 1, Direction.NORTH);
        robot.move(table);
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
    }

    @Test
    public void testLeft() {
        robot.place(1, 1, Direction.NORTH);
        robot.left();
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void testRight() {
        robot.place(1, 1, Direction.NORTH);
        robot.right();
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testReport() {
        robot.place(1, 1, Direction.NORTH);
        assertEquals("1,1,NORTH", robot.report());
    }

    @Test
    public void testMoveInvalidPosition() {
        robot.place(0, 0, Direction.SOUTH);
        robot.move(table);
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }
}