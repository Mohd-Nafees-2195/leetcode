class Solution {
    public int minOperations(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int min=10000;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            min=Math.min(min,nums[i]);
        }
        if(min<k)
         return -1;
        Queue<int[]> q=new PriorityQueue<>((p1,p2)->p1[0]-p2[0]);
        map.forEach((key,val)->{
            q.add(new int[]{key,val});
        });
        int[] arr=q.poll();
        int ans=q.size();
        if(arr[0]==k)
         return ans;
        else
         return ans+1;
    }
}