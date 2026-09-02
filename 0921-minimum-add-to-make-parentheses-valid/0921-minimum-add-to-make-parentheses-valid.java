class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        int count=0;
        int b=0;
        for(int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);
            switch(p)
            {
            case '(':b++;
                     break;
            case ')':if(b==0)
                     {
                        count++; 
                     }
                     else
                     {
                        b--;
                     }
                     break;
            }
        }
        count+=b;
        return count;
    }
}