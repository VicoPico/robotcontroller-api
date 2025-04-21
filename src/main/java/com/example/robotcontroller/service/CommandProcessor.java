package com.example.robotcontroller.service;

import org.springframework.stereotype.Service;

import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;

@Service
public class CommandProcessor {

  public String processCommands(Room room, Robot robot, String commands) {
    for (char command : commands.toUpperCase().toCharArray()) {
      switch (command) {
        case 'L':
          robot.turnLeft();
          break;
        case 'R':
          robot.turnRight();
          break;
        case 'F':
          robot.moveForward(room);
          break;
        default:
          throw new IllegalArgumentException("Invalid command: " + command);
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
