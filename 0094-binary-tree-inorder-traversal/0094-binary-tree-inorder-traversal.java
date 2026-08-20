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
    /*public void inorder(TreeNode r,ArrayList<Integer> ar)
    {
        if(r==null) return;
        inorder(r.left,ar);
        ar.add(r.val);
        inorder(r.right,ar);

    }
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }*/
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {

                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;      // create thread
                    curr = curr.left;
                } else {
                    pred.right = null;      // remove thread
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}