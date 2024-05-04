import java.util.Arrays;

public class MinimumBoatsToSavePeople881 {
    static int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        Arrays.sort(people);

        int i=0, j=n-1;

        int boats = 0;

        while(i<=j){
            if(people[i]+people[j] <= limit){
                i++;
                j--;
            }
            else{
                j--;
            }

            boats++;
        }
        return boats;

    }

    public static void main(String[] args) {
        int[] people = {3,5,3,4};  // {5,4,1,2} ; limit=6 -> another testcase
        int limit = 5;

        // Optimal Approach -> Greedy Solution to first see max. weigth person -> TC: O(N); SC: O(1)
        int minBoats = numRescueBoats(people, limit);

        System.out.println("Minimum number of boats to save all people in given array : "+ minBoats);

    }
}
