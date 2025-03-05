class Solution {
    public long coloredCells(int n) {
        if(n==1)
         return 1;
        long sum=0;
        while(n>1){
            sum+=4*(n-1);
            n--;
        }
        return sum;
    }
}