package com.example.robotcontroller.model;

public class Robot {

  private int x;
  private int y;
  private String direction; // N, E, S, W

  public Robot() {}

  public Robot(int x, int y, String direction) {
    this.x = x;
    this.y = y;
    this.direction = direction.toUpperCase();
  }

  // Getters and setters
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction.toUpperCase();
  }

  // Logic to move the robot forward
  public void moveForward(Room room) {
    switch (direction) {
      case "N" -> {
        if (y > 0) y--;
      }
      case "E" -> {
        if (x < room.getWidth() - 1) x++;
      }
      case "S" -> {
        if (y < room.getHeight() - 1) y++;
      }
      case "W" -> {
        if (x > 0) x--;
      }
    }
  }

  // Logic to turn the robot left
  public void turnLeft() {
    switch (direction) {
      case "N" -> direction = "W";
      case "E" -> direction = "N";
      case "S" -> direction = "E";
      case "W" -> direction = "S";
    }
  }

  // Logic to turn the robot right
  public void turnRight() {
    switch (direction) {
      case "N" -> direction = "E";
      case "E" -> direction = "S";
      case "S" -> direction = "W";
      case "W" -> direction = "N";
    }
  }
}
