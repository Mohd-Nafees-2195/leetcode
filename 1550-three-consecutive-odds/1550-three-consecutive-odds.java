class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        if(n<3) return false;
        for(int i=0;i<n-2;i++){
            int cnt=0;
            if((arr[i]&1)==1)cnt++;
            if((arr[i+1]&1)==1)cnt++;
            if((arr[i+2]&1)==1)cnt++;
            if(cnt==3) return true;
        }
        return false;
    }
}