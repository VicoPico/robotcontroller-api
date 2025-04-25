package com.example.robotcontroller.service;

import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;
import org.springframework.stereotype.Service;

@Service
public class CommandProcessor {

  public String processCommands(Room room, Robot robot, String commands) {
    for (char command : commands.toUpperCase().toCharArray()) {
      switch (command) {
        case 'L' -> robot.turnLeft();
        case 'R' -> robot.turnRight();
        case 'F' -> robot.moveForward(room);
        default -> throw new IllegalArgumentException(
          "Invalid command: " + command
        );
      }
    }
    return (
      "Commands processed successfully. Robot is now at (" +
      robot.getX() +
      ", " +
      robot.getY() +
      ") facing " +
      robot.getDirection()
    );
  }
}
