/*
Breadth First Search

class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            int count=0;
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j]=0;
                    while(!q.isEmpty())
                    {
                        count++;
                        int[] arr=q.poll();
                        int r=arr[0];
                        int c=arr[1];
                        
                        if(r>0 && grid[r-1][c]==1)
                        {
                            grid[r-1][c]=0;
                            q.add(new int[]{r-1,c});
                        }
                        if(c>0 && grid[r][c-1]==1)
                        {
                            grid[r][c-1]=0;
                            q.add(new int[]{r,c-1});
                        }
                        if(r<grid.length-1 && grid[r+1][c]==1)
                        {
                            grid[r+1][c]=0;
                            q.add(new int[]{r+1,c});
                        }
                        if(c<grid[0].length-1 && grid[r][c+1]==1)
                        {
                            grid[r][c+1]=0;
                            q.add(new int[]{r,c+1});
                        }
                    }
                    if(count>max)
                    {
                        max=count;
                    }
                    count=0;
                }
            }
        }
        return max;        
    }
}*/

//Depth First Search

class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int count=dfs(grid , i , j );
                    max=max>count?max:count;
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid , int r, int c)
    {
        if(r>=grid.length || r<0 || c>=grid[0].length || c<0 || grid[r][c]==0)
        {
            return 0;
        }
        
        grid[r][c] = 0;

        int area = 1;

        area += dfs(grid, r-1, c);
        area += dfs(grid, r+1, c);
        area += dfs(grid, r, c-1);
        area += dfs(grid, r, c+1);

        return area;
    }
}