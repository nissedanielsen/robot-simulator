package com.robot.reader;


import com.robot.exceptions.RobotGameException;

import java.util.List;

public interface IFileReader {
    List<String> readCommands(String filePath) throws RobotGameException;
}