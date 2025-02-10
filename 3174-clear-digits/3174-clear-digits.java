class Solution {
    public String clearDigits(String s) {
        int n=s.length();
        int i=0;
        StringBuilder ans=new StringBuilder("");
        char[] arr=s.toCharArray();
        while(i<n){
            if(arr[i]>='0'&&arr[i]<='9'){
               int j=i-1;
               arr[i]='*';
               while(j>=0&&arr[j]=='*'){
                 j--;
               }
               if(j>=0)
                arr[j]='*';
            }
            i++;
        }
        i=0;
        while(i<n){
            if(arr[i]!='*'){
                ans.append(arr[i]);
            }
            i++;
        }
        return ans.toString();
    }
}