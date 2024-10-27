package com.robot.reader;


import com.robot.exceptions.RobotGameException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements IFileReader {

    private static FileReader instance;

    private FileReader() {
        // singleton
    }

    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    public List<String> readCommands(String filePath) throws RobotGameException {
        isValidFile(filePath);

        List<String> commands = new ArrayList<>();
        try (BufferedReader br = createBufferedReader(filePath)) {
            readLines(br, commands);
        } catch (IOException e) {
            throw new RobotGameException("Error reading from file");
        }
        return commands;
    }

    private void isValidFile(String filePath) throws RobotGameException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new RobotGameException("File path cannot be null or empty");
        }

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new RobotGameException("File not found");
        }

        if (!filePath.endsWith(".txt")) {
            throw new RobotGameException("File is not .txt file");
        }
    }

    private BufferedReader createBufferedReader(String filePath) throws IOException {
        return new BufferedReader(new java.io.FileReader(filePath));
    }

    private void readLines(BufferedReader br, List<String> commands) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            commands.add(line);
        }
    }
}