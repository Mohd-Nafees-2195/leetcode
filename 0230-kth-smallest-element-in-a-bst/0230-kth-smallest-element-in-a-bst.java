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
    Queue<Integer> pq=new PriorityQueue<>((I1,I2)->I2-I1);
    public int kthSmallest(TreeNode root, int k) {
        getKthSmallest(root,k);
        return pq.peek();
    }
    public void getKthSmallest(TreeNode root,int k){
        if(root==null)
         return;
        getKthSmallest(root.left,k);
        if(pq.size()==k){
            return;
        }else{
            pq.add(root.val);
        }
        getKthSmallest(root.right,k);
    }
}