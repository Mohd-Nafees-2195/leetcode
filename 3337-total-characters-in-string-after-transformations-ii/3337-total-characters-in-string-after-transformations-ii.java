class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int cnt=0,n=s.length();
        while(t>0){
            for(int i=0;i<n;i++){
                int ind=s.charAt(i)-'a';
                ind=(ind+t-1)%26;
                if(nums.get(ind)>1){
                    cnt+=nums.get(ind)-1;
                }
            }
            t--;
        }
        return n+cnt;
    }
}