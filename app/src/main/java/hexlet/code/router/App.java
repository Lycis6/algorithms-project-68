package hexlet.code.router;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Map<String, Object>> routes = List.of(
                Map.of("path", "/courses/:id", // сам url
                        "handler", Map.of("body", "course!"), // обработчик с телом
                        "constraints", Map.of("id", "\\w+")), // плейсхолдер и соответствующая ему регулярка
                Map.of("path", "/courses/:course_id/exercises/:id",
                        "handler", Map.of("body", "exercise!"),
                        "constraints", Map.of("course_id", "\\w+",
                                                  "id", "\\w+")),
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
