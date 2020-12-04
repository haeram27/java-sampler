import java.util.ArrayDeque;
import java.util.Map;
import java.util.Map.Entry;

public class MazeDFSStack {
    private static final int N = 8;
    private static final int GOAL_X = N-1;
    private static final int GOAL_Y = N-1;

    private static final int ROADS_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;

    /** ON WAY */
    private static int[][] maze = {
            { 0, 0, 0, 0, 0, 0, 0, 1 },
            { 0, 1, 1, 0, 1, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 0, 0, 1, 1, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 1, 1 },
            { 0, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 1, 1, 0, 1, 0, 0 } };
    
    /** NO WAY *//*
    private static int[][] maze = {
            { 0, 0, 0, 0, 0, 0, 0, 1 },
            { 0, 1, 1, 0, 1, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 0, 0, 1, 1, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 1, 1 },
            { 0, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 1, 1, 0, 1, 1, 0 } };
    */

    private static ArrayDeque<Entry<Integer, Integer>> stk = new ArrayDeque<>();
    
    public static boolean boundCheck(int value) {
        return (value >= 0 && value <= (N-1))? true : false;
    }

    public static void findMazePath(int startx, int starty) {
        
        Entry<Integer, Integer> point = Map.entry(startx, starty);
        stk.push(point);
        
        while(!stk.isEmpty()) {
            Entry<Integer, Integer> current = stk.pop();
            int x = current.getKey();
            int y = current.getValue();

            if (x < 0 || y < 0 || x > N - 1 || y > N - 1) {
                System.out.println(x + "," + y);
                continue;
            } else if (x == GOAL_X && y == GOAL_Y) {
                // here is GOAL!
                maze[x][y] = PATH_COLOR;
                break;
            } else if (maze[x][y] == PATH_COLOR) {
                // this is backtracked point
                maze[x][y] = BLOCKED_COLOR;
                continue;
            }  else {
                // mark here as PATH
                maze[x][y] = PATH_COLOR;
                stk.push(Map.entry(x, y));  // For BackTracking

                /*
                 * If there is other ROAD(0) on up/down/left/right from here(PATH(3)) 
                 * then here is PATH.
                 */
                if(boundCheck(x+1) && maze[x+1][y] == ROADS_COLOR) stk.push(Map.entry(x+1, y));
                if(boundCheck(y+1) && maze[x][y+1] == ROADS_COLOR) stk.push(Map.entry(x, y+1));
                if(boundCheck(x-1) && maze[x-1][y] == ROADS_COLOR) stk.push(Map.entry(x-1, y));
                if(boundCheck(y-1) && maze[x][y-1] == ROADS_COLOR) stk.push(Map.entry(x, y-1));
            }
        }
    }

    public static void main(String[] args) {
        findMazePath(0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}