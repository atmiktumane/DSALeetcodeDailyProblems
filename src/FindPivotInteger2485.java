public class FindPivotInteger2485 {
    static int findPivotFnPrefixSuffix(int n){
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = 1;

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+i+1;
        }

        suffixSum[n-1] = n;
        for(int i=n-2; i>=0; i--){
            suffixSum[i] = suffixSum[i+1]+i+1;
        }

        for(int i=0; i<n; i++){
            if(prefixSum[i] == suffixSum[i]){
                return i+1;
            }
        }
        return -1;
    }

    static int getSum(int x){
        return (x*(x+1))/2;
    }

    static int findPivotFnFormula(int n){
        int ans = -1;
        for(int i=1; i<=n; i++){
            int s1 = getSum(i);
            int s2 = getSum(n)-getSum(i-1);

            if(s1==s2) return i;
        }

        return ans;
    }
    public static void main(String[] args){
        int n = 8;

        // Prefix Suffix Solution
//        int pivot = findPivotFnPrefixSuffix(n);

        // Sum of first n numbers formula -> n(n+1)/2
        int pivot1 = findPivotFnFormula(n);
        System.out.println(pivot1);
    }
}
