// Question : 791. Custom Sort String
// TC : O(M+N)
// SC : O(N)  -> for using TreeMap

import java.util.TreeMap;
import java.util.TreeSet;

public class CustomSortString791 {
    public static void main(String[] args){
        String order = "disqyr";
        String s = "iwyrysqrdj";

        int m = order.length();
        int n = s.length();

        TreeMap<Character, Integer> mp = new TreeMap<>();

        // put all characters of String s in TreeMap along with their occurrences
        for(int j=0; j<n; j++){
            if( mp.containsKey(s.charAt(j)) ){
                mp.put(s.charAt(j), mp.get(s.charAt(j))+1);
            }
            else{
                mp.put(s.charAt(j), 1);
            }
        }

        String res = "";

        for(int i=0; i<m; i++){
            char key = order.charAt(i);
            if(mp.containsKey(key) ){
                while(mp.get(key) !=0 ){
                    res += key;
                    mp.put(key, mp.get(key)-1);
                }
                mp.remove(key);
            }
        }

        for(char key: new TreeSet<>(mp.keySet())){
            while(mp.get(key) != 0){
                res += key;
                mp.put(key, mp.get(key)-1);
            }
            mp.remove(key);
        }

        System.out.println("Result : "+res);
    }
}
