package com.example.robotcontroller.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;
import org.junit.jupiter.api.Test;

public class CommandProcessorTest {

  private final CommandProcessor commandProcessor = new CommandProcessor();

  @Test
  public void testProcessCommands() {
    Room room = new Room(5, 5);
    Robot robot = new Robot(2, 2, "N");

    String result = commandProcessor.processCommands(room, robot, "LFFR");
    assertEquals(
      "Commands processed successfully. Robot is now at (0, 2) facing N",
      result
    );
  }

  @Test
  public void testInvalidCommand() {
    Room room = new Room(5, 5);
    Robot robot = new Robot(2, 2, "N");

    assertThrows(
      IllegalArgumentException.class,
      () -> commandProcessor.processCommands(room, robot, "X")
    );
  }
}
