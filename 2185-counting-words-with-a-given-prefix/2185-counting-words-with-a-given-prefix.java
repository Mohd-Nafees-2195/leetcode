class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans=0,n=pref.length();
        for(int i=0;i<words.length;i++){
            int n1=words[i].length();
            if(n<=n1){
                if(pref.charAt(0)==words[i].charAt(0)){
                    if(words[i].substring(0,n).equals(pref)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}