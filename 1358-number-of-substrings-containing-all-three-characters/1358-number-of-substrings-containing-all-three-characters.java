class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr=new int[3];
        int i=0,j=0,ans=0,n=s.length();
        while(i<n){
            arr[s.charAt(i)-'a']++;
            while(arr[0]>0&&arr[1]>0&&arr[2]>0){
                ans+=n-i;
                arr[s.charAt(j)-'a']--;
                j++;
            }
            i++;
        }
        return ans;
    }
}