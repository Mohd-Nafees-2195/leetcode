class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] arr=new int[17];
        arr[0]=1;
        arr[1]=3;
        for(int i=2;i<17;i++){
            arr[i]=arr[i-1]*3;
        }
        for(int i=16;i>=0;i--){
            if(arr[i]==n)
                return true;
            if(arr[i]<n)
                n=n-arr[i];
        }
        return false;
    }
}