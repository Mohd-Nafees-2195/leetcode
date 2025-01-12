class Solution {
    public boolean canBeValid(String s, String locked) {
        int lcount=0,rcount=0;
        int n=s.length();
        if(n%2!=0)
         return false;
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'||s.charAt(i)=='('){
                lcount++;
            }else{
                rcount++;
            }
            if(rcount>lcount)
             return false;
        }
        return true;
    }
}