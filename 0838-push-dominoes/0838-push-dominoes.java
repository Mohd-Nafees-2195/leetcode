class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr=dominoes.toCharArray();
        char[] pre=dominoes.toCharArray();
        int n=dominoes.length();
        int i=0,j=n-2;
        while(j>=0){
            if(pre[j+1]!='.'&&pre[j]=='.')
             pre[j]=pre[j+1];
            j--;
        }
        while(i<n){
            if(dominoes.charAt(i)=='R'){
                int k=i+1;
                while(k<n&&dominoes.charAt(k)=='.'){
                    k++;
                }
                if(k<n&&dominoes.charAt(k)=='L'){
                    j=k;
                    i++;j--;
                    while(i<j){
                        if(i-1>0)
                         arr[i]=arr[i-1];
                        if(j+1<n)
                         arr[j]=arr[j+1];
                        i++;j--;
                    }
                    i=k+1;
                }else{
                    i++;
                    while(i<n&&dominoes.charAt(i)=='.'){arr[i]=arr[i-1];i++;}
                }
            }else if(dominoes.charAt(i)=='L'){
                int k=i-1;
                while(k>=0&&dominoes.charAt(k)=='.'){
                    arr[k]=arr[k+1];k--;
                }
                i++;
            }else{
                i++;
            }
        }
        return new String(arr);
    }
}