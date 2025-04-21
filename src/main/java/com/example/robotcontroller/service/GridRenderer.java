package com.example.robotcontroller.service;

import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;
import org.springframework.stereotype.Service;

@Service
public class GridRenderer {

  public String renderGrid(Room room, Robot robot) {
    StringBuilder grid = new StringBuilder();
    for (int y = 0; y < room.getHeight(); y++) {
      for (int x = 0; x < room.getWidth(); x++) {
        if (x == robot.getX() && y == robot.getY()) {
          grid.append("[").append(robot.getDirection()).append("] ");
        } else {
          grid.append("[ ] ");
        }
      }
      grid.append("\n");
    }
    return grid.toString();
  }
}
