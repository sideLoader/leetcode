package BinarySearchTree;
import java.util.*;
import java.util.stream.Collectors;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return a == pair.a &&
                b == pair.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

class BinarySearchTree {

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    public BinarySearchTree() { root = null; }


    void insert(int data) { root = insert(data, root); }

    private Node insert(int data, Node root) {
        if(root == null) {
            root = new Node(data);
        } else {
            if (root.data > data)
                root.left = insert(data, root.left);
            else if (root.data < data)
                root.right = insert(data, root.right);
        }
        return root;
    }

    void levelOrderTraversal() {
        if(root == null) return;

        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);

        while(list.isEmpty() != true) {
            Node temp = list.removeFirst();
            if(temp == null) {
                if(list.isEmpty() != true)
                    list.add(null);
                System.out.println();
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) list.add(temp.left);
                if (temp.right != null) list.add(temp.right);
            }
        }

    }

    void inOrderTraversal() { inOrderTraversal(root); }
    public void inOrderTraversal(Node root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    void rootToLeafSum() { rootToLeafSum(new ArrayList<>(), root, 0); }

    private void rootToLeafSum(ArrayList<Integer> path, Node root, int index) {
        if(root == null) return;

        path.add(index, root.data);
        index++;

        if(root.left == null && root.right == null) {
            for(int i = 0; i < index; i++) { System.out.print(path.get(i) + " "); }
            System.out.println();
        }
        else {
            rootToLeafSum(path, root.left, index);
            rootToLeafSum(path, root.right, index);
        }
    }

    public int getHeight() { return getHeightIter(root); }

    private int getHeightIter(Node root) {
        if(root == null) return 0;
        int count = 0;

        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);

        while(list.isEmpty() != true) {
            Node temp = list.removeFirst();

            if(temp == null) {
                if(list.isEmpty() != true)
                    list.addLast(null);
                count++;
            } else {
                if(temp.left != null) list.addLast(temp.left);
                if(temp.right != null) list.addLast(temp.right);
            }
        }

        return count;

    }
    private int getHeight(Node root) {
        if(root == null) return 0;

        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        return Math.max(lHeight, rHeight) +1;
    }

    public void printLevel(int level) { printLevel(root, level); }
    private void printLevel(Node root, int level) {
        if(root == null) return;

        if(level == 0) {
            System.out.print(root.data + " ");
        } else {
            if(root.left != null) printLevel(root.left, level -1);
            if(root.right != null) printLevel(root.right, level -1);
        }
    }

    public int getDiameter() { return getDiameter(root); }

    private int getDiameter(Node root) {
        if(root == null) return 0;

        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        int lDiameter = getDiameter(root.left);
        int rDiameter = getDiameter(root.right);

        return Math.max(Math.max(lDiameter, rDiameter), lHeight + rHeight + 1);
    }


    private int getDiameter(Node root, int dia) {
        if(root == null) return 0;

        int lDiameter = getDiameter(root.left, dia);
        int rDiameter = getDiameter(root.right, dia);
        dia = Math.max(dia, lDiameter + rDiameter + 1);

        return Math.max(lDiameter, rDiameter) + 1;
    }

    public void verticalSum() {
        Map<Integer, Integer> map = new HashMap<>();
        verticalSum(root, 0, map);
        map.forEach((k,v) -> System.out.print(v + " "));
    }

    private void verticalSum(Node root, int index, Map<Integer, Integer> counts) {
        if(root == null) return;

        counts.merge(index, root.data, (a, b) -> a + b);
        verticalSum(root.left, index -1, counts);
        verticalSum(root.right, index +1, counts);
    }


    public int secondLargest() { return secondLargest(root, null); }

    private int secondLargest(Node root, Node prev) {
        if(root == null) return -1;

        return (root.right != null) ?
                secondLargest(root.right, root) : prev.data;
    }

    public void printLeaf() { printLeaf(root); }

    private void printLeaf(Node root) {
        if(root != null) {
            printLeaf(root.left);

            if(root.left == null && root.right == null)
                System.out.println(root.data);

            printLeaf(root.right);
        }
    }


    public boolean isBST(Node root) {
        if(root == null) return true;

        if((root.left != null && root.data > root.left.data) ||
                (root.right != null && root.data < root.right.data)
        ) return false;

        if(!isBST(root.left) || !isBST(root.right))
            return false;

        return true;
    }


    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int l, int r) {
        if(root == null) return true;

        if(root.data < l || root.data > r)
            return false;

        return isBST(root.left, root.data -1, r) &&
                isBST(root.right, l, root.data -1);
    }


    public Node lcaBT(Node root, Node l, Node r) {
        if(root == null) return null;

        if(root.data == l.data || root.data == r.data)
            return root;

        Node lNode = lcaBT(root.left, l, r);
        Node rNode = lcaBT(root.right, l, r);

        if(lNode != null && rNode != null)
            return root;

        return (lNode != null) ? lNode : rNode;
    }


    public Node lcaBST(Node root, Node l, Node r) {
        if(root == null) return null;

        if(root.data < l.data && root.data < r.data)
            return lcaBST(root.right, l, r);

        if(root.data > l.data && root.data > r.data)
            return lcaBST(root.left, l, r);

        return root;
    }


    public Pair isSumPair(int sum) {
        return isSumPair(root, sum, new HashSet<>());
    }

    private Pair isSumPair(Node root, int sum, HashSet<Integer> set) {
        if(root == null) return null;

        int remaining = sum - root.data;
        if(set.contains(root.data)) {
            return new Pair(root.data, remaining);
        } else {
            set.add(remaining);
        }

        Pair l = isSumPair(root.left, sum, set);
        Pair r = isSumPair(root.right, sum, set);

        return (l == null) ? r : l;
    }

    public void doesPathExists(int sum) {
        doesPathExists(root, sum, new LinkedList<>());
    }

    private void doesPathExists(Node root, int sum, LinkedList<Integer> solution) {
        if(root == null) return;

        if(sum == root.data && root.left == null && root.right == null) {
            solution.add(root.data);
            solution.forEach(x -> System.out.print(x + " "));
            System.out.println();
        } else {
            solution.add(root.data);

            doesPathExists(root.left, sum - root.data, solution);
            doesPathExists(root.right, sum - root.data, solution);

            solution.removeLast();
        }

    }

    public String serialize() {
        return serialize(root, "");
    }

    private String serialize(Node root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += root.data + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }


    public Node deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return deserialize(data_list);
    }

    private Node deserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        Node root = new Node(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deserialize(l);
        root.right = deserialize(l);

        return root;
    }

    void bottomView() {
        if(root == null) return;

        Map<Integer, Integer> map = new HashMap<>();
        bottomViewUtil(root, map, 0);

        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    private void bottomViewUtil(Node root, Map<Integer, Integer> map, int index) {
        if(root == null) return;

        map.put(index, root.data);

        bottomViewUtil(root.left, map, index -1);
        bottomViewUtil(root.right, map, index +1);

    }

    void leftView() {
        if(root == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int level = 0, prevLevel = -1;
        while(!queue.isEmpty()) {
            Node current = queue.removeFirst();

            if(current == null) {
                if(!queue.isEmpty())
                    queue.add(null);
                level++;
            } else {
                if(prevLevel == level -1) {
                    System.out.println(current.data);
                    prevLevel++;
                }
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
        }
    }

}

public class Main {

    /*
            10
           /   \
          5     15
           \    / \
            8  11  16



     */
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(8);
        bst.insert(15);
        bst.insert(11);
        bst.insert(16);
        bst.leftView();
        //bst.inOrderTraversal();
        //bst.levelOrderTraversal();
        //bst.rootToLeafSum();
        //System.out.println(bst.getHeight());
        //bst.printLevel(2);
        //System.out.println(bst.secondLargest());
        //bst.printLeaf();
        //bst.verticalSum();
        //Pair p = bst.isSumPair(26);
        //bst.doesPathExists(36);
        //System.out.println(p.a + " , " + p.b);

        //bst.inOrderTraversal();

        //bst.inOrderTraversal(bst.deserialize(bst.serialize()));


    }
}