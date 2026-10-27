class Solution 
{
    int cols,rows;
    boolean flag=false;
    public int closedIsland(int[][] grid) 
    {
        rows=grid.length;
        cols=grid[0].length;

        int ans=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==0)
                {
                    flag=false;

                    dfs(grid,i,j);

                    if(!flag)
                    {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid, int r, int c)
    {
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]!=0)
        {
            return;
        }
        if(r==0 || r==rows-1 || c==0 || c==cols-1)
        {
            flag=true;
            return;
        }

        grid[r][c]=2;

        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
    }
}