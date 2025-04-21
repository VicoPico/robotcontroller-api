package com.example.robotcontroller.service;

import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;
import org.springframework.stereotype.Service;

@Service
public class GridRenderer {

  public String renderGrid(Room room, Robot robot) {
    StringBuilder grid = new StringBuilder();

    // Render from top to bottom (reverse the y-axis)
    for (int y = room.getHeight() - 1; y >= 0; y--) { // Start from the top row
      for (int x = 0; x < room.getWidth(); x++) {
        if (x == robot.getX() && y == robot.getY()) {
          grid.append("[").append(robot.getDirection()).append("] ");
        } else {
          grid.append("[ ] ");
        }
      }
      grid.append("\n"); // New line after each row
    }

    return grid.toString();
  }
}
