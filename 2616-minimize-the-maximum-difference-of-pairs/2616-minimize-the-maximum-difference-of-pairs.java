class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        if(p<=0) return 0;
        Queue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int diff=Math.abs(nums[i]-nums[j]);
                if(q.size()<p){
                    q.add(diff);
                }else{
                    if(q.peek()>diff){
                        q.poll();
                        q.add(diff);
                    }
                }
            }
        }
        return q.peek();
    }
}