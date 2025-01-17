/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return null;
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        double sum = 0;
        int count = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                if (count != 0)
                    ans.add(sum / count);
                sum = 0;
                count = 0;
                if (q.isEmpty())
                    break;
                q.add(null);
            } else {
                sum += temp.val;
                count++;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        return ans;
    }
}