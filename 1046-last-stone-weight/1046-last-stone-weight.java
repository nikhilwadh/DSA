class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }
        while(pq.size()>1)
        {
            int a=pq.poll();
            int b=pq.poll();
            if(a==b)
            continue;
            else
            pq.add(a-b);
        }
        if(pq.size()==0) return 0;
        return pq.poll();
    }
}