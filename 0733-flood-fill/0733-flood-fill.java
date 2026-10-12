class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        if(image[sr][sc]==color)
        {
            return image;
        }
        int old=image[sr][sc];
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{sr,sc});
                    while(!q.isEmpty())
                    {
                        int s=q.size();
                        for(int i=0;i<s;i++)
                        {
                            int[] arr=q.poll();
                            int r=arr[0];
                            int c=arr[1];

                            image[r][c]=color;
                            if(r>0 && image[r-1][c]==old)
                            {
                                image[r-1][c]=color;
                                q.add(new int[]{r-1,c});
                            }
                            if(r<image.length-1 && image[r+1][c]==old)
                            {
                                image[r+1][c]=color;
                                q.add(new int[]{r+1,c});
                            }
                            if(c>0 && image[r][c-1]==old)
                            {
                                image[r][c-1]=color;
                                q.add(new int[]{r,c-1});
                            }
                            if(c<image[0].length-1 && image[r][c+1]==old)
                            {
                                image[r][c+1]=color;
                                q.add(new int[]{r,c+1});
                            }                            
                        }
                    }
                    return image;
                }
}