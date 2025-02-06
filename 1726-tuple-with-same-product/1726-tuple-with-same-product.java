class Solution {
    public int tupleSameProduct(int[] nums) {
        int n=nums.length;
        if(n<4)
         return 0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int ans=0;
        for(int key:map.keySet()){
            int num=map.get(key);
            if(num>1){
                int count=(num*(num-1))/2;
                ans+=count*8;
            }
        }
        return ans;
    }
}