package com.example.robotcontroller.model;

public class Room {

  private int width;
  private int height;

  public Room() {}

  public Room(int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException(
        "Room dimensions must be positive integers."
      );
    }
    this.width = width;
    this.height = height;
  }

  // Getters and setters
  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    if (width <= 0) {
      throw new IllegalArgumentException("Width must be a positive integer.");
    }
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException("Height must be a positive integer.");
    }
    this.height = height;
  }
}
