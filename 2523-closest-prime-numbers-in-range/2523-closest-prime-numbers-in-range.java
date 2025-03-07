class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] ceive=new int[1000001];
        for(int i=1;i<1000001;i++){
            ceive[i]=i;
        }
        ceive[1]=1;
        for(int i=2;i*i<1000001;i++){
            if(ceive[i]!=0){
                for(int j=i;i*j<1000001;j++){
                    ceive[i*j]=0;
                }
            }
        }
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int min=Integer.MAX_VALUE;
        for(int i=left;i<right;i++){
            while(i<right&&ceive[i]==0){
                i++;
            }
            int j=i+1;
            while(j<=right&&ceive[j]==0){
                j++;
            }
            if(i<=right&&j<=right){
                if(ceive[j]-ceive[i]<min){
                    ans[0]=ceive[i];
                    ans[1]=ceive[j];
                    min=ceive[j]-ceive[i];
                }
            }
        }
        return ans;
    }
}