/*class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.add(root);
        map.put(root.val, -1);

        while (!q.isEmpty()) {

            int size = q.size();
            int count = 0;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr.val == x || curr.val == y) {
                    count++;
                }

                if (curr.left != null) {
                    q.add(curr.left);
                    map.put(curr.left.val, curr.val);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    map.put(curr.right.val, curr.val);
                }
            }

            if (count == 2) {
                return !map.get(x).equals(map.get(y));
            }

            if (count == 1) {
                return false;
            }
        }

        return false;
    }
}*/

/*class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            TreeNode px = null;
            TreeNode py = null;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr.left != null) {
                    if (curr.left.val == x) px = curr;
                    if (curr.left.val == y) py = curr;
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    if (curr.right.val == x) px = curr;
                    if (curr.right.val == y) py = curr;
                    q.add(curr.right);
                }
            }

            if (px != null || py != null) {
                return px != null && py != null && px != py;
            }
        }

        return false;
    }
}*/

class Solution {
    int dx=-1,dy=-1,px=-1,py=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,root,0,x,y);

        return dx==dy && px!=py;
    }

    void dfs(TreeNode curr, TreeNode parent,int depth, int x, int y)
    {
        if(curr==null)
        {
            return;
        }
        if(curr.val==x)
        {
            dx=depth;
            px=parent.val;
        }
        if(curr.val==y)
        {
            dy=depth;
            py=parent.val;
        }

        dfs(curr.left,curr,depth+1,x,y);
        dfs(curr.right,curr,depth+1,x,y);
    }
}