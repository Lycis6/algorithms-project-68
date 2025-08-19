package hexlet.code.router.routesBasedOnPrefixTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrefixTreeNode {
    private final boolean isTerminal;
    private List<Edge> edges;
    private Map<String, String> handler; // не null, если узел - терминальный
    public PrefixTreeNode(boolean isTerminal, List<Edge> edges, Map<String, String> handler) {
        this.isTerminal = isTerminal;
        this.edges = edges;
        if (isTerminal) {
            this.handler = handler;
        } else {
            this.handler = null;
        }
    }

    public PrefixTreeNode(boolean isTerminal, Map<String, String> handler) {
        this.isTerminal = isTerminal;
        this.edges = new ArrayList<>();
        if (isTerminal) {
            this.handler = handler;
        } else {
            this.handler = null;
        }
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Map<String, String> getHandler() {
        return handler;
    }

    public void setHandler(Map<String, String> handler) {
        this.handler = handler;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
