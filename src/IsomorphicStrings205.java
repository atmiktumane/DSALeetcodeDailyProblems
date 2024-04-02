// Question : 205. Isomorphic Strings
// TC : O(N)
// SC : O(26)  -> constant space as in HashMap only 26 alphabets will be there at max.

import java.util.HashMap;

public class IsomorphicStrings205 {
    static boolean isIsomorphicOptimal(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m!=n) return false;

        HashMap<Character, Character> mp1 = new HashMap<>();
        HashMap<Character, Character> mp2 = new HashMap<>();

        String temp = "";
        for(int i=0; i<m; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(!mp1.containsKey(ch1)){
                if(mp2.containsKey(ch2) && mp2.get(ch2)!=ch1){
                    return false;
                }
                else if(!mp2.containsKey(ch2)){
                    mp2.put(ch2, ch1);
                }

                mp1.put(ch1, ch2);
                temp += ch2;
            }
            else{
                temp += mp1.get(ch1);
            }
        }

        if(temp.equals(t)) return true;
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        // HashMap Solution
        boolean res = isIsomorphicOptimal(s, t);
        System.out.println(res);
    }
}
