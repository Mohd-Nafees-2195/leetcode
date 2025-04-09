class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] arr=new boolean[101];
        for(int num:nums){
            arr[num]=true;
        }
        int ans=0;
        for(int i=0;i<101;i++){
            if(arr[i]&&i>k){
                ans++;
            }
        }
        if(ans==0)
         return -1;
        else
         return ans;
    }
}