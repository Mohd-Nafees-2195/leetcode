class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<Node> q=new PriorityQueue<>((n1,n2)->{
            if(n1.val==n2.val){
                return n1.ind-n2.ind;
            }else{
                return n1.val-n2.val;
            }
        });

        for(int i=0;i<nums.length;i++){
            q.add(new Node(nums[i],i));
        }
        for(int i=0;i<k;i++){
            Node node=q.poll();
            nums[node.ind]=multiplier*nums[node.ind];
            q.add(new Node(nums[node.ind],node.ind));
        }
        return nums;
    }
    public class Node{
        int val,ind;
        public Node(int val,int ind){
            this.val=val;
            this.ind=ind;
        }
    }
}