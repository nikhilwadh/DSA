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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        Queue<TreeNode> que=new LinkedList<>();
        List<List<Integer>> f = new ArrayList<>();
        if(root==null) return f;

        que.add(root);
        while(!que.isEmpty())
        {
            int size=que.size();
            List<Integer> level = new ArrayList<>(size);
            for(int i=0;i<size;i++)
            {
                TreeNode temp=que.poll();
                level.add(temp.val);
                
                if(temp.left!=null) que.add(temp.left);
                if(temp.right!=null) que.add(temp.right);  
            }
            f.add((level));
        }  
        return f;      
    }
}