public class ReversePrefixOfWord2000 {
    static String reverseGivenWord(String str){
        char[] arr = str.toCharArray();
        int i=0;
        int j = str.length()-1;

        while(i<j){
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;

            i++;
            j--;
        }

        String s = new String(arr);
        return s;
    }
    static String reversePrefix(String word, char ch){
        int n = word.length();

        String res = "";

        for(int i=0; i<n; i++){
            if(ch == word.charAt(i)){
                res += reverseGivenWord(word.substring(0, i+1));
                if(i+1<n){
                    res += word.substring(i+1, n);
                }
                return res;
            }


        }

        return word;
    }

    public static void main(String[] args){
        String word = "xyxzxe";
        char ch = 'z';

        // TC: O(N*N/2) ;  SC: O(1)
        String ans = reversePrefix(word, ch);

        System.out.println(ans);

    }
}
