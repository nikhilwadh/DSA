/*class Solution {
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
}*/class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int k = 1; k < n; k++) {
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int j = i;

                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }

                ans.append(j - i);
                ans.append(s.charAt(i));

                i = j - 1;
            }

            s = ans.toString();
        }

        return s;
    }
}