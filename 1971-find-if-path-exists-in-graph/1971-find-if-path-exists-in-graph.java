class Solution 
{
    public boolean validPath(int n, int[][] edges, int source, int destination) 
    {
        if(source==destination) return true;
        int[] visited=new int[n];
        Queue<Integer> q=new ArrayDeque<>();

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        q.add(source);
        visited[source]=1;
        while(!q.isEmpty())
        {
            int s = q.size();

            for(int i = 0; i < s; i++)
            {
                int curr=q.poll();
                if(curr==destination)
                {
                    return true;
                }
                for(int neighbour : adj.get(curr))
                {
                    if(visited[neighbour] == 0)
                    {
                        q.add(neighbour);
                        visited[neighbour] = 1;
                    }
                }
            }
        }
        return false;
    }
}