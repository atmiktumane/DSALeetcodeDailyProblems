import java.util.HashMap;

public class LongestSubarrayWithAtmostKFreq2958 {
    static int maxSubarrayLengthOptimal(int[] arr, int k) {
        int n = arr.length;

        if(n==0) return 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        int i=0, j=0;
        int index= i;

        while(j<n){
            if(!mp.containsKey(arr[j])){
                mp.put(arr[j], 1);
            }
            else{
                mp.put( arr[j], mp.get(arr[j])+1 );
            }

            while(mp.get(arr[j])>k && i<=j){
                mp.put(arr[i], mp.get(arr[i])-1);
                if(mp.get(arr[i]) == 0){
                    mp.remove(arr[i]);
                }
                i++;
            }

            len = j-i+1;
            maxLen = Math.max(maxLen, len);
            j++;
        }

        return maxLen;

    }


    public static void main(String[] args){
        int[] nums = {1,2,3,1,2,3,1,2};
        int k=2;

        int res = maxSubarrayLengthOptimal(nums, k);
        System.out.println("Length of Longest subarray with Atmost K freq : "+res);
    }
}
