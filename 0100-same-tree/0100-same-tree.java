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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean no=true;
        return isSame(p,q,no);
    }
    public boolean isSame(TreeNode p,TreeNode q,boolean no){
        if(p==null&&q==null)
         return true;
        if(p==null||q==null)
         return false;
        if(!no)
         return false;
        if(p.val!=q.val){
            no=false;
            return false;
        }
        return isSame(p.left,q.left,no)&&isSame(p.right,q.right,no);
    }
}