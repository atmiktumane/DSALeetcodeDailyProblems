import java.util.HashMap;

public class BinarySubarraysWithSum930 {
    static int numSubarraysWithSumSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if(n==0) return -1;

        int i=0, j=0, countZeroes=0, result=0, sum=0;

        while(j<n){
            sum+= arr[j];

            while(i<j && (arr[i]==0 || sum>k)){
                if(arr[i]==0)
                    countZeroes++;
                else countZeroes=0;

                sum -= arr[i];
                i++;
            }

            if(sum==k) result += 1+countZeroes;

            j++;
        }
        return result;
    }

    static int numSubarraysWithSumHashMap(int[] arr, int k) {
        int n = arr.length;
        if(n==0) return -1;

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        int sum = 0, res=0;

        for(int i=0; i<n; i++){
            sum += arr[i];

            if(mp.containsKey(sum-k)){
                res += mp.get(sum-k);
            }

            if(!mp.containsKey(sum)){
                mp.put(sum, 1);
            }
            else{
                mp.put(sum, mp.get(sum)+1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {0,0,0,0,0};
        int k = 0;

        // HashMap approach
        int ans = numSubarraysWithSumHashMap(arr, k);
        System.out.println(ans);

        // sliding window approach
//        int ans = numSubarraysWithSumSlidingWindow(arr, k);
//        System.out.println(ans);
    }
}
