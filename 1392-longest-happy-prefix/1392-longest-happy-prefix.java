class Solution {
    public String longestPrefix(String s) {
        StringBuilder pre=new StringBuilder();
        StringBuilder suf=new StringBuilder();
        int n=s.length();
        int i=0,j=n-1;
        String ans="";
        while(i<n-1 && j>0)
        {
            pre.append(s.charAt(i));
            suf.insert(0,s.charAt(j));
            if(pre.compareTo(suf)==0)
            {
                ans=suf.toString();
            }
            i++;
            j--;
        }
        return ans;
    }
}