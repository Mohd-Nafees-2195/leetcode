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
    int ans=Integer.MAX_VALUE;
    List<Integer> list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        getDiff(root);
        return ans;
    }
    public void getDiff(TreeNode root){
        if(root==null)
         return;
        getDiff(root.left);
        if(!list.isEmpty()){
            ans=Math.min(ans,Math.abs(root.val-list.get(list.size()-1)));
        }
        list.add(root.val);
        getDiff(root.right);
    }
}