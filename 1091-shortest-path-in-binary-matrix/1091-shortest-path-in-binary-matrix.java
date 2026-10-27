class Solution 
{
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        grid[0][0]=2;

        int count=2;
        int mincount=Integer.MAX_VALUE;
        int flag=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int[] arr=q.poll();
                int r=arr[0];
                int c=arr[1];
                if(r==n-1 && c==n-1 && mincount>arr[2])
                {
                    mincount=arr[2];
                    flag=1;
                }

                if(r>0 && grid[r-1][c]==0)
                {                    
                    q.add(new int[]{r-1,c,count});
                    grid[r-1][c]=2;                    
                }
                if(c>0 && grid[r][c-1]==0)
                {                    
                    q.add(new int[]{r,c-1,count});
                    grid[r][c-1]=2;                    
                }
                if(r<n-1 && grid[r+1][c]==0)
                {                    
                    q.add(new int[]{r+1,c,count});
                    grid[r+1][c]=2;                    
                }
                if(c<n-1 && grid[r][c+1]==0)
                {                    
                    q.add(new int[]{r,c+1,count});
                    grid[r][c+1]=2;                    
                }
                if(r>0 && c>0 && grid[r-1][c-1]==0)
                {                    
                    q.add(new int[]{r-1,c-1,count});
                    grid[r-1][c-1]=2;                    
                }
                if(r>0 && c<n-1 && grid[r-1][c+1]==0)
                {                    
                    q.add(new int[]{r-1,c+1,count});
                    grid[r-1][c+1]=2;                    
                }
                if(r<n-1 && c>0 && grid[r+1][c-1]==0)
                {                    
                    q.add(new int[]{r+1,c-1,count});
                    grid[r+1][c-1]=2;                    
                }
                if(r<n-1 && c<n-1 && grid[r+1][c+1]==0)
                {                    
                    q.add(new int[]{r+1,c+1,count});
                    grid[r+1][c+1]=2;                    
                }
            }
            count++;
        }
        return flag==1?mincount:-1;
    }
}

/*class Solution 
{
    int n;
    int mincount=Integer.MAX_VALUE;

    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        
        dfs(grid,0,0,1);
        return mincount == Integer.MAX_VALUE ? -1 : mincount;
    }

    public void dfs(int[][] grid, int r,int c,int count)
    {
        if(r<0 || r>=n || c<0 || c>=n || grid[r][c]!=0 || count>=mincount)
        {
            return;
        }
        if(r==n-1 && c==n-1 && mincount>count)
        {
            mincount=count;
            return;
        }

        grid[r][c]=2;

        dfs(grid,r-1,c,count+1);
        dfs(grid,r+1,c,count+1);
        dfs(grid,r,c-1,count+1);
        dfs(grid,r,c+1,count+1);
        dfs(grid,r-1,c-1,count+1);
        dfs(grid,r-1,c+1,count+1);
        dfs(grid,r+1,c-1,count+1);
        dfs(grid,r+1,c+1,count+1);

        grid[r][c] = 0;
    }
}*/
