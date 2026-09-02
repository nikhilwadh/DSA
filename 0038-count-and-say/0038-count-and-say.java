class Solution {
    public String countAndSay(int n) {
        return countAndSay1(n);
    }
    public String countAndSay1(int num) 
    {
        if(num==1)
        {
            return "1";
        }
        String s=countAndSay1(num-1);
        int arr[]=new int[10];
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