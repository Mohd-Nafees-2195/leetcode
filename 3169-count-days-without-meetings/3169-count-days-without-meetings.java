class Solution {
    public int countDays(int days, int[][] meetings) {
        boolean[] full=new boolean[days];
        for(int i=0;i<meetings.length;i++){
            int[] arr=meetings[i];
            for(int j=arr[0]-1;j<arr[1];j++){
                full[j]=true;
            }
        }
        int ans=0;
        for(int i=0;i<days;i++){
            if(!full[i])
             ans++;
        }
        return ans;
    }
}