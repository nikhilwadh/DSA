class Solution {
    public int romanToInt(String s) {
        int total=0;
        int n=s.length();
        for(int i=0;i<n-1;i++)
        {
            char p=s.charAt(i);
            char q=s.charAt(i+1);
            switch(p)
            {
            case 'M': total+=1000; break;
            case 'D': total+=500; break;
            case 'C': if(q=='D' || q=='M') total-=100; else total+=100; break;
            case 'L': total+=50; break;
            case 'X': if(q=='L' || q=='C') total-=10; else total+=10; break;
            case 'V': total+=5; break;
            case 'I': if(q=='V' || q=='X') total-=1; else total+=1; break;
            }
        }
        switch(s.charAt(n-1))
            {
            case 'M': total+=1000; break;
            case 'D': total+=500; break;
            case 'C': total+=100; break;
            case 'L': total+=50; break;
            case 'X': total+=10; break;
            case 'V': total+=5; break;
            case 'I': total+=1; break;
            }
        return total;
    }
}