class Solution {
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
}