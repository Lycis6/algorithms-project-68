package hexlet.code.router.routesBasedOnPrefixTree;

import java.util.ArrayList;

public class PrefixTree {
    private final PrefixTreeNode root;
    public PrefixTree(PrefixTreeNode root) {
        this.root = root;
    }
    public PrefixTree() {
        this.root = new PrefixTreeNode(false, new ArrayList<>(), null, false);
    }

    public PrefixTreeNode getRoot() {
        return root;
    }
}
