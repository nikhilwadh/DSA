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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode curr=root;
        TreeNode r=new TreeNode(-1);
        TreeNode dummy=r;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                dummy.right=curr;
                dummy=dummy.right;
                curr=curr.right;

                dummy.left=null;
            }
            else
            {
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr)
                {
                    pred=pred.right;
                }

                if(pred.right==null)
                {
                    pred.right=curr;
                    curr=curr.left;
                }
                else
                {
                    dummy.right=curr;
                    dummy=dummy.right;
                    curr=curr.right;

                    dummy.left=null;
                }
            }
        }
        return r.right;
    }
}