import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren3075 {
    static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);

        int decrementCount = 0;
        long res = 0;

        int i=n-1;

        while(i>=0 && k>0){
            if(happiness[i] - decrementCount >=0){
                res += (happiness[i] - decrementCount);
            }

            decrementCount++;

            i--;
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] happiness = {5,3,4,2};
        int k=2;

        // Optimal Solution : sorting + Greedy -> TC: O(NLogN) ; SC: O(1)
        long res = maximumHappinessSum(happiness, k);

        System.out.println("Maximum Happiness of Selected childrens : " + res);
    }
}
