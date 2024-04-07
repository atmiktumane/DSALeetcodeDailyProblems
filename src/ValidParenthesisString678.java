// Question : 678. Valid Parenthesis String
// TC : O(2N)
// SC : O(1)

import java.util.Stack;

public class ValidParenthesisString678 {

    static boolean checkValidStringBetter(String s) {
        int n = s.length();

        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> asterikSt = new Stack<>();

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                openSt.push(i);
            }
            else if(s.charAt(i) == '*'){
                asterikSt.push(i);
            }
            else{
                if(!openSt.isEmpty()){
                    openSt.pop();
                }
                else if(!asterikSt.isEmpty()){
                    asterikSt.pop();
                }
                else{
                    return false;
                }
            }
        }

        if(openSt.isEmpty()){
            return true;
        }
        else{
            while(!openSt.isEmpty()){
                if(asterikSt.isEmpty()){
                    return false;
                }
                else{
                    if(openSt.peek() < asterikSt.peek()){
                        openSt.pop();
                        asterikSt.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
    static boolean checkValidStringOptimal(String s) {
        int n = s.length();

        int openCount = 0;
        int closeCount = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                openCount++;
            }
            else{
                openCount--;
                if(openCount<0) return false;
            }
        }

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)==')' || s.charAt(i)=='*'){
                closeCount++;
            }
            else{
                closeCount--;
                if(closeCount<0) return false;
            }
        }

        if(openCount<0 || closeCount<0){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "(*))";

        // Better Solution -> Using 2 Stacks  -> TC: O(2N)  ;  SC: O(2N)
        boolean res1 = checkValidStringBetter(s);
        if(res1==true){
            System.out.println("String is Valid");
        }
        else{
            System.out.println("String is Not Valid");
        }


        // Optimal Solution -> Using 2 variables (openCount, closeCount)  -> TC: O(2N)  ; SC: O(1)
        boolean res2 = checkValidStringOptimal(s);

        if(res2==true){
            System.out.println("String is Valid");
        }
        else{
            System.out.println("String is Not Valid");
        }

    }
}
