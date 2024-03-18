import java.util.HashMap;

public class CountElementWithMaxFreq3005 {
    static void bruteForceSolution(int[] arr, int n){
        int maxFreq = Integer.MIN_VALUE, count=0;

        // find max. freq
        for(int i=0; i<n-1; i++){
            int freq=1;
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]) freq++;

                maxFreq = Math.max(maxFreq, freq);
            }
        }

        for(int i=0; i<n-1; i++){
            int freqq=1;
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]) freqq++;

                if(freqq == maxFreq){
                    count += freqq;
                    break;
                }
            }
        }

        System.out.println("result : "+count);

    }

    static void optimalSolution(int[] arr, int n){
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else{
                mp.put(arr[i], 1);
            }
        }

        int maxFreq = Integer.MIN_VALUE;
        int res = 0;

        for(int k : mp.keySet()){
            maxFreq = Math.max(maxFreq, mp.get(k));
        }

        for(int key : mp.keySet()){
            if(mp.get(key) == maxFreq){
                res += maxFreq;
            }
        }

        System.out.println("result : "+res);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4};
        int n = arr.length;

        bruteForceSolution(arr, n);

        optimalSolution(arr, n); // using HashMap
    }
}
