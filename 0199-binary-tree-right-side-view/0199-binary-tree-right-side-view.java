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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
         return ans;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null){
                if(q.isEmpty())
                 break;
                else
                 q.add(null);
                continue;
            }
            if(q.peek()==null){
                ans.add(temp.val);
            }
            if(temp.left!=null)
             q.add(temp.left);
            if(temp.right!=null)
             q.add(temp.right);
        }
        return ans;
    }
}