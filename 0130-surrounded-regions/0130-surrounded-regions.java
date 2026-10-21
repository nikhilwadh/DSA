class Solution 
{
    public void solve(char[][] board) 
    {
        int rows=board.length;
        int cols=board[0].length;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='O')
                {
                    Queue<int[]> q=new LinkedList<>();
                    ArrayList<int[]> arr=new ArrayList<>();
                    int flag=0;
                    q.add(new int[]{i,j});
                    arr.add(new int[]{i,j});
                    board[i][j]='1';
                    if(i==0 || i==rows-1 || j==0 || j==cols-1) flag=1;
                    while(!q.isEmpty())
                    {
                        int ar[]=q.poll();
                        int r=ar[0];
                        int c=ar[1];

                        if(r-1>=0 && board[r-1][c]=='O')
                        {
                            if(r-1==0)
                            {
                                flag=1;
                            }
                            
                            board[r-1][c]='1';
                            q.add(new int[]{r-1,c});
                            arr.add(new int[]{r-1,c});
                        }
                        if(c-1>=0 && board[r][c-1]=='O')
                        {
                            if(c-1==0)
                            {
                                flag=1;
                            }
                            board[r][c-1]='1';
                            q.add(new int[]{r,c-1});
                            arr.add(new int[]{r,c-1});
                        }
                        if(r+1<rows && board[r+1][c]=='O')
                        {
                            if(r+1==rows-1)
                            {
                                flag=1;
                            }
                            board[r+1][c]='1';
                            q.add(new int[]{r+1,c});
                            arr.add(new int[]{r+1,c});
                        }
                        if(c+1<cols && board[r][c+1]=='O')
                        {
                            if(c+1==cols-1)
                            {
                                flag=1;
                            }
                            board[r][c+1]='1';
                            q.add(new int[]{r,c+1});
                            arr.add(new int[]{r,c+1});
                        }
                    }
                    if(flag==0)
                    {
                        for(int k=0;k<arr.size();k++)
                        {
                            int a[]=arr.get(k);
                            board[a[0]][a[1]]='X';
                        }
                    }
                    else
                    {
                        for(int k=0;k<arr.size();k++)
                        {
                            int a[]=arr.get(k);
                            board[a[0]][a[1]]='O';
                        }
                    }
                }
            }
        }
    }
}