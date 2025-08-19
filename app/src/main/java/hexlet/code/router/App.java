package hexlet.code.router;

import hexlet.code.router.routesBasedOnPrefixTree.Edge;
import hexlet.code.router.routesBasedOnPrefixTree.EdgeType;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTree;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTreeNode;

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

        PrefixTree routesByTree = new PrefixTree();
        PrefixTreeNode node1 = new PrefixTreeNode(true, Map.of("body", "courses"));
        PrefixTreeNode node2 = new PrefixTreeNode(true, Map.of("body", "basics"));
        routesByTree.getRoot().addEdge(new Edge(routesByTree.getRoot(), node1, "course",
                EdgeType.STATIC, null));
        node1.addEdge(new Edge(node1, node2, "basics", EdgeType.STATIC, null));


    }
}
