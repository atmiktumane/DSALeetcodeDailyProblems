import java.util.HashSet;

public class LongestPalindrome409 {
    static int longestPalindrome(String s){
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
    public static void main(String[] args){
        String str = "abccccdd";

        // Optimal Solution 1: HashSet ->  TC: O(N) ; SC: O(N)
        int ans = longestPalindrome(str);
        System.out.println("Length of Longest Palindrome that can be built : "+ ans);
    }
}
