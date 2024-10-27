package com.robot.reader;

import com.robot.exceptions.RobotGameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {
    private IFileReader fileReader;
    private Path testFile;

    @BeforeEach
    public void setUp() throws IOException {
        fileReader = FileReader.getInstance();
        testFile = Paths.get("src/test/resources/commandsTest.txt");
    }

    @Test
    public void testReadCommands() throws IOException, RobotGameException {
        List<String> expectedCommands = new ArrayList<>(Arrays.asList("PLACE,1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT"));
        List<String> commands = fileReader.readCommands(testFile.toString());

        assertEquals(expectedCommands, commands);
    }

    @Test
    public void testReadCommandsShouldAssertFalseWhenOutIsFalse() throws IOException, RobotGameException {
        List<String> notExpectedCommands = new ArrayList<>(Arrays.asList("PLACE,1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT", "REPORT"));
        List<String> commands = fileReader.readCommands(testFile.toString());

        assertNotEquals(notExpectedCommands, commands);
    }

    @Test
    public void testReadCommandsEmptyFile() throws IOException, RobotGameException {
        Path tempFile = Files.createTempFile("commandsTestEmpty", ".txt");
        Files.write(tempFile, new ArrayList<>());

        List<String> commands = fileReader.readCommands(tempFile.toString());

        assertTrue(commands.isEmpty());

        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testInvalidFilePathNull() {
        assertThrows(RobotGameException.class, () -> fileReader.readCommands(null),
                "File path cannot be null or empty");
    }

    @Test
    public void testInvalidFilePathEmpty() {
        assertThrows(RobotGameException.class, () -> fileReader.readCommands(""),
                "File path cannot be null or empty");
    }

    @Test
    public void testFileNotFound() {
        String nonExistentFile = "src/test/resources/nonExistentFile.txt";
        RobotGameException exception = assertThrows(RobotGameException.class, () -> fileReader.readCommands(nonExistentFile));
    }

    @Test
    public void testInvalidFileType() throws IOException {
        Path nonTxtFile = Files.createTempFile("commandsTest", ".json");
        try {
            assertThrows(RobotGameException.class, () -> fileReader.readCommands(nonTxtFile.toString()));
        } finally {
            Files.deleteIfExists(nonTxtFile);
        }
    }
}