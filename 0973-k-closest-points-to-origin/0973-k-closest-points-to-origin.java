class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b) -> {
            return Double.compare(a[2],b[2]);
        });

        for(int i=0;i<points.length;i++)
        {
            double dist=Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            pq.add(new double[]{(double)points[i][0],(double)points[i][1],dist});
        }
        
        int ans[][]=new int[k][2];
        int n=0;
        while(n<k)
        {
            double curr[]=pq.poll();
            ans[n][0]=(int)curr[0];
            ans[n][1]=(int)curr[1];
            n++;
        }
        return ans;
    }
}