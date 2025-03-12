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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return ans;
    }
    public void getSum(TreeNode root,int val){
        if(root==null)
         return;
        if(root.left==null&&root.right==null){
            ans+=10*val+root.val;
            return;
        }
        val=10*val+root.val;
        getSum(root.left,val);
        getSum(root.right,val);
    }

}