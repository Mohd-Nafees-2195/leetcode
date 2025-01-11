class Solution {
    public boolean canConstruct(String s, int k) {
        int[] arr=new int[26];
        if(s.length()<k)
         return false;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
            count+=arr[i]%k;
        }
        return count<=k;
    } 
}