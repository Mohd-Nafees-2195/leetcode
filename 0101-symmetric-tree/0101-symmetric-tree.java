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
    boolean ans=true;
    public boolean isSymmetric(TreeNode root) {
        check(root.left,root.right);
        return ans;
    }
    boolean check(TreeNode leftT,TreeNode rightT){
        if(!ans) return false;
        if((leftT==null&&rightT!=null)||(leftT!=null&&rightT==null)) {
            ans=false;
            return false;
        }
        if(leftT==null&&rightT==null){
            ans=true;
            return ans;
        }
        if(leftT.val!=rightT.val) {
            ans=false;
            return false;
        }
        check(leftT.left,rightT.right);
        check(leftT.right,rightT.left);
        return ans;
    }
}