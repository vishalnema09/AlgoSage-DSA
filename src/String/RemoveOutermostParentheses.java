package String;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for(char x:s.toCharArray()){
            temp.append(x);
            if(x=='(')count++;
            else count--;
            if(count==0){
                res.append(temp.substring(1,temp.length()-1));
                temp.setLength(0);
            }
        }
        return res.toString();
    }
}
