package com.robot.simulation;

import com.robot.enums.Direction;

public class Robot {
    private int x;
    private int y;
    private Direction direction;
    private boolean isPlaced;

    public Robot() {
        this.isPlaced = false;
    }

    public void place(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isPlaced = true;
    }

    public void move(Table table) {
        if (!isPlaced) return;
        int newX = x, newY = y;
        switch (direction) {
            case NORTH:
                newY++;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
        }
        if (table.isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void left() {
        if (!isPlaced) return;
        direction = direction.changeDirection(-1);
    }

    public void right() {
        if (!isPlaced) return;
        direction = direction.changeDirection(1);
    }

    public String report() {
        if (!isPlaced) return "Robot not placed on the table.";
        return x + "," + y + "," + direction.getDescription();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}