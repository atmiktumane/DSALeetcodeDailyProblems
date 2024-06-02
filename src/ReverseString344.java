public class ReverseString344 {
    static void reverseString(char[] s) {
        int size = s.length;

        if(size==1) return ;

        int i=0, j=size-1;

        while(i<j){
            //swap elements at i and j
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }

        return;
    }

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};

        // Optimal Solution : TC: O(N) ; SC: O(1)
        reverseString(s);

        // print character array 's'
        for(int i=0; i<s.length; i++){
            System.out.print(s[i]+" ");
        }
        System.out.println();

    }
}
