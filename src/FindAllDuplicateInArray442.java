// Question : 442. Find All Duplicates in an Array
// TC : O(N)
// SC : O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicateInArray442 {

    static List<Integer> findDuplicatesBrute(int[] arr){
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]){
                    res.add(arr[i]);
                }
            }
        }

        return res;
    }

    static List<Integer> findDuplicatesBetter(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        if(n==0 || n==1) return res;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], 1);
            }
            else{
                mp.put( arr[i], mp.get(arr[i])+1 );
            }
        }

        for(int key: mp.keySet()){
            if(mp.get(key) > 1){
                res.add(key);
            }
        }

        return res;
    }

    static List<Integer> findDuplicatesOptimal(int[] nums){
        int n = nums.length;

        List<Integer> res = new ArrayList<>();

        if(n==0 || n==1) return res;

        for(int i=0; i<n; i++){
            int num = Math.abs(nums[i]);
            int idx = num-1;

            if(nums[idx] <0) res.add(num);
            else{
                nums[idx] *= -1;
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};

        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> ans3 = new ArrayList<>();

        // Brute Force Approach -> Nested For Loop   TC : O(N^2)
        ans1 = findDuplicatesBrute(arr);
        System.out.println("All Duplicate elements present in array : " + ans1);

        // Better Approach  -> HashMap      -> TC: O(N)  ;  SC: O(N)
        ans2 = findDuplicatesBetter(arr);
        System.out.println("All Duplicate elements present in array : " + ans2);

        // Optimal Approach  -> elements in range [1,n], mark visited elements to -ve
        ans3 = findDuplicatesOptimal(arr); // ->  TC: O(N)  ;  SC: O(1)
        System.out.println("All Duplicate elements present in array : " + ans3);
    }
}
