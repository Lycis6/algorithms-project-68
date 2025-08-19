package org.example;

import hexlet.code.router.Router;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;


public class AppTest {
    private final  List<Map<String, Object>> routes = List.of(
            Map.of("path", "/courses",
                    "handler", Map.of("body", "courses")),
            Map.of("path", "/courses/basics",
                    "handler", Map.of("body", "basics"))
    );


    @Test public void routerFindPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses");
        assertEquals("courses", handler.get("body"));
    }

    @Test public void routerFindPathTest2() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses/basics");
        assertEquals("basics", handler.get("body"));
    }

    @Test public void routerNotFindPathTest() {
        try {
            Map<String, String> handler = Router.serve(routes, "/courses/notfound");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }


}
