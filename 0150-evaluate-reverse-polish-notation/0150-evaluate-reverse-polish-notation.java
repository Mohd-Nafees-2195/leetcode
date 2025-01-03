class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack=new Stack<>();
      for(int i=0;i<tokens.length;i++){
         if(isOperator(tokens[i])){
            int b=stack.pop();
            int a=stack.pop();
            stack.push(evaluate(a,b,tokens[i]));
         }else{
            stack.push(Integer.parseInt(tokens[i]));
        }
      }
      return stack.peek();
    }
    public boolean isOperator(String str){
        if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))
         return true;
        return false;
    } 
    public int evaluate(int a,int b,String ope){
     switch(ope){
        case "+" :
            return a+b;
        case "-" :
            return a-b;
        case "*" :
            return a*b;
        case "/" :
           return a/b;
        default:
         return 1;
     }
   }
}