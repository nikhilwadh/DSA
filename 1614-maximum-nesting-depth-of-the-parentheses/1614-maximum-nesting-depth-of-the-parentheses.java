/*class Solution {
    public int maxDepth(String s) {
        ArrayDeque<Character> st=new ArrayDeque<>();
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);
            switch(p)
            {
            case '(':st.push(p);
                    int sz=st.size();
                    if(sz>max)
                    {
                        max=sz;
                    }
                    break;
            case ')':st.pop();
                    break;
            default:continue;
            }
        }
        return max;
    }
}*/

class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
                max = Math.max(max, depth);
            } 
            else if (s.charAt(i) == ')') {
                depth--;
            }
        }

        return max;
    }
}