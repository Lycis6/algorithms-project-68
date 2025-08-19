package hexlet.code.router;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Map<String, Object>> routes = List.of(
                Map.of("path", "/courses",
                        "handler", Map.of("body", "courses")),
                Map.of("path", "/courses/basics",
                        "handler", Map.of("body", "basics"))
        );
        try {
            Map<String, String> handler = Router.serve(routes, "sdv");
            System.out.println(handler.get("body"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
