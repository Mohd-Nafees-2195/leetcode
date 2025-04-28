class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        int i=0,j=0;
        long sum=0;
        int n=nums.length;
        while(i<n){
            sum+=nums[i];
            long score=sum*(i+1);
            if(score<k)
             ans++;
            else{
                while(j<i){
                    sum-=nums[j++];
                    score=sum*(i-j+1);
                    if(score<k){
                        ans++;
                        break;
                    }
                }
            }
            i++;
        }
        while(j<n){
            sum-=nums[j++];
            long score=sum*(i-j+1);
            if(score<k){
                ans++;
            }
        }
        return ans;
    }
}