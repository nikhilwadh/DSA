class Solution {
    public String countAndSay(int n) {
        if(n==1)
        {
            return "1";
        }
        String s=countAndSay(n-1);
        StringBuilder st=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            int j=i;
            int count=0;
            while(j<s.length() && s.charAt(j)==s.charAt(i))
            {
                count++;
                j++;
            }
            i=j-1;
            st.append(count);
            st.append(s.charAt(i));
        }
            return st.toString();
    }
}