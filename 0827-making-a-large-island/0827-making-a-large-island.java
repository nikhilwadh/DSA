class Solution 
{
    int rows,cols;
    int count;
    int num=2;
    public int largestIsland(int[][] grid) 
    {
        rows=grid.length;
        cols=grid[0].length;

        HashMap<Integer,Integer> map=new HashMap<>();
        int max=-1;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==1)
                {
                    count=0;
                    dfs(grid,i,j);
                    map.put(num,count);
                    if(max<count)
                    {
                        max=count;
                    }
                    num++;
                }
            }
        }

        int m=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==0)
                {
                    int total=1;
                    HashSet<Integer> set=new HashSet<>();
                    
                    if(j>0 && grid[i][j-1]>1) set.add(grid[i][j-1]);
                    if(i>0 && grid[i-1][j]>1) set.add(grid[i-1][j]);
                    if(j<cols-1 && grid[i][j+1]>1) set.add(grid[i][j+1]);
                    if(i<rows-1 && grid[i+1][j]>1) set.add(grid[i+1][j]);
                    
                    for(int id:set)
                    {
                        total+=map.get(id);
                    }

                    m=Math.max(m,total);
                }
            }
        }
        return Math.max(m,max);        
    }
    public void dfs(int[][] grid, int r, int c)
    {
        if(r>=rows || r<0 || c>=cols || c<0 || grid[r][c]!=1)
        {
            return;
        }

        count++;
        grid[r][c]=num;

        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}