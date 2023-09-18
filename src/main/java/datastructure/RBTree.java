package datastructure;

/**
 * @author LongyunBian
 * @version 2023/9/15 17:36
 */
public class RBTree <Key extends Comparable<Key>, Value> {
    private static final boolean red = true;
    private static final boolean black = false;
    private Node root;
    private class Node {
        Key key;

        Value val;
        Node left, right;
        boolean color;
        Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }

    }
    // 实现红黑树的操作
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == red;
    }
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = black;
    }
    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, red);
        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else              h.val   = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right)) flipColors(h);

        return h;
    }
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else               return x.val;
    }
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public void delete(Key key) {
        if (!contains(key)) return;
        root = delete(root, key);
    }
    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                h.right = deleteMin(h.right);
            } else h.right = delete(h.right, key);
        }
        return balance(h);
    }
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = red;
        return x;
    }
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = red;
        return x;
    }
    private Node moveRedLeft(Node h) {

        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }
    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    private Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        else               return min(x.left);
    }
    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }
    public static void main(String[] args) {
        RBTree<Integer, String> st = new RBTree<>();
        st.put(5, "Five");
        st.put(3, "Three");
        st.put(7, "Seven");
        st.put(2, "Two");
        st.put(4, "Four");
        st.put(6, "Six");
        st.put(8, "Eight");
        System.out.println("Size: " + st.size());
        System.out.println("Value of 5: " + st.get(5));
        st.delete(5);
        System.out.println("Size after deletion of 5: " + st.size());
        System.out.println("Value of 5 after deletion: " + st.get(5));


    }
}
