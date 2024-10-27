package com.robot.simulation;

public class Table {
    private final int width;
    private final int height;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}