class Solution 
{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        int n=graph.length;

        dfs(graph,n-1,0);
        return result;
    }
    public void dfs(int[][] graph, int target, int curr)
    {
        temp.add(curr);
        if(curr==target)
        {
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }

        for(int i=0;i<graph[curr].length;i++)
        {
            dfs(graph,target,graph[curr][i]);
        }
        temp.remove(temp.size()-1);
    }
}