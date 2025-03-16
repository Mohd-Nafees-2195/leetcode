class Solution {
    public long repairCars(int[] ranks, int cars) {
        long r=0,l=1;
        int n=ranks.length;
        for(int i=0;i<n;i++){
            r=Math.max(r,ranks[i]);
        }
        long div=cars/n;
        r=r*div*div;
        long ans=r;
        while(l<=r){
            long mid=l+(r-l)/2;
            long max=0;
            for(int j=0;j<n;j++){
                max=Math.max(max,ranks[j]*((cars*cars)/mid));
            }
            if(mid>=max){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        return ans;
    }
}