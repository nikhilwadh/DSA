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
    //Recursive
    /*public void postorder(TreeNode r,ArrayList<Integer> ar)
    {
        if(r==null) return;
        postorder(r.left,ar);
        postorder(r.right,ar);
        ar.add(r.val);
    }*/
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;

        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        st1.add(root);
        while(!st1.isEmpty())
        {
            TreeNode r=st1.pop();
            if(r.left!=null) st1.add(r.left);
            if(r.right!=null) st1.add(r.right);

            st2.add(r);
        }
        while(!st2.isEmpty())
        {
            list.add(st2.pop().val);
        }
        return list;
    }
}