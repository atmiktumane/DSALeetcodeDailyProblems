import java.util.HashMap;

public class SubarrayWithKDifferentIntegers992 {

    static int slidingWindowFn(int[] arr, int k){
        int n = arr.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int i=0, j=0;
        int res = 0;

        while(j<n){
            if(!mp.containsKey(arr[j])){
                mp.put(arr[j], 1);
            }
            else{
                mp.put(arr[j], mp.get(arr[j])+1);
            }

            while(mp.size()>k){
                mp.put(arr[i], mp.get(arr[i])-1);
                if(mp.get(arr[i])==0){
                    mp.remove(arr[i]);
                }
                i++;
            }

            res += j-i+1;
            j++;
        }
        return res;
    }

    static int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length==0 || k==0) return 0;
        int result = slidingWindowFn(nums, k) - slidingWindowFn(nums, k-1);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k=2;

        int ans = subarraysWithKDistinct(nums, k);

        System.out.println("Total no. of subarrays having exactly K different integers : "+ans);

    }
}
