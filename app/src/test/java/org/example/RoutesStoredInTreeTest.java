package org.example;

import hexlet.code.router.Router;
import hexlet.code.router.routesBasedOnPrefixTree.Edge;
import hexlet.code.router.routesBasedOnPrefixTree.EdgeType;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTree;
import hexlet.code.router.routesBasedOnPrefixTree.PrefixTreeNode;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoutesStoredInTreeTest {
    private PrefixTree prefixTree;

    public RoutesStoredInTreeTest() {
    /*
      Пути:
      /courses
      /courses/basics
      /courses/basics/:id
      /courses/:course_id/exercises/:id
    */
        PrefixTree routesByTree = new PrefixTree();
        PrefixTreeNode node1 = new PrefixTreeNode(true, Map.of("body", "courses"), false);
        PrefixTreeNode node2 = new PrefixTreeNode(true, Map.of("body", "basics"), false);
        PrefixTreeNode node3 = new PrefixTreeNode(true, Map.of("body", "basics!"), true);
        PrefixTreeNode node4 = new PrefixTreeNode(false, null, false);
        PrefixTreeNode node5 = new PrefixTreeNode(false, null, false);
        PrefixTreeNode node6 = new PrefixTreeNode(true, Map.of("body", "exercises!"), true);
        routesByTree.getRoot().addEdge(new Edge(routesByTree.getRoot(), node1, "courses",
                EdgeType.STATIC, null));
        node1.addEdge(new Edge(node1, node2, "basics", EdgeType.STATIC, null));
        node2.addEdge(new Edge(node2, node3, ":id", EdgeType.PLACEHOLDER, "\\w+"));
        node1.addEdge(new Edge(node1, node4, ":course_id", EdgeType.PLACEHOLDER, "\\w+"));
        node4.addEdge(new Edge(node4, node5, "exercises", EdgeType.STATIC, null));
        node5.addEdge(new Edge(node5, node6, ":id", EdgeType.PLACEHOLDER, "\\w+"));
        this.prefixTree = routesByTree;
    }

    @Test public void routerFindStaticPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(prefixTree, "/courses");
        assertEquals("courses", handler.get("body"));
    }

    @Test public void routerFindStaticPathTest2() throws Exception {
        Map<String, String> handler = Router.serve(prefixTree, "/courses/basics");
        assertEquals("basics", handler.get("body"));
    }

    @Test public void routerNotFindStaticPathTest1() throws Exception {
        try {
            Map<String, String> handler = Router.serve(prefixTree, "/lessons");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindStaticPathTest2() throws Exception {
        try {
            Map<String, String> handler = Router.serve(prefixTree, "/courses/bas");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerFindDynamicPathTest1() throws Exception {
        Map<String, String> handler = Router.serve(prefixTree, "/courses/basics/forEveryone");
        assertEquals("basics!", handler.get("body"));
    }

    @Test public void routerFindDynamicPathTest2() throws Exception {
        Map<String, String> handler = Router.serve(prefixTree, "/courses/basics_orNot/exercises/graphs");
        assertEquals("exercises!", handler.get("body"));
    }

    @Test public void routerNotFindDynamicPathTest1() throws Exception {
        try {
            Map<String, String> handler = Router.serve(prefixTree, "/courses/basics///");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }

    @Test public void routerNotFindDynamicPathTest2() throws Exception {
        try {
            Map<String, String> handler = Router.serve(prefixTree, "/courses/basics/exercises//");
        } catch (Exception e) {
            assertEquals("Path not found", e.getMessage());
        }
    }
}
