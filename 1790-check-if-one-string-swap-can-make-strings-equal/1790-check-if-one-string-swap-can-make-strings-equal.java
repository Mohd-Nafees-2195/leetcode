class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                int j=i;
                while(i<n&&s1.charAt(j)!=s2.charAt(i)){
                    i++;
                }
                if(i==n)
                 return false;
                String str=s2.substring(0,j)+s2.charAt(i)+s2.substring(j+1,i)+s2.charAt(j)+s2.substring(i+1,n);
                System.out.println(str);
                if(s1.equals(str))
                 return true;
                return false;
            }
        }
        return true;
    }
}