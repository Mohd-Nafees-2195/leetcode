class Solution {
    public int differenceOfSums(int n, int m) {
        int sum=(n*(n+1))/2;
        int num2=0;
        for(int i=m;i<=n;i+=m){
            num2+=i;
        }
        int num1=sum-num2;;
        return num1-num2;
    }
}