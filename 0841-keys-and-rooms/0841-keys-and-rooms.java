class Solution 
{
    int n=-1;
    int flag=-1;
    HashSet<Integer> set;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        n=rooms.size();
        set=new HashSet<>();

        dfs(rooms,0);
        if(flag==1)
        return true;
        return false;
    }
    public void dfs(List<List<Integer>> rooms, int curr)
    {
        if(set.contains(curr))
        {
            return;
        }
        set.add(curr);
        if(set.size()==n)
        {
            flag=1;
            return;
        }
        for(int i=0;i<rooms.get(curr).size();i++)
        {
            dfs(rooms,rooms.get(curr).get(i));
        }

    }
}