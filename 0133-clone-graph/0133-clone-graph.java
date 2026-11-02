/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution 
{
    public Node cloneGraph(Node node) 
    {
        if(node == null)
        {
            return null;
        }

        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> visited = new HashMap<>();

        q.add(node);
        visited.put(node, new Node(node.val));

        while(!q.isEmpty())
        {
            Node curr = q.poll();

            for(Node i : curr.neighbors)
            {
                if(!visited.containsKey(i))
                {
                    visited.put(i, new Node(i.val));
                    q.add(i);
                }

                visited.get(curr).neighbors.add(visited.get(i));
            }
        }

        return visited.get(node);
    }
}