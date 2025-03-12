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
class BSTIterator {
    int iterator;
    List<Integer> list;
    public BSTIterator(TreeNode root) {
        this.iterator=0;
        list=new ArrayList<>();
        initialize(list,root);
    }
    
    public int next() {
        iterator++;
        return list.get(iterator-1);
    }
    
    public boolean hasNext() {
        if(iterator==list.size())
         return false;
        return true;
    }
    public void initialize(List<Integer> list,TreeNode root){
        if(root==null)
         return;
        initialize(list,root.left);
        list.add(root.val);
        initialize(list,root.right);
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */