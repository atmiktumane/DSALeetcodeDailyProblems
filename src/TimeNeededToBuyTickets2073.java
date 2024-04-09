import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets2073 {
    static int timeRequiredToBuyBrute(int[] tickets, int k){
        int n = tickets.length;

        int pass = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(i);
        }

        while(tickets[k]!=0){
            int idx = q.peek();
            q.remove();

            if(tickets[idx]==0) continue;

            tickets[idx]--;
            pass++;

            if(tickets[idx]!=0){
                q.add(idx);
            }
        }
        return pass;
    }

    static int timeRequiredToBuyBetter(int[] tickets, int k) {
        int n = tickets.length;

        int pass = 0;

        while(tickets[k] != 0){
            for(int i=0; i<n; i++){
                if(tickets[i]==0) continue;

                tickets[i] = tickets[i]-1;
                pass++;

                if(tickets[k]==0) break;
            }
        }
        return pass;
    }

    static int timeRequiredToBuyOptimal(int[] tickets, int k) {
        int n = tickets.length;

        int pass = 0;

        for(int i=0; i<n; i++){
            if(i<=k){
                pass += Math.min(tickets[i], tickets[k]);
            }
            else{
                pass += Math.min(tickets[i], tickets[k]-1);
            }
        }

        return pass;
    }

    public static void main(String[] args){
        int[] tickets = {3,2,3};
        int k=1;

        // BRUTE FORCE ->  TC: O(N)*O(K*N)  ;  SC: O(N)
//        int res1 = timeRequiredToBuyBrute(tickets, k);
//        System.out.println("Time needed to Buy all tickets at index "+k + " is : "+res1);

        // BETTER APPROACH  -> TC: O(K*N)  ;  SC: O(1)
//        int res2 = timeRequiredToBuyBetter(tickets, k);
//        System.out.println("Time needed to Buy all tickets at index "+k + " is : "+res2);

        // OPTIMAL APPROACH  ->  TC: O(N)  ;  SC: O(1)
        int res3 = timeRequiredToBuyOptimal(tickets, k);
        System.out.println("Time needed to Buy all tickets at index "+k + " is : "+res3);
    }
}
