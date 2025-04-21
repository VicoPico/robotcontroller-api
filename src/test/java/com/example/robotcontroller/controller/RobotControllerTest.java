package com.example.robotcontroller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RobotControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testInitializeRoom() throws Exception {
    mockMvc
      .perform(
        post("/api/initialize")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"width\":5,\"height\":5}")
      )
      .andExpect(status().isOk())
      .andExpect(content().string("Room initialized with dimensions: 5x5"));
  }

  @Test
  public void testSetRobotPosition() throws Exception {
    mockMvc
      .perform(
        post("/api/robot/start")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"x\":2,\"y\":2,\"direction\":\"N\"}")
      )
      .andExpect(status().isOk())
      .andExpect(
        content().string("Robot initialized at position: (2, 2) facing N")
      );
  }

  @Test
  public void testProcessCommands() throws Exception {
    mockMvc
      .perform(
        post("/api/robot/commands")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"commands\":\"LFFR\"}")
      )
      .andExpect(status().isOk())
      .andExpect(
        content()
          .string(
            "Commands processed successfully. Robot is now at (0, 2) facing N"
          )
      );
  }
}
