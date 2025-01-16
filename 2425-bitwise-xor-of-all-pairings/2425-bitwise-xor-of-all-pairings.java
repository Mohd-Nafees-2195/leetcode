class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=0,xor2=0;
        int n1=nums1.length,n2=nums2.length;
        for(int i=0;i<n2;i++){
            xor2=xor2^nums2[i];
        }
        for(int i=0;i<n1;i++){
            xor1=xor1^nums1[i];
        }
        if(n1%2==0&&n2%2==0)
         return 0;
        else if(n1%2==0&&n2%2!=0)
         return xor1;
        else if(n1%2!=0&&n2%2==0)
        return xor2;
        else
         return xor1^xor2;
    }
}