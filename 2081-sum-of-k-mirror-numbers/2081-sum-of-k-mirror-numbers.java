class Solution {
    public long kMirror(int k, int n) {
        long ans=0;
        int len=1;
        while(n>0){
            int helfLen=(len+1)/2;
            long minVal=(long)Math.pow(10,helfLen-1);
            long maxVal=minVal*10-1;
            for(long i=minVal;i<=maxVal;i++){
                String fHalf=String.valueOf(i);
                String sHalf=new StringBuilder(fHalf).reverse().toString();
                String pal=len%2==0?(fHalf+sHalf):(fHalf+sHalf.substring(1));
                long palNum=Long.valueOf(pal);
                String baseKNum=getBaseKNum(palNum,k);
                if(isPalindrom(baseKNum)){
                    ans+=palNum;
                    n--;
                    if(n==0) break;
                }
            }
            len++;
        }
        return ans;
    }
    public String getBaseKNum(long num,int k){
        StringBuilder str=new StringBuilder("");
        if(num==0) return "0";
        while(num>0){
            long r=num%k;
            str.append(r);
            num=num/k;
        }
       return str.reverse().toString();
    }
    public boolean isPalindrom(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}