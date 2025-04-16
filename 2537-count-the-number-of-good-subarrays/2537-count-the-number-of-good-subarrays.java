class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        long ans=0;
        for(int i=0,j=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                count+=map.get(nums[i]);
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                while(j<i&&count>=k){
                    ans++;
                    if(map.get(nums[j])==1){
                        map.remove(nums[j]);
                    }else{
                        map.put(nums[j],map.getOrDefault(nums[j],0)-1);
                        count-=map.get(nums[j]);
                        ans+=nums.length-1-i;
                    }
                    j++;
                }
            }else{
                map.put(nums[i],1);
            }
        }
        return ans;
    }
}