class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(2*arr[i]<=(a+b+c)){
                ans++;
            }
        }
        return ans;
    }
}