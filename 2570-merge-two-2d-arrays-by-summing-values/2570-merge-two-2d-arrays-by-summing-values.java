class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int n1=nums1.length,n2=nums2.length;
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(nums1[i][0]<nums2[j][0]){
                map.put(nums1[i][0],nums1[i][1]);
                i++;
            }else if(nums1[i][0]>nums2[j][0]){
                map.put(nums2[j][0],nums2[j][1]);
                j++;
            }else{
                map.put(nums1[i][0],nums1[i][1]+nums2[j][1]);
                i++;j++;
            }
        }
        while(i<n1){
            map.put(nums1[i][0],nums1[i][1]);
            i++;
        }
        while(j<n2){
            map.put(nums2[j][0],nums2[j][1]);
            j++;
        }
        int[][] ans=new int[map.size()][2];
        i=0;
        for(int ids:map.keySet()){
            ans[i][0]=ids;
            ans[i][1]=map.get(ids);
            i++;
        }
        return ans;
    }
}