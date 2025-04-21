package com.example.robotcontroller.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;
import org.junit.jupiter.api.Test;

public class GridRendererTest {

  private final GridRenderer gridRenderer = new GridRenderer();

  @Test
  public void testRenderGrid() {
    Room room = new Room(5, 5);
    Robot robot = new Robot(2, 2, "N");

    String grid = gridRenderer.renderGrid(room, robot);
    assertTrue(grid.contains("[N]"));
  }
}
