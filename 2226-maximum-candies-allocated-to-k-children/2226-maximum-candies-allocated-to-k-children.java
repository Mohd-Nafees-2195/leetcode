class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int ans=0,r=0,l=0;
        for(int i=0;i<n;i++){
            r=Math.max(r,candies[i]);
        }
        while(l<=r){
            int mid=(l+r)/2;
            long sum=0;
            for(int i=0;i<n;i++){
                if(mid!=0)
                 sum+=(candies[i]/mid);
            }
            if(sum>=k){
                l=mid+1;
                ans=mid;
            }else
                r=mid-1;
        }
        return ans;
    }
}