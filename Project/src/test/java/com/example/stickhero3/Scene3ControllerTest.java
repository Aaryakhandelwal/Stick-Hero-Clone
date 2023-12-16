package com.example.stickhero3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Scene3ControllerTest {
    Scene3Controller controller = new Scene3Controller();
    @Test
    public void testGame()
    {
        assertNull(controller.getGame());
    }

    @Test
    public void testEvent()
    {
        assertNull(controller.getEvent());
    }
    @Test
    public void testRestart()
    {
        assertNull(controller.getRestart());
    }

    @Test
    public void testStage()
    {
        assertNull(controller.getStage());
    }

}