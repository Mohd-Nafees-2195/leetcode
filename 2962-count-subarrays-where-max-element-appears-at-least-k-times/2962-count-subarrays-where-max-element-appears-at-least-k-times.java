class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Arrays.stream(nums).max().getAsInt();
        int count=0,n=nums.length;
        long ans=0,b=-1;
        //System.out.println(max);
        for(int i=0,j=0;i<n;i++){
            if(nums[i]==max) count++;
            if(count>=k){
                // ans+=n-i-1;
                while(j<i&&nums[j]!=max){
                    j++;
                }
                ans+=j-b+1;
                b=j;
                j=i;
                // ans+=j;
            }
        }
        return ans;
    }
}