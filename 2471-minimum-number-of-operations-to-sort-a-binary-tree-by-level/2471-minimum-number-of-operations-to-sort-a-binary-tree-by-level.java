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
    public int minimumOperations(TreeNode root) {
        //nt ans=0;
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null){
                if(!q.isEmpty())
                 q.add(null);
                int[] arr=list.stream().mapToInt(Integer::intValue).toArray();
                getMinSwap(arr,0,list.size()-1);
                // for(int i=0;i<list.size();i++){
                //     System.out.print(arr[i]+" ");
                // }
                // System.out.println();
                list.clear();
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
    public void getMinSwap(int[] arr,int l,int r){
        int n=arr.length;
        //int ans=0;
        if(l==r){
            return;
        }
        int mid=(l+r)/2;
        getMinSwap(arr,l,mid);
        getMinSwap(arr,mid+1,r);
        merge(arr,l,mid,r);
        //return ans;
    }
    public void merge(int[] arr,int l,int mid,int r){
        int n1=mid-l+1;
        int n2=r-mid;
        //int ans=0;
        int[] arr1=new int[n1];
        int[] arr2=new int[n2];
        int i=l,j=0;
        while(j<n1){
            arr1[j]=arr[i];
            i++;j++;
        }
        j=0;
        while(j<n2){
            arr2[j]=arr[i];
            i++;j++;
        }
        i=0;j=0;
        while(i<n1&&j<n2){
            if(arr1[i]>arr2[j]){
                if(n1==1||n2==1)
                 ans++;
                System.out.println(arr1[i]+" - "+arr2[j]);
                arr[l++]=arr2[j++];
            }else {
                arr[l++]=arr1[i++];
            }
        }
        while(i<n1){
            arr[l++]=arr1[i++];
        }
        while(j<n2){
            arr[l++]=arr2[j++];
        }
        //return ans;
    }
}