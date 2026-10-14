class Solution 
{
    public int islandPerimeter(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    count += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                    {
                        count -= 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1)
                    {
                        count -= 2;
                    }
                }
            }
        }

        return count;
    }
}