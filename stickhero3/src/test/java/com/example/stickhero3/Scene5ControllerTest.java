package com.example.stickhero3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class Scene5ControllerTest {
    Scene5Controller controller = new Scene5Controller();
//    @BeforeClass
//    public void setup()
//    {
//        controller.
//    }
    @Test
    public void scoreCheck() {
        assertNull(controller.getScore());
    }

    @Test
    public void eventCheck() {
        assertNull(controller.getEvent());
    }

    @Test
    public void testStage() {
        assertNull(controller.getStage());
    }
}