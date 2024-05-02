import java.util.Arrays;
import java.util.HashSet;

public class LargestPositiveIntegerWithItsNegative2441 {
    static int findMaxKBrute(int[] arr) {
        int n = arr.length;

        int res = -1;

        if(n==1) return res;

        for(int i=0; i<n; i++){
            if(arr[i]>res && arr[i]>0){
                for(int j=0; j<n; j++){
                    if(arr[j] == (-1*arr[i])){
                        res = arr[i];
                    }
                }
            }
        }
        return res;
    }

    static int findMaxKBetter(int[] arr) {
        int n = arr.length;

        int res = -1;

        if(n==1) return res;

        Arrays.sort(arr);

        int i=0, j=n-1;

        while(i<j){
            if(-arr[i] == arr[j]){
                res = arr[j];
                break;
            }
            else if(-arr[i] < arr[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }

    static int findMaxKOptimal(int[] arr) {
        int n = arr.length;

        int res = -1;

        if(n==1) return res;

        HashSet<Integer> set = new HashSet<>();

        // store all elements in HashSet
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }

        for(int i=0; i<n; i++){
            if(arr[i]>0 && arr[i]>res){
                int num = -arr[i];
                if(set.contains(num)){
                    res = arr[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {-1,10,6,7,-7,1};

        // Brute Force Approach  ->  TC: O(N^2)  ;  SC: O(1)
//        int ans1 = findMaxKBrute(arr);
//        System.out.println("Largest Positive Integer with Its Negative value in array : "+ ans1);

        // Better Approach  -> Sorting + 2 pointer  ->  TC: O(NlogN) ; SC: O(1)
//        int ans2 = findMaxKBetter(arr);
//        System.out.println("Largest Positive Integer with Its Negative value in array : "+ ans2);

        // Optimal Approach -> HashSet  ->  TC: O(N)  ;  SC: O(N)
        int ans3 = findMaxKOptimal(arr);
        System.out.println("Largest Positive Integer with Its Negative value in array : "+ ans3);

    }
}
