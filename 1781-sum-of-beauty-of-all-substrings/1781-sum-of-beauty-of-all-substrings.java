class Solution {
    public int beautySum(String s) {
        if(s.length()<3) return 0;
        int n=s.length();
        int count=0;
        for(int i=0;i<n-2;i++)
        {
            char freq[]=new char[26];
            for(int j=i;j<n;j++)
            {
                freq[s.charAt(j)-'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }

                count+=max-min;
            }
        }
        return count;
    }
}