// Question : 442. Find All Duplicates in an Array
// TC : O(N)
// SC : O(N) -> HashMap space

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

    static List<Integer> findDuplicatesOptimal(int[] arr) {
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

    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};

        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        // Brute Force Approach -> Nested For Loop   TC : O(N^2)
        ans1 = findDuplicatesBrute(arr);
        System.out.println("All Duplicate elements present in array : " + ans1);

        // Optimal Approach  -> HashMap
        ans = findDuplicatesOptimal(arr);
        System.out.println("All Duplicate elements present in array : " + ans);


    }
}
