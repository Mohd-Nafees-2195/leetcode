class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set=new HashSet<>();
        int n=A.length;
        int[] ans=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(set.contains(A[i]))
              count++;
            else
             set.add(A[i]);
            if(set.contains(B[i]))
             count++;
            else
             set.add(B[i]);
            ans[i]=count;
        }
        return ans;        
    }
}