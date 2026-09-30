class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char task:tasks)
        {
            map.put(task,map.getOrDefault(task,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));
        for(Character key:map.keySet())
        {
            pq.add(key);
        }

        Queue<Character> q=new LinkedList<>();

        int cycle=0;
        while(!map.isEmpty())
        {
            cycle++;
            if(!pq.isEmpty())
            {
            char ch=pq.poll();
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                {
                    map.remove(ch);
                }
                else q.add(ch);
            }
            }
            if(cycle%(n+1)==0)
            {
                while(!q.isEmpty()) 
                    pq.add(q.poll());
            }

        }
        return cycle;
    }
}