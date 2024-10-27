package com.robot;

import com.robot.exceptions.RobotGameException;
import com.robot.reader.FileReader;
import com.robot.simulation.Robot;
import com.robot.simulation.Simulator;
import com.robot.simulation.Table;

import java.util.List;

public class Main {
    public static void main(String[] args) throws RobotGameException {
        if (args == null || args.length != 1) {
            throw new RobotGameException("Please provide one and one only arguments");
        }

        String filePath = args[0];
        FileReader fileReader = FileReader.getInstance();
        List<String> commands = fileReader.readCommands(filePath);

        Robot robot = new Robot();
        Table table = new Table(5, 5);
        Simulator simulator = new Simulator(robot, table);


        for (String command : commands) {
            simulator.executeCommand(command);
        }
    }
}