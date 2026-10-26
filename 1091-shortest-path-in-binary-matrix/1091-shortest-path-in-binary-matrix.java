class Solution 
{
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> visited=new ArrayList<>();
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