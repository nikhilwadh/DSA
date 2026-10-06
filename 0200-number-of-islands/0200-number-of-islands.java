class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int count=0;
        int r=grid.length,c=grid[0].length;
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1')
                {
                    count+=1;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty())
                    {
                        int arr[]=q.poll();
                        int row=arr[0];
                        int col=arr[1];
                        
                        if(row-1>=0 && grid[row-1][col]=='1')
                        {
                            q.offer(new int[]{row-1,col});
                            grid[row-1][col]='0';
                        }
                        if(col-1>=0 && grid[row][col-1]=='1')
                        {
                            q.offer(new int[]{row,col-1});
                            grid[row][col-1]='0';
                        }
                        if(row+1<r && grid[row+1][col]=='1')
                        {
                            q.offer(new int[]{row+1,col});
                            grid[row+1][col]='0';
                        }
                        if(col+1<c && grid[row][col+1]=='1')
                        {
                            q.offer(new int[]{row,col+1});
                            grid[row][col+1]='0';
                        }                    
                    }
                }
            }
        }
        return count;
    }
}