class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        if(n<2) return n;
        int max=0;
        int start=0;
        for(int i=0;i<n;i++)
        {
            char p=s.charAt(i);

            while(set.contains(p))
            {
                set.remove(s.charAt(start));
                start++;
            }
                max=Math.max(max, i-start+1);   
                set.add(p);
        }
        return max;
    }
}