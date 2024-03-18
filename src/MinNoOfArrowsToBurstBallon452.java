import java.util.Arrays;
import java.util.Comparator;

public class MinNoOfArrowsToBurstBallon452 {
    static int findMinArrowShots(int[][] points){
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int n = points.length;
        int count = 1;
        int[] prev = points[0];

        for(int i=1; i<n; i++){
            int[] curr = points[i];

            if(curr[0] > prev[1]){
                count++;
                prev = curr;
            }
            else{
                prev[0] = Math.max(prev[0], curr[0]);
                prev[1] = Math.min(prev[1], curr[1]);
            }
        }

        return count;
    }

    public static void main(String[] args){
//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};

        int res = findMinArrowShots(points);

        System.out.println("Min. Number of Arrows to burst all balloons : "+ res);
    }
}
