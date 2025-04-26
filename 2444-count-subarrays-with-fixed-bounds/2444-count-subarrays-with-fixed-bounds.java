class Solution {
  
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0,n=nums.length;
        int minInd=-1,maxInd=-1,LB=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==minK) minInd=i;
            if(nums[i]==maxK) maxInd=i;
            if(nums[i]<minK||nums[i]>maxK){
                LB=i;
            }
            if(minInd!=-1&&maxInd!=-1){
                int small=Math.min(minInd,maxInd);
                if((small-LB)>0)
                 ans+=(small-LB);
                
            }
        }
        return ans;
    }
}