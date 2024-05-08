import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks506 {
    static void reverseArray(int[] arr){
        int i=0, j=arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[] arr = new int[n];

        // store all ele from score[] to arr[]
        for(int i=0; i<n; i++){
            arr[i] = score[i];
        }

        // sort arr[] in descending order : sort + reverse
        Arrays.sort(arr);

        reverseArray(arr);

        // HashMap which stores ele + "rank"
        HashMap<Integer, String> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            // convert int to String using concatenation
            int a = i+1;
            String str = "" + a;

            mp.put(arr[i], str);
        }

        String[] res = new String[n];

        // Traverse through given score[] and perform operation with respect to HashMap values
        for(int i=0; i<n; i++){
            if(mp.get(score[i]).equals("1")){
                res[i] = "Gold Medal";
            }
            else if(mp.get(score[i]).equals("2")){
                res[i] = "Silver Medal";
            }
            else if(mp.get(score[i]).equals("3")){
                res[i] = "Bronze Medal";
            }
            else{
                res[i] = mp.get(score[i]);
            }
        }
        return res;
    }

    static String[] findRelativeRanksBetter(int[] score) {
        int n = score.length;

        // HashMap which stores ele + original index
        HashMap<Integer, Integer> mp = new HashMap<>();

        // store ele + index in HashMap
        for(int i=0; i<n; i++){
            mp.put(score[i], i);
        }

        // sort arr[] in descending order : sort + reverse
        Arrays.sort(score);

        reverseArray(score);

        String[] res = new String[n];
        int rank = 0;

        for(int i=0; i<n; i++){
            rank = i+1;

            if(rank == 1){
                res[mp.get(score[i])] = "Gold Medal";
            }
            else if(rank == 2){
                res[mp.get(score[i])] = "Silver Medal";
            }
            else if(rank == 3){
                res[mp.get(score[i])] = "Bronze Medal";
            }
            else{
                res[mp.get(score[i])] = "" + rank;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};

        // Better Approach 1 : Using Sorting + HashMap + Extra Array -> TC: O(NLogN) ; SC: O(N)
//        String[] ans1 = findRelativeRanks(score);


        // Better Approach 2 : Using Sorting + HashMap -> TC: O(NLogN) ; SC: O(N)
        String[] ans2 = findRelativeRanksBetter(score);

        for(int i=0; i<score.length; i++){
            System.out.print(ans2[i] + " ");
        }

    }
}
