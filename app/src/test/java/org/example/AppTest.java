package org.example;

import hexlet.code.router.Router;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;


public class AppTest {
    private final  List<Map<String, Object>> routes = List.of(
            Map.of("path", "/courses/:id",
                    "constraints", Map.of("id", "\\w+"),
                    "handler", Map.of("body", "course!")),
            Map.of("path", "/courses/:course_id/exercises/:id",
                    "constraints", Map.of("course_id", "\\w+",
                                              "id", "\\w+"),
                    "handler", Map.of("body", "exercise!")),
            Map.of("path", "/courses",
                    "handler", Map.of("body", "courses")),
            Map.of("path", "/courses/basics",
                    "handler", Map.of("body", "basics"))
    );

    @Test public void routerFindStaticPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses");
        assertEquals("courses", handler.get("body"));
    }

//    @Test public void routerFindStaticPathTest2() throws Exception {
//        Map<String, String> handler = Router.serve(routes, "/courses/basics");
//        assertEquals("basics", handler.get("body"));
//    }

    @Test public void routerNotFindStaticPathTest() {
        try {
            Map<String, String> handler = Router.serve(routes, "/courses/notfound");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerFindDynamicPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses/php_trees");
        assertEquals("course!", handler.get("body"));
    }

    @Test public void routerFindDynamicPathTest2() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses/php_trees/exercises/24");
        assertEquals("exercise!", handler.get("body"));
    }

    @Test public void routerFindDynamicPathTest3() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses/php_trees_or_Graphs");
        assertEquals("course!", handler.get("body"));
    }

    @Test public void routerFindDynamicPathTest4() throws Exception {
        Map<String, String> handler = Router.serve(routes, "/courses/php_trees_for_practicing/exercises/24_43");
        assertEquals("exercise!", handler.get("body"));
    }

    @Test public void routerNotFindDynamicPathTest1() {
        try {
            Map<String, String> handler = Router.serve(routes, "/study");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindDynamicPathTest2() {
        try {
            Map<String, String> handler = Router.serve(routes, "/study/for/best/knowledge/1");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindDynamicPathTest3() {
        try {
            Map<String, String> handler = Router.serve(routes, "/courses//exercises/24");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindDynamicPathTest4() {
        try {
            Map<String, String> handler = Router.serve(routes, "/courses/form/exercises/");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindDynamicPathTest5() {
        try {
            Map<String, String> handler = Router.serve(routes, "/courses/form/exercises//");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }




}
