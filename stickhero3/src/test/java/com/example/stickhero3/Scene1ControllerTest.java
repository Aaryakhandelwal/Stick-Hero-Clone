package com.example.stickhero3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Scene1ControllerTest {
    Scene1Controller controller = new Scene1Controller();
    @Test
    public void testAvatar()
    {
        assertNull(controller.getAvatar());
    }
    @Test
    public void testPillar()
    {
        assertNull(controller.getPillar2());
    }
    @Test
    public void testPillar1()
    {
        assertNull(controller.getPillar1());
    }
}