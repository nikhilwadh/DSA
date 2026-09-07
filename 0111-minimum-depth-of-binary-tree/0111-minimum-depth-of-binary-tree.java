/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int depth=1;
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode r=q.poll();

                if(r.left==null && r.right==null)
                return depth;

                if(r.left!=null) q.add(r.left);
                if(r.right!=null) q.add(r.right);
            }
            depth++;
        }
        return -1;
    }
}