class Solution {
    public boolean canConstruct(String s, int k) {
        int[] arr=new int[26];
        if(s.length()<k)
         return false;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        int even=0,odd=0;
        for(int i=0;i<26;i++){
            if(arr[i]%2==0)
             even++;
            else
             odd++;
         }
         if(odd>k)
          return false;
       return true;
    } 
}