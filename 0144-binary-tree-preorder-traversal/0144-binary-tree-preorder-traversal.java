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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            ans.add(node.val);

            // Push right first so left is processed first
            if (node.right != null)
                st.push(node.right);

            if (node.left != null)
                st.push(node.left);
        }

        return ans;
    }
}
/*class Solution 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> pre=new ArrayList<>();
        if(root==null) return pre;
        preorder(root,pre);
        return pre;
    }

    public void preorder(TreeNode r, List<Integer> a)
    {
        if(r==null)
        {
            return;
        }
        a.add(r.val);
        preorder(r.left,a);
        preorder(r.right,a);
    }  
}*/