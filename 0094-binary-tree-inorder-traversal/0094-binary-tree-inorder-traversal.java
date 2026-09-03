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

    /*
    // 1. Recursive Inorder

    public List<Integer> recursiveInorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        recursive(root, ans);

        return ans;
    }

    private void recursive(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        recursive(root.left, ans);

        ans.add(root.val);

        recursive(root.right, ans);
    }
    */


    /*
    // 2. Iterative Inorder using Stack

    public List<Integer> stackInorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            ans.add(curr.val);

            curr = curr.right;
        }

        return ans;
    }
    */


    // 3. Morris Inorder

    public List<Integer> morrisInorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {

                ans.add(curr.val);

                curr = curr.right;
            }

            else {

                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {

                    pred.right = curr;

                    curr = curr.left;
                }

                else {

                    pred.right = null;

                    ans.add(curr.val);

                    curr = curr.right;
                }
            }
        }

        return ans;
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        return morrisInorder(root);
    }
}