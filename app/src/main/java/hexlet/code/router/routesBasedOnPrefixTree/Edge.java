package hexlet.code.router.routesBasedOnPrefixTree;

public class Edge {
    private PrefixTreeNode from;
    private PrefixTreeNode to;
    private String segment;
    private EdgeType type;
    private String constraint; // не null, если ребро с плейсхолдером

    public Edge(PrefixTreeNode from, PrefixTreeNode to, String segment, EdgeType type,  String constraint) {
        this.from = from;
        this.to = to;
        this.segment = segment;
        this.type = type;
        if (type.equals(EdgeType.PLACEHOLDER)) {
            this.constraint = constraint;
        } else {
            this.constraint = null;
        }
    }

    public PrefixTreeNode getFrom() {
        return from;
    }

    public PrefixTreeNode getTo() {
        return to;
    }

    public String getSegment() {
        return segment;
    }

    public EdgeType getType() {
        return type;
    }

    public String getConstraint() {
        return constraint;
    }

    public String setConstraint(String constraint) {
        return this.constraint = constraint;
    }

    public boolean matches(String input) {
        if (type.equals(EdgeType.STATIC)) {
            return input.equals(segment);
        } else {
            return input.matches(constraint);
        }
    }
}
