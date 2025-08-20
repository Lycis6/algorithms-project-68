package hexlet.code.router.routesBasedOnPrefixTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PrefixTreeNode {
    private final boolean isTerminal;
    private final boolean isLeaf;
    private List<Edge> edges;
    private Map<String, String> handler; // не null, если узел - терминальный
    public PrefixTreeNode(boolean isTerminal, List<Edge> edges, Map<String, String> handler, boolean isLeaf) {
        this.isTerminal = isTerminal;
        this.edges = edges;
        this.isLeaf = isLeaf;
        if (isTerminal) {
            this.handler = handler;
        } else {
            this.handler = null;
        }
    }

    public PrefixTreeNode(boolean isTerminal, Map<String, String> handler, boolean isLeaf) {
        this.isTerminal = isTerminal;
        this.edges = new ArrayList<>();
        this.isLeaf = isLeaf;
        if (isTerminal) {
            this.handler = handler;
        } else {
            this.handler = null;
        }
    }

    public Edge edgesMatchesSegment(String segment) {
        for (Edge edge : edges) {
            if (edge.getSegment().equals(segment)) {
                return edge;
            } else {
                if (edge.getType().equals(EdgeType.PLACEHOLDER) && segment.matches(edge.getConstraint())) {
                    return edge;
                }
            }
        }
        return null;
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

    public boolean isLeaf() {
        return isLeaf;
    }
}
