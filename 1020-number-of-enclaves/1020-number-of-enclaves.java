class Solution 
{
    int rows,cols,count=0;
    boolean flag=false;
    public int numEnclaves(int[][] grid) 
    {
        rows=grid.length;
        cols=grid[0].length;
        
        int ans=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                count=0;
                flag=false;

                if(grid[i][j]==1)
                {
                    dfs(grid,i,j);
                }

                if(!flag)
                {
                    ans+=count;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid, int r,int c)
    {
        if(r>=rows || r<0 || c>=cols || c<0 || grid[r][c]!=1)
        {
            return;
        }
        if(r==rows-1 || r==0 || c==cols-1 || c==0)
        {
            flag=true;
        }

        count+=1;
        grid[r][c]=2;

        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);    
    }
}