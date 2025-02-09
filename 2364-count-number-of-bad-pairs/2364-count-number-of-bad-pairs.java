class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long goodPair=0;
        Map<Integer,Long> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(i-nums[i])){
                goodPair+=map.get(i-nums[i]);
                map.replace(i-nums[i],map.get(i-nums[i])+1l);
            }else{
                map.put(i-nums[i],1l);
            }
        }
        if(n%2==0){
            return ((n/2l)*(n-1))-goodPair;
        }else{
            return (n*((n-1)/2l))-goodPair;
        }
    }
}