package hexlet.code.router;

import java.util.List;
import java.util.Map;

public class Router {
    public static String getGreeting() {
        return "Hello World!";
    }

    public static Map<String, String> serve(List<Map<String, Object>> routes, String path) throws Exception {
        try {
            for (Map<String, Object> route : routes) {
                if (route.get("path").equals(path)) {
                    return (Map<String, String>) route.get("handler");
                }
            }
            throw new Exception("Path not found");
        } catch (Exception e) {
            throw e;
        }
    }


}
