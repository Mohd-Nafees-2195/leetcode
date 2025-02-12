class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            int num=nums[i],sum=0;
            while(num!=0){
                sum+=num%10;
                num=num/10;
            }
            if(map.containsKey(sum)){
                ans=Math.max(ans,nums[i]+map.get(sum));
            }else{
                map.put(sum,nums[i]);
            }
        }
        if(ans==0)
         return -1;
        return ans;
    }
}