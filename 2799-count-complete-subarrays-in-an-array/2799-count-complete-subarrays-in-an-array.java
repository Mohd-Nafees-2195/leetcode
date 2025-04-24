class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int i=0,j=0,ans=0;
        while(i<n){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(j<=i&&map.size()==set.size()){
                ans+=n-i;
                map.put(nums[j],map.getOrDefault(nums[j],0)-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                j++;
            }
            i++;
        }
        return ans;
    }
}