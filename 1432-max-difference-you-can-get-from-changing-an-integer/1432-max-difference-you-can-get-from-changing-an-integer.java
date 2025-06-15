class Solution {
    public int maxDiff(int num) {
        String str=num+"";
        int i=0;
        char flag=getChar(str,'9');
        int ind=flag-'0';
        //System.out.println(ind);
        String num1=getNum(str,str.charAt(ind),'9');
        flag=getChar(str,'1');
        ind=flag-'0';
       // System.out.println(ind);
        String num2="";
        if(flag=='0')
          num2=getNum(str,str.charAt(ind),'1');
        else
          num2=getNum(str,str.charAt(ind),'0');
        return Integer.valueOf(num1)-Integer.valueOf(num2);
    }
    public String getNum(String str,char flag,char ch){
        StringBuilder num=new StringBuilder("");
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)==flag&&str.charAt(i)!=ch){
                num.append(ch);
            }else{
                num.append(str.charAt(i));
            }
            i++;
        }
        return num.toString();
    }
    public char getChar(String str,char ch){
        int i=0;
        char flag='0';
        while(i<str.length()){
            if(str.charAt(i)!=ch){
                flag=(i+"").charAt(0);
                break;
            }
            i++;
        }
        return flag;
    }
}