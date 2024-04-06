public class MinRemoveToMakeValidParenthesis1249 {

    static String minRemoveToMakeValid(String s) {
        int n = s.length();

        String temp = "";
        int open = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                open++;
                temp += s.charAt(i);
            }
            else if(s.charAt(i) == ')'){
                if(open>0){
                    open--;
                    temp += s.charAt(i);
                }
            }
            else{
                temp += s.charAt(i);
            }
        }

        String res = "";

        for(int i=temp.length()-1; i>=0; i--){
            if(temp.charAt(i)=='(' && open>0){
                open--;
            }
            else{
                res += temp.charAt(i);
            }
        }

        // reverse the res
        String final_result = "";
        for(int i=res.length()-1; i>=0; i--){
            final_result += res.charAt(i);
        }
        return final_result;

    }

    public static void main(String[] args) {
        String str = "lee(t(c)o)de)";

        String ans = minRemoveToMakeValid(str);

        System.out.println("String with Valid Parenthesis : "+ ans);

    }
}
