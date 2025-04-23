class Solution {
    public int countLargestGroup(int n) {
        int[] arr=new int[5];
        int f=10;
        for(int i=1;i<5;i++){
            arr[i]=f;
            f=f*10;
        }
        int size=(n+"").length();
        if(size==1) return n;
        return n-(n/arr[size-1])*10+1;
    }
}