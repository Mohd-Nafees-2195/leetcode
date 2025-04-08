class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length,ans=0;
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(nums[i])){
                if((i+1)%3==0){
                    ans=(i+1)/3;
                }else{
                  ans=(i+1)/3;
                  ans++;
                }
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}