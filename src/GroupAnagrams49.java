import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    static List<List<String>> groupAnagramsBetter(String[] str) {
        int n = str.length;

        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String temp = str[i];
            char[] chs = temp.toCharArray(); // convert string to character array

            Arrays.sort(chs); // sort the character array
            String s = new String(chs); // convert char array to String

            if(!mp.containsKey(s)){
                mp.put(s, new ArrayList<>());
            }

            List<String> ls = mp.get(s);
            ls.add(temp);
            mp.put(s, ls);
        }

        for(String key: mp.keySet()){
            List<String> ls = mp.get(key);
            res.add(ls);
        }

        return res;
    }

    static String getSortedWord(String word){
        int[] letters = new int[26];

        for(int i=0; i<26; i++){
            letters[i] = 0;
        }

        // increase the frequency of each char in word
        for(Character ch : word.toCharArray()){
            letters[ch-'a']++;
        }

        String s = "";

        for(int i=0; i<26; i++){
            while(letters[i]>0){
                char ch = (char) (i+'a');
                s += ch;

                letters[i]--;
            }
        }

        return s;
    }

    static List<List<String>> groupAnagramsOptimal(String[] str) {
        int n = str.length;

        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String word = str[i];

            String s = getSortedWord(word);


            if(!mp.containsKey(s)){
                mp.put(s, new ArrayList<>());
            }

            List<String> ls = mp.get(s);
            ls.add(word);
            mp.put(s, ls);
        }

        for(String key: mp.keySet()){
            List<String> ls = mp.get(key);
            res.add(ls);
        }

        return res;
    }

    public static void main(String[] args){
        String[] str = {"eat","tea","tan","ate","nat","bat"};

        // Better Approach : TC: O(N* KlogK)  ;  SC: O(N) -> hashmap
//        List<List<String>> ans = groupAnagramsBetter(str);
//        System.out.println(ans);

        // Optimal Approach : TC: O(N*K)  ;  SC: O(N) -> hashmap
        List<List<String>> ans = groupAnagramsOptimal(str);
        System.out.println(ans);
    }
}
