class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr=new int[26];
        char[] alpha = new char[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char) ('a' + i);
        }
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        StringBuilder str=new StringBuilder();
        for(int i=25;i>=0;i--){
            if(arr[i]!=0){
                if(arr[i]<=repeatLimit){
                    while(arr[i]!=0){
                        str.append(alpha[i]);
                        arr[i]--;
                    }
                }else{
                    int j=repeatLimit;
                    while(j!=0){
                        str.append(alpha[i]);
                        j--;
                    }
                    arr[i]=arr[i]-repeatLimit;
                    j=i-1;
                    while(j>=0&&arr[j]==0){
                        j--;
                    }
                    if(j<0)
                     return str.toString();
                    else{
                        str.append(alpha[j]);
                        arr[j]--;
                        i++;
                    }
                }
            }
        }
        return str.toString();
    }
}