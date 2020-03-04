package chapter03;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        x.N = h.N;
        h.color = RED;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public Node insert(Key key, Value val) {
        root = insert(root, key, val);
        root.color = BLACK;
        return root; 
    }

    private Node insert(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);
        if (key.compareTo(h.key) < 0)
            h.left = insert(h.left, key, val);
        else
            h.right = insert(h.right, key, val);
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public static void main(String[] args) {
        RedBlackBST<Integer, Character> rb = new RedBlackBST<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            rb.insert(i + 1, (char)(i + 'A'));
        }
    }
}
