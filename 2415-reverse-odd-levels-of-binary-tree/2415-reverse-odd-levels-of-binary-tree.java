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
    public TreeNode reverseOddLevels(TreeNode root) {
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        List<Integer> list=new ArrayList<>();
        stack1.push(root);
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            while(!stack1.isEmpty()){
                TreeNode temp=stack1.pop();
                list.add(temp.val);
                if(temp.left!=null)
                 stack2.push(temp.left);
                if(temp.right!=null)
                 stack2.push(temp.right);
            }
            while(!stack2.isEmpty()){
                TreeNode temp=stack2.pop();
                list.add(temp.val);
                if(temp.right!=null)
                 stack1.push(temp.right);
                if(temp.left!=null)
                 stack1.push(temp.left);
            }
        }
        int i=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            temp.val=list.get(i++);
            if(temp.left!=null)
              q.add(temp.left);
            if(temp.right!=null)
              q.add(temp.right);
        }
        return root;
    }
}