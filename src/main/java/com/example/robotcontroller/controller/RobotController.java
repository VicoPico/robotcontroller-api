package com.example.robotcontroller.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.robotcontroller.model.CommandRequest;
import com.example.robotcontroller.model.Robot;
import com.example.robotcontroller.model.Room;
import com.example.robotcontroller.service.CommandProcessor;
import com.example.robotcontroller.service.GridRenderer;

@RestController
@RequestMapping("/api")
public class RobotController {

  private final CommandProcessor commandProcessor;
  private final GridRenderer gridRenderer;

  private Room room; // Declare room
  private Robot robot; // Declare robot

  public RobotController(
    CommandProcessor commandProcessor,
    GridRenderer gridRenderer
  ) {
    this.commandProcessor = commandProcessor;
    this.gridRenderer = gridRenderer;
  }

  @PostMapping("/initialize")
  public ResponseEntity<String> initializeRoom(@RequestBody Room room) {
    this.room = room; // Initialize room
    return ResponseEntity.ok(
      "Room initialized with dimensions: " +
      room.getWidth() +
      "x" +
      room.getHeight()
    );
  }

  @PostMapping("/robot/start")
  public ResponseEntity<String> setRobotPosition(@RequestBody Robot robot) {
    this.robot = robot; // Initialize robot
    return ResponseEntity.ok(
      "Robot initialized at position: (" +
      robot.getX() +
      ", " +
      robot.getY() +
      ") facing " +
      robot.getDirection()
    );
  }

  @PostMapping("/robot/commands")
  public ResponseEntity<String> processCommands(
    @RequestBody CommandRequest request
  ) {
    try {
      String result = commandProcessor.processCommands(
        room,
        robot,
        request.getCommands()
      );
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/grid")
  public ResponseEntity<String> getGridState() {
    // Pass room and robot to renderGrid
    String grid = gridRenderer.renderGrid(room, robot);
    return ResponseEntity.ok(grid);
  }
}
