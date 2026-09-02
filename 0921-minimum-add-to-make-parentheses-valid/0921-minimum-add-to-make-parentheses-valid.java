class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        int count=0;
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);
            switch(p)
            {
            case '(':st.push(p);
                     break;
            case ')':if(st.isEmpty())
                     {
                        count++; 
                     }
                     else
                     {
                        st.pop();
                     }
                     break;
            }
        }
        count+=st.size();
        return count;
    }
}