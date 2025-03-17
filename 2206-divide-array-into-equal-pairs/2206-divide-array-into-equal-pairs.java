class Solution {
    public boolean divideArray(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        if(xor!=0)
         return false;
        return true;
    }
}