public class MazeDFSRecur {
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


    public static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x > N - 1 || y > N - 1) {
            return false;
        } else if (x == GOAL_X && y == GOAL_Y) {
            // here is GOAL!
            maze[x][y] = PATH_COLOR;
            return true;
        } else if (maze[x][y] != ROADS_COLOR) {
            return false;
        } else {
            // mark here as PATH
            maze[x][y] = PATH_COLOR;

            /*
             * If there is other ROAD(0) on up/down/left/right from here(PATH(3)) 
             * then here is PATH.
             */
            if (findMazePath(x - 1, y) || findMazePath(x, y + 1) ||
                findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
                
                /** backtracked */
                return true;
            }
            
            /** backtracked */
            /*
             * If there is NO other ROAD(0) on up/down/left/right from here(PATH(3)) 
             * then here is BLOCKED.
             */
            maze[x][y] = BLOCKED_COLOR;
            return false;
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