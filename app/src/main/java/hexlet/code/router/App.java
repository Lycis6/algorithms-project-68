package hexlet.code.router;

import hexlet.code.router.routesBasedOnPrefixTree.Edge;
import hexlet.code.router.routesBasedOnPrefixTree.EdgeType;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTree;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTreeNode;

import java.util.List;
import java.util.Map;

/*
Поддерживаемые пути:
/courses/:id — Чтение, удаление, обновление
/courses — Создание, чтение нескольких курсов
 */

public class App {
    public static void main(String[] args) {
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

        PrefixTree routesByTree = new PrefixTree();
        PrefixTreeNode node1 = new PrefixTreeNode(true, Map.of("body", "courses"), false);
        PrefixTreeNode node2 = new PrefixTreeNode(true, Map.of("body", "basics"), false);
        routesByTree.getRoot().addEdge(new Edge(routesByTree.getRoot(), node1, "course",
                EdgeType.STATIC, null));
        node1.addEdge(new Edge(node1, node2, "basics", EdgeType.STATIC, null));

    }
}
