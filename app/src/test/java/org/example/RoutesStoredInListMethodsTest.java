/*
package org.example;

import hexlet.code.router.Router;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class RoutesStoredInListMethodsTest {
    List<Map<String, Object>> routes = List.of(
            Map.of("path", "/courses/:id", // url
                    "method", "GET", // метод запроса
                    "handler", Map.of("body", "courses get"), // обработчик
                    "constraints", Map.of("id", "\\w+")), // плейсхолдер и соответствующая ему регулярка
            Map.of("path", "/courses/:id",
                    "method", "PUT",
                    "handler", Map.of("body", "courses update"),
                    "constraints", Map.of("id", "\\w+")),
            Map.of("path", "/courses/:id",
                    "method", "DELETE",
                    "handler", Map.of("body", "courses delete"),
                    "constraints", Map.of("id", "\\w+")),
            Map.of("path", "/courses",
                    "method", "POST",
                    "handler", Map.of("body", "courses! create")),
            Map.of("path", "/courses",
                    "method", "GET",
                    "handler", Map.of("body", "courses! get"))
    );

    @Test public void routerFindStaticPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(routes, Map.of("path", "/courses", "method", "GET"));
        assertEquals("courses! get", handler.get("body"));
    }

    @Test public void routerFindStaticPathTest2() throws Exception {
        Map<String, String> handler = Router.serve(routes, Map.of("path", "/courses", "method", "POST"));
        assertEquals("courses! create", handler.get("body"));
    }

    @Test public void routerNotFindStaticPathTest1() throws Exception {
        try {
            Map<String, String> handler = Router.serve(routes,
                    Map.of("path", "/courses", "method", "PUT"));
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindStaticPathTest2() throws Exception {
        try {
            Map<String, String> handler = Router.serve(routes,
                    Map.of("path", "/courses", "method", "DELETE"));
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerFindDynamicPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(routes, Map.of("path", "/courses/php",
                "method", "GET"));
        assertEquals("courses get", handler.get("body"));
    }

    @Test public void routerFindDynamicPathTest2() throws Exception {
        Map<String, String> handler = Router.serve(routes, Map.of("path", "/courses/php",
                "method", "PUT"));
        assertEquals("courses update", handler.get("body"));
    }

    @Test public void routerFindDynamicPathTest3() throws Exception {
        Map<String, String> handler = Router.serve(routes, Map.of("path", "/courses/php",
                "method", "DELETE"));
        assertEquals("courses delete", handler.get("body"));
    }

    @Test public void routerNotFindDynamicPathTest1() throws Exception {
        try {
            Map<String, String> handler = Router.serve(routes,
                    Map.of("path", "/courses/php", "method", "POST"));
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }
}
 */
