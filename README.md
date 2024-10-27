# Robot Simulator

## Description

The application is a simulation of a toy robot moving on a square tabletop with dimensions of 5 units x 5 units. The robot is free to roam around the surface of the table but must be prevented from falling off the edges. Any movement that would cause the robot to fall must be ignored, but valid movement commands should still be processed.

## Prerequisites

- Java 8 or higher
- Maven

## Run application

### Build the JAR
- mvn clean package

###  Run the JAR
- java -jar target/robot-game-1.0.0-SNAPSHOT.jar src/main/resources/test.txt

Replace txt-file with other input file if wanted

## Assignment

Create an application that can read commands of the following form:

- **PLACE,X,Y,F**: Place the robot on the table at position (X, Y) facing NORTH, SOUTH, EAST, or WEST.
- **MOVE**: Move the robot one unit forward in the direction it is currently facing.
- **LEFT**: Rotate the robot 90 degrees to the left.
- **RIGHT**: Rotate the robot 90 degrees to the right.
- **REPORT**: Announce the robot's position (X, Y) and facing direction (F). This can be displayed via standard output.

### Notes:
- The origin (0,0) is the SOUTH WEST corner of the table.
- The first valid command must be a PLACE command. After that, any sequence of commands may be issued, including another PLACE command. The robot should ignore all commands (MOVE, LEFT, RIGHT, and REPORT) until a valid PLACE command has been executed.
- Input should be provided in the form of a text file.
- Include test data to exercise the application.
- The solution should be sufficiently unit tested.
- A graphical output showing the robot's movement is not required.

## Constraints

- The toy robot must not fall off the table during movement, including the initial placement. Any move that would cause the robot to fall must be ignored.

## Deliverables

- Source files, without any dependencies except for test dependencies.
- Test data and any test code.

## Examples

a)  
PLACE,0,0,NORTH  
MOVE  
REPORT  
Output: 0,1,NORTH

b)  
PLACE,0,0,NORTH  
LEFT  
REPORT  
Output: 0,0,WEST

c)  
PLACE,1,2,EAST  
MOVE  
MOVE  
LEFT  
MOVE  
REPORT  
Output: 3,3,NORTH  