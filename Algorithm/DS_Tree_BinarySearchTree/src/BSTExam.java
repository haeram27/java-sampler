import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node() {
        this.left = this.right = null;
    }

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public Object get() {
        return data;
    }
}

class BinarySearchTree {
    private Node _root = null;

    public Node insert(Node root, Node newNode) {
    // PreOrder (전위순회)로 삽입

        // p is parent
        Node p = root;
        
        if (p == null) {
            return newNode;
        } else if (p.data > newNode.data) {
            p.left = insert(p.left, newNode);
            return p;
        } else if (p.data < newNode.data) {
            p.right = insert(p.right, newNode);
            return p;
        } else {
            return p;
        }
    }

    public void insertBST(Node newNode) {
        _root = insert(_root, newNode);
    }

    public Node isPresentLoop(int x) {
        // p is parent
        Node p = _root;
        while (p != null) {
            if (x < p.data)
                p = p.left;
            else if (x > p.data)
                p = p.right;
            else
                return p;
        }
        return p;
    }

    public boolean isPresentRecursive(Node root, int x) {
    // PreOrder (전위순회) 탐색

        // p is parent
        Node p = root;
        
        if (p != null) {
            //check if current node has the element we are looking for
            if (p.data == x) {
                return true;
            } else {
                // check if the sub trees
                return isPresentRecursive(p.left, x) || isPresentRecursive(p.right, x);
            }
        }
        return false;
    }

    // Traversal   
    // 전위, 중위, 후위란  parent가 left와 right 사이 어디에 위치하여 순회하는가를 의미
    // PreOrder(전위순회): Node의 parent(전위), left, right 출력 순서
    // 이진탐색트리의 삽입에 사용
    // Node의 순회 순서 그림
    //       1    
    //     /   \   
    //    2     3 
    // 
    //           1
    //         /   \
    //       2       5
    //     /   \    /  \
    //    3     4  6    7
    //
    // 새로운 이진탐색트리를 만들 때 Tree에 값을 넣거나, 
    // 어떤 값을 이진탐색(Binary-Search)할 때 주로 사용
    //
    // p is parent
    public void preOrder(Node p) {
        if (p == null) return;

        System.out.print(p.data + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    // InOrder(중위순회): Node의 left, parent(중위), right 순서로 순회
    // 이진탐색트리 내의 값을 정렬된 순서로 읽을때 사용
    // ascending(오름차순) 정렬 출력에 사용
    // Node의 순회 순서 그림
    //       2    
    //     /   \  
    //    1     3 
    //
    //           4
    //         /   \
    //       2       6
    //     /   \    /  \
    //    1     3  5    7
    //
    // 이진탐색트리에서 natural-order 출력 할 때 주로 사용, 
    // 이진탐색트리가 N 보다 작은 값은 N의  왼쪽에 
    // N보다 큰 값은 N의 오른쪽에 배치하는 형태이기 때문에
    // InOrder로 순회하며 출력하면 natural-order로 출력이 된다.
    //
    // p is parent
    public void inOrder(Node p) {
        if (p == null) return;

        inOrder(p.left);
        System.out.print(p.data + " ");
        inOrder(p.right);
    }

    // reverseInOrder(역중위순회): Node의 right, parent(중위), left 순서로 순회
    // descending(내림차순) 정렬 출력에 사용
    //
    // p is parent
    public void reverseInOrder(Node p) {
        if (p == null) return;

        inOrder(p.right);
        System.out.print(p.data + " ");
        inOrder(p.left);
    }
    
    // PostOrder(후위순회): Node의 left, right, parent(후위) 순서로 순회
    // Node의 순회 순서 그림
    //       3    
    //     /   \  
    //    1     2 
    // 
    //           7
    //         /   \
    //       3       6
    //     /   \    /  \
    //    1     2  4    5
    //
    // p is parent
    public void postOrder(Node p) {
        if (p == null) return;

        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.data + " ");
    }
    
    // 전체 트리에서 Top 레벨에서 Bottom 레벨 순서대로 출력
    // PreOrder와 비슷하지만 Queue를 이용한다.
    // Node의 순회 순서 그림
    // 
    //           1
    //         /   \
    //       2       3
    //     /   \    /  \
    //    4     5  6    7
    //
    // p is parent
    public void levelOrder(Node p) {
        if (p == null) return;
        
        Queue<Node> q = new ArrayDeque<Node>();
        q.offer(p);
        
        while (!q.isEmpty()) {
            Node tempNode = q.poll();
            System.out.print(tempNode.data + " ");
            
            if (tempNode.left != null) {
                q.offer(tempNode.left);
            }
            
            if (tempNode.right != null) {
                q.offer(tempNode.right);
            }
        }
    }
    
    public Node getRoot() {
        return _root;
    }

    public void printBST() {
        System.out.println("Inorder >>>");
        inOrder(_root);
        System.out.println();
        
        System.out.println("reverseInOrder >>>");
        reverseInOrder(_root);
        System.out.println();
        
        System.out.println("PreOrder >>>");
        preOrder(_root);
        System.out.println();
        
        System.out.println("PostOrder >>>");
        postOrder(_root);
        System.out.println();
        
        System.out.println("LevelOrder >>>");
        levelOrder(_root);
        System.out.println();
    }
}

public class BSTExam {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();


        // Example B-Tree
        //            20
        //          /   \
        //       10        30
        //     /    \    /    \
        //    8     12  25     40
        // For the correct insertion, 
        // top, top-left, top-right insertion order is required
        bst.insertBST(new Node(20));
        bst.insertBST(new Node(10));
        bst.insertBST(new Node(30));
        bst.insertBST(new Node(8));
        bst.insertBST(new Node(12));
        bst.insertBST(new Node(25));
        bst.insertBST(new Node(40));
        System.out.println("Binary Tree >>>");
        
        System.out.println("ROOT: " + bst.getRoot().data);
        System.out.println();
        
        bst.printBST();
        System.out.println();
        
        System.out.println("Is There \"12\" ? >>> ");
        Node p1 = bst.isPresentLoop(12);
        if (p1 != null) {
            System.out.println(p1.data + " 탐색 성공");
        } else {
            System.out.println("탐색 실패");
        }
        System.out.println();
        
        System.out.println("Is There \"25\" ? >>> ");
        Node p2 = bst.isPresentLoop(25);
        if (p2 != null) {
            System.out.println(p2.data + " 탐색 성공");
        } else {
            System.out.println("탐색 실패");
        }
        System.out.println();

        System.out.println("IsPresent \"8\" ? >>> " 
        + bst.isPresentRecursive(bst.getRoot(), 8));
        System.out.println();

        System.out.println("IsPresent \"40\" ? >>> " 
        + bst.isPresentRecursive(bst.getRoot(), 40));
        System.out.println();
        
        System.out.println("IsPresent \"13\" ? >>> " 
        + bst.isPresentRecursive(bst.getRoot(), 13));
        System.out.println();
    }
}