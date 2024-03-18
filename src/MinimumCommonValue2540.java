// Question. 2540 : Minimum Common Value
// Explaination : Given 2 input arrays, find common value in both arrays which is minimum.
// TC : O(M+N)
// SC : O(1)

import java.util.HashSet;

public class MinimumCommonValue2540 {

    static int betterApproachHashSet(int[] arr1, int[] arr2, int m, int n){
        HashSet<Integer> set1 = new HashSet<>();

        // add all elements of arr1 in Set
        for(int i=0; i<m; i++){
            set1.add(arr1[i]);
        }

        // Compare all elements of arr2 with Set elements
        for(int j=0; j<n; j++){
            if( set1.contains(arr2[j]) ){
                return arr2[j];
            }
        }

        return -1;
    }

    static int optimalApproach2Pointers(int[] arr1, int[] arr2, int m, int n){
        int i=0, j=0;

        while(i<m && j<n){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else return arr1[i];
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr1 = {1,2,3,6};
        int[] arr2 = {2,3,4,5};

        int m = arr1.length;
        int n = arr2.length;

        // edge case
        if(m==0 || n==0){
            System.out.println(-1);  // return -1;
            return;
        }

        int betterAns = betterApproachHashSet(arr1, arr2, m, n);
        System.out.println(betterAns);

        int optimalAns = optimalApproach2Pointers(arr1, arr2, m, n);
        System.out.println(optimalAns);
    }
}
