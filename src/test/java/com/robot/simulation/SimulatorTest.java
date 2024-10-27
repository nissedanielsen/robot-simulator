package com.robot.simulation;

import com.robot.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulatorTest {
    private Simulator simulator;
    private Robot robot;
    private Table table;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
        table = new Table(5, 5);
        simulator = new Simulator(robot, table);
    }

    @Test
    public void testPlaceCommand() {
        simulator.executeCommand("PLACE,1,1,NORTH");
        assertTrue(robot.isPlaced());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testMoveCommand() {
        simulator.executeCommand("PLACE,1,1,NORTH");
        simulator.executeCommand("MOVE");
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testLeftCommand() {
        simulator.executeCommand("PLACE,1,1,NORTH");
        simulator.executeCommand("LEFT");
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void testRightCommand() {
        simulator.executeCommand("PLACE,1,1,NORTH");
        simulator.executeCommand("RIGHT");
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testReportCommand() {
        simulator.executeCommand("PLACE,1,1,NORTH");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("REPORT");
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals("1,2,NORTH", robot.report());
    }

    @Test
    public void testInvalidPlaceCommand() {
        simulator.executeCommand("PLACE,5,5,NORTH");
        assertFalse(robot.isPlaced());
    }

}