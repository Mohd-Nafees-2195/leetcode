class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans=0;
        int n=words.length;
        for(int i=0;i<n;i++){
            int n1=words[i].length();
            for(int j=i+1;j<n;j++){
                int n2=words[j].length();
                if(n1<=n2){
    if(words[j].charAt(0)==words[i].charAt(0)&&words[j].charAt(n2-1)==words[i].charAt(n1-1)){
if(words[j].substring(0,n1).equals(words[i])&&words[j].substring(n2-n1,n2).equals(words[i])){
                        ans++;
                    } 
                  }
                }
            }
        }
        return ans;
    }
}