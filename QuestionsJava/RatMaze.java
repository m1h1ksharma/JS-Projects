public class RatMaze
{
    public static void printSolution(int[][] output, int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int[][] maze, int i, int j, int n)
    {
        if(i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean solveMaze(int[][] maze, int i, int j, int n, int[][] output)
    {
        if(i == n - 1 && j == n - 1 && maze[i][j] == 1)
        {
            output[i][j] = 1;
            return true;
        }
        if(isSafe(maze, i, j, n))
        {
            if(output[i][j] == 1)
            {
                return false;
            }
            output[i][j] = 1;
            if(solveMaze(maze, i + 1, j, n, output)) return true;
            if(solveMaze(maze, i, j + 1, n, output)) return true;
            output[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        {
            int[][] maze = {{1, 0, 1, 0},
                            {1, 1, 0, 1},
                            {1, 1, 0, 0},
                            {0, 1, 1, 1}};
            int n = maze.length;
            int[][] output = new int[n][n];
            if(solveMaze(maze, 0, 0, n, output))
            {
                printSolution(output, n);
            }
             else
            {
                System.out.println("No solution");
            }
        }
    }
}