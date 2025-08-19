package org.example;

import hexlet.code.router.Router;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class AppTest {
    @Test public void appHasAGreeting() {
        Router classUnderTest = new Router();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
