class Solution {
    public String countAndSay(int n) {
        return solve(n);
    }
    public String solve(int n){
        if(n==1)
         return "1";
        String str=solve(n-1);
        StringBuilder ans=new StringBuilder("");
        int len=str.length();
        for(int i=0;i<len;){
            int count=1;  //i=2
            int j=i+1;   //j=3
            while(j<len){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                    j++;
                }else
                  break;
            }
            ans.append(count+"");
            ans.append(str.charAt(i));
            i=j;
        }
        return ans.toString();
    }
}