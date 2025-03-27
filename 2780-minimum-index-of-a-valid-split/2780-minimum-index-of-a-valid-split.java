class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> pre=new HashMap<>();
        Map<Integer,Integer> next=new HashMap<>();
        int n=nums.size();
        for(int i=0;i<n;i++){
            next.put(nums.get(i),next.getOrDefault(nums.get(i),0)+1);
        }
        for(int i=0;i<n;i++){
            pre.put(nums.get(i),pre.getOrDefault(nums.get(i),0)+1);
            next.put(nums.get(i),next.getOrDefault(nums.get(i),0)-1);
            if(next.get(nums.get(i))<=0){
                next.remove(nums.get(i));
            }
            if(next.containsKey(nums.get(i))){
                if(pre.get(nums.get(i))>(i+1)/2&&next.get(nums.get(i))>(n-i-1)/2){
                    return i;
                }
            }
        }
        return -1;
    }
}