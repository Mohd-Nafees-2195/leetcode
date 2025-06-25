class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1=nums1.length,n2=nums2.length;
        Queue<Long> q=new PriorityQueue<Long>((a,b)->(int)(b-a));
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(q.size()<k){
                    q.add((long)nums1[i]*nums2[j]);
                }else{
                    if(q.peek()>=(long)nums1[i]*nums2[j]){
                        q.poll();
                        q.add((long)nums1[i]*nums2[j]);
                    }else{
                        if(nums1[i]>0&&nums2[j]>0) break;
                    };
                }
            }
        }
        return q.peek();
    }
}