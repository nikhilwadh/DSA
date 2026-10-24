class Solution 
{
    public int openLock(String[] deadends, String target) 
    {
        HashSet<String> dead=new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000")) return -1;
        HashSet<String> visited=new HashSet<>();

        class Pair
        {
            StringBuilder sb;
            int count;

            Pair(StringBuilder sb, int c)
            {
                this.sb=sb;
                this.count=c;
            }
        }

        Queue<Pair> q=new LinkedList<>();
        StringBuilder n=new StringBuilder("0000");
        Pair ob=new Pair(n,0);
        q.add(ob);
        visited.add(n.toString());

        while(!q.isEmpty())
        {
            Pair obj=q.poll();
            int count=obj.count;
            if(obj.sb.toString().equals(target))
            {
                return count;
            }

            for(int i = 0; i < 4; i++) 
            {
                char c = obj.sb.charAt(i); 

                StringBuilder s1 = new StringBuilder(obj.sb);
                s1.setCharAt(i, (char) (((c - '0' + 1) % 10) + '0'));

                StringBuilder s2 = new StringBuilder(obj.sb);
                s2.setCharAt(i, (char) (((c - '0' - 1 + 10) % 10) + '0')); 

                String a=s1.toString();
                String b=s2.toString();
                 
                if(!dead.contains(a) && !visited.contains(a))
                {
                    Pair obj1=new Pair(s1,count+1);
                    q.add(obj1);
                    visited.add(a);
                }
                if(!dead.contains(b) && !visited.contains(b))
                {
                    Pair obj2=new Pair(s2,count+1);
                    q.add(obj2);
                    visited.add(b);
                }                
            }
        }
        return -1;
    }
}