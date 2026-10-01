class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);
            map.put(p,map.getOrDefault(p,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)-> Integer.compare(map.get(b),map.get(a)));
        for(char c:map.keySet())
        {
            pq.add(c);
        }
        StringBuilder ans=new StringBuilder();
        char prev=0;
        while(!pq.isEmpty())
        {
            char curr=pq.poll();
            ans.append(curr);
            map.put(curr,map.get(curr)-1);
                
            if (prev != 0 && map.get(prev) > 0) 
            {
                pq.add(prev);
            }

            if (map.get(curr) > 0) 
            {
                prev = curr;
            }
            else 
            {
                prev = 0;
            }
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }
}