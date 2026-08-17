/*
class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length()==0) return s;
        ArrayDeque<Character> st=new ArrayDeque<>();
        StringBuilder ans=new StringBuilder();
        int start=0;
        for(int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);

            if(p=='(')
            {
                st.push(p);
            }
            else
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans.append(s.substring(start+1,i));
                start=i+1;
            }
        }
        return ans.toString();
    }
}
*/

class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length()==0) return s;
        StringBuilder ans=new StringBuilder();
        int depth=0;
        for(int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);
            if(p=='(')
            {
                depth++;
                if(depth>1) ans.append(p);
            }
            else
            {
                depth--;
                if(depth>0) ans.append(p);
            }
        }
        return ans.toString();
    }
}