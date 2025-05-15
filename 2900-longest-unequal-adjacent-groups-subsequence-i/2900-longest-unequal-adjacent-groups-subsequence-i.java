class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
       List<String> ans=new ArrayList<>();
       int n=words.length;
       if(n==1){
         ans.add(words[0]);
         return ans;
       }
       for(int i=1;i<n;i++){
         if(groups[i-1]!=groups[i]){
            ans.add(words[i]);
         }
       }
       return ans;
    }
}