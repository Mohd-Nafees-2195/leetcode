class Solution {
    public int minimumRecolors(String blocks, int k) {
        int black=0,white=0;
        int n=blocks.length();
        int ans=k;
        int i=0,j=0;
        while(i<k){
            if(blocks.charAt(i)=='B'){
                black++;
            }else{
                white++;
            }
            i++;
        }
        if(black>=k){
            return 0;
        }else{
            if(ans>white){
                ans=white;
            }
        }
        while(i<n){
            if(black>=k){
                return 0;
            }else{
                if(ans>white){
                    ans=white;
                }
            }
            if(blocks.charAt(i)=='B'){
                black++;
            }else{
                white++;
            }
            if(blocks.charAt(j)=='B'){
                black--;
            }else{
                white--;
            }
            i++;j++;
        }
        return ans;
    }
}