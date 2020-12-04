import java.util.*;

public class BFSQueue {
    private static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    private static HashSet<Integer> visited = new HashSet<>();

    private static void addEdge(int node, int adj) {
        if(!graph.containsKey(node)) {
            graph.put(node, new ArrayList<Integer>());
        }
        graph.get(node).add(adj);
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();

        // check initial node
        visited.add(startNode);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // process current node
            System.out.print(node + " ");

            // get all adjacency of current node
            for (int adj : graph.get(node)) {
                // if adj is not visited then check it as visited and enqueue
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.offer(adj);
                }
            }
        }
    }

    public static void main(String args[]) {
        /**
         *  Graph
         * <node> : <adjacency>  
         *      0 : 1 2 4
         *      1 : 0 2
         *      2 : 0 1 3 4
         *      3 : 2 4
         *      4 : 0 2 3
         */
        graph.clear();
        visited.clear();
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 0);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 1);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(3, 2);
        addEdge(3, 4);
        addEdge(4, 0);
        addEdge(4, 2);
        addEdge(4, 3);

        bfs(0); /* 0 1 2 4 3 */
        System.out.println();



        /**
         *           0
         *        /     \
         *      1        2
         *     /  \     /  \
         *    3    4   5    6
         */
        graph.clear();
        visited.clear();
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 0);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 0);
        addEdge(2, 5);
        addEdge(2, 6);
        addEdge(3, 1);
        addEdge(4, 1);
        addEdge(5, 2);
        addEdge(6, 2);

        bfs(0); /* 0 1 2 3 4 5 6 */
        System.out.println();
    }
}

