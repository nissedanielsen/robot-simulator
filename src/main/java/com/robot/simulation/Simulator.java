package com.robot.simulation;

import com.robot.enums.Command;
import com.robot.enums.Direction;

public class Simulator {
    private final Robot robot;
    private final Table table;

    public Simulator(Robot robot, Table table) {
        this.robot = robot;
        this.table = table;
    }

    public void executeCommand(String commandLine) {
        String[] parts = commandLine.split(",");
        Command command = Command.valueOf(parts[0]);

        switch (command) {
            case PLACE:
                if (!robot.isPlaced()) {
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    Direction direction = Direction.from(parts[3]);
                    if (table.isValidPosition(x, y) && direction != null) {
                        robot.place(x, y, direction);
                    }
                }
                break;
            case MOVE:
                robot.move(table);
                break;
            case LEFT:
                robot.left();
                break;
            case RIGHT:
                robot.right();
                break;
            case REPORT:
                System.out.println(robot.report());
                break;
        }
    }
}