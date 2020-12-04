/* importing the inbuilt java classes required for the program */
import java.util.ArrayDeque;
import java.util.Queue;

/* Class to represent Tree node */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}

//Iterative Queue based Java program to do level order traversal 
//of Binary Tree 
public class LevelOrderTraversal {
    
    /* Class to print Level Order Traversal */
    Node root;

    /*
     * Given a binary tree. Print its nodes in level order using array for
     * implementing queue
     */
    void printLevelOrder() {
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // poll() removes the present head.
            Node tempNode = queue.poll();
            System.out.print(tempNode.data); //1
            // System.out.println("pop: " + tempNode.data); //2

            /* Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
             // System.out.println("add: " + tempNode.left.data); //2
            }

            /* Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
             // System.out.println("add: " + tempNode.right.data); //2
            }
        }
    }

    void printPreOrder(Node node) {
        if (node == null) return;

        System.out.print(node.data);
        if (node.left != null)
            printPreOrder(node.left);
        if (node.right != null)
            printPreOrder(node.right);
    }
    
    void printInOrder(Node node) {
        if (node == null) return;
        
        if (node.left != null)
            printInOrder(node.left);
        System.out.print(node.data);
        if (node.right != null)
            printInOrder(node.right);
    }
    
    void printPostOrder(Node node) {
        if (node == null) return;
        
        if (node.left != null)
            printPostOrder(node.left);
        if (node.right != null)
            printPostOrder(node.right);
        System.out.print(node.data);
    }

    public static void main(String args[]) {
        /*
         * creating a binary tree and entering the nodes
         */
        LevelOrderTraversal tree_level = new LevelOrderTraversal();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
        tree_level.root.right.left = new Node(6);
        tree_level.root.right.right = new Node(7);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
        System.out.println();

        System.out.println("Pre order traversal of binary tree is - ");
        tree_level.printInOrder(tree_level.root);
        System.out.println();
    }
}
