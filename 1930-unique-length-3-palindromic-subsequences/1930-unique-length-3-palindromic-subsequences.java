class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0,n=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(s.charAt(i));
        }
        for(char ch:set){
            int l=-1,r=-1;
            for(int i=0;i<n;i++){
                if(ch==s.charAt(i)){
                    if(l==-1)
                     l=i;
                    r=i;
                }
            }
            if(l!=r){
                Set<Character> set1=new HashSet<>();
                for(int i=l+1;i<r;i++){
                    set1.add(s.charAt(i));
                }
                ans+=set1.size();
            }
        }
        return ans;
    }
}