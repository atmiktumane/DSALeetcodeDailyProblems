import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindrome409 {
    static int longestPalindromeOptimal1(String s){
        int n = s.length();
        int res = 0;

        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(set.contains(ch)){
                res += 2;
                boolean removed = set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }

        if(set.size()>0){
            res += 1;
        }

        return res;
    }

    static int longestPalindromeOptimal2(String s){
        int n = s.length();
        int res = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        // store element + occurrence in map
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch, 1);
            }
            else{
                mp.put(ch, mp.get(ch)+1);
            }
        }

        // iterate through map
        for( char key : new HashSet<>(mp.keySet()) ){
            int occurence = mp.get(key);

            if(occurence%2 == 0){ // even
                res += occurence;
                mp.remove(key);
            }
            else{ // odd
                if(occurence>1){
                    res += occurence-1;
                    mp.put(key, 1);
                }
            }
        }

        if(mp.size()>0){
            res += 1;
        }
        return res;
    }
    public static void main(String[] args){
        String str = "abccccdd";

        // Optimal Solution 1: HashSet ->  TC: O(N) ; SC: O(N)
//        int ans = longestPalindromeOptimal1(str);
//        System.out.println("Length of Longest Palindrome that can be built : "+ ans);

        // Optimal Solution 2: HashMap -> TC: O(N) ; SC: O(N)
        int ans2 = longestPalindromeOptimal2(str);
        System.out.println("Length of Longest Palindrome that can be built : "+ ans2);
    }
}
