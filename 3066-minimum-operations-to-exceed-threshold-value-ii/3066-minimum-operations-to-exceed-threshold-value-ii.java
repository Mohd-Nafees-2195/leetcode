class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Integer> q=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        int ans=0;
        while(q.size()>=2&&q.peek()<k){
            ans++;
            int x=q.poll();
            int y=q.poll();
            q.add(2*Math.min(x,y)+Math.max(x,y));
        }
        return ans;
    }
}