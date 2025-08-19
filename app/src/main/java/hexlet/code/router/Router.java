package hexlet.code.router;

import hexlet.code.router.routesBasedOnPrefixTree.Edge;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTree;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTreeNode;

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
                } else {
                    String[] pathParts = path.split("/");
                    String[] routeParts = route.get("path").toString().split("/");
                    if (routeParts.length != pathParts.length) {
                        continue;
                    }
                    boolean equal = true;
                    for (int i = 0; i < routeParts.length - 1; i++) {
                        if (!pathParts[i].equals(routeParts[i])) {
                            if (routeParts[i].startsWith(":")) {
                                String placeholder = routeParts[i].substring(1);
                                Map<String, String> constraints = (Map<String, String>) route.get("constraints");
                                if (!pathParts[i].matches(constraints.get(placeholder))) {
                                    equal = false;
                                    break;
                                }
                            } else {
                                equal = false;
                                break;
                            }
                        }
                    }
                    if (equal) {
                        return (Map<String, String>) route.get("handler");
                    }
                }
            }
            throw new Exception("Path not found");
        } catch (Exception e) {
            throw e;
        }
    }

    // перегрузка с путями, хранящимися в префиксном дереве
    public static Map<String, String> serve(PrefixTree routes, String path) throws Exception {
        String[] pathParts = path.split("/");
        PrefixTreeNode current = routes.getRoot();
        int i = 1;
        while (!current.isLeaf() && i < pathParts.length) {
            Edge targetEdge = current.edgesMatchesSegment(pathParts[i]);
            if (targetEdge == null) {
                throw new Exception("Path not found");
            }
            i++;
            current = targetEdge.getTo();
        }
        if (current.isTerminal() && i == pathParts.length) {
            return current.getHandler();
        }
        throw new Exception("Path not found");
    }


}
