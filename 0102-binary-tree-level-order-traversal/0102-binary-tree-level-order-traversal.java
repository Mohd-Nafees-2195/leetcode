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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
         return ans;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null){
                ans.add(list);
                if(q.isEmpty())
                 break;
                else{
                    list=new ArrayList<>();
                    q.add(null);
                }
            }else{
                list.add(temp.val);
                if(temp.left!=null)
                 q.add(temp.left);
                if(temp.right!=null)
                 q.add(temp.right);
            }
        }
        return ans;
    }
}