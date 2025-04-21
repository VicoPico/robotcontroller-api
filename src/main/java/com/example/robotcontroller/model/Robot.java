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
      case "N":
        if (y > 0) y--;
        break;
      case "E":
        if (x < room.getWidth() - 1) x++;
        break;
      case "S":
        if (y < room.getHeight() - 1) y++;
        break;
      case "W":
        if (x > 0) x--;
        break;
    }
  }

  // Logic to turn the robot left
  public void turnLeft() {
    switch (direction) {
      case "N":
        direction = "W";
        break;
      case "E":
        direction = "N";
        break;
      case "S":
        direction = "E";
        break;
      case "W":
        direction = "S";
        break;
    }
  }

  // Logic to turn the robot right
  public void turnRight() {
    switch (direction) {
      case "N":
        direction = "E";
        break;
      case "E":
        direction = "S";
        break;
      case "S":
        direction = "W";
        break;
      case "W":
        direction = "N";
        break;
    }
  }
}
