package com.tahtoh.devops;


import com.tahtoh.devops.app.DevopsController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DevopsControllerTest {

    @Test
    public void testController(){

        DevopsController ctrl = new DevopsController();

        String res = ctrl.hello();

        assertEquals("index", res);
    }
}
