class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                    char ch=stack.pop();
                    if(ch=='('&&s.charAt(i)!=')')
                     return false;
                    else if(ch=='{'&&s.charAt(i)!='}')
                     return false;
                    else if(ch=='['&&s.charAt(i)!=']')
                     return false;
            }
        }
        if(!stack.isEmpty())
         return false;
        return true;
    }
}