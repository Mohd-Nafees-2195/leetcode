class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==key) list.add(i);
        }
        for(int i=0;i<n;i++){
            int j=0;
            while(j<list.size()){
                if(Math.abs(i-list.get(j++))<=k){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}