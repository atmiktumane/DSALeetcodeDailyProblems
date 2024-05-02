public class LargestPositiveIntegerWithItsNegative2441 {
    static int findMaxK(int[] arr) {
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

    public static void main(String[] args){
        int[] arr = {-1,10,6,7,-7,1};

        // Brute Force Approach  ->  TC: O(N^2)  ;  SC: O(1)
        int ans1 = findMaxK(arr);
        System.out.println("Largest Positive Integer with Its Negative value in array : "+ ans1);

    }
}
