class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String word:words)
        {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(
            (a,b) -> { 
            if(map.get(a)!=map.get(b))
            {
                return Integer.compare(map.get(b),map.get(a));
            }
            return a.compareTo(b);
            }
        );
        for (String word : map.keySet()) {
            pq.add(word);
        }

        List<String> l=new ArrayList<>();
        while(k>0)
        {
            l.add(pq.poll());
            k--;
        }
        return l;
    }
}