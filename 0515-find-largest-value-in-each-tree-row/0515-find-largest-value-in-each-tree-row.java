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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
         return list;
        q.add(root);
        q.add(null);
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                if(!q.isEmpty())
                 q.add(null);
                list.add(max);
                max=Integer.MIN_VALUE;
            }else{
                max=Math.max(max,node.val);
                if(node.left!=null)
                 q.add(node.left);
                if(node.right!=null)
                 q.add(node.right);
            }
        }
        return list;
    }
}