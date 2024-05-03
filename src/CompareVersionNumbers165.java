import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers165 {
    static List<String> getTokens(String version){
        String[] tokens = version.split("\\."); // Splits the string w.r.t "."

        List<String> versionToken = new ArrayList<>();

        for(String token : tokens){
            versionToken.add(token);
        }

        return versionToken;
    }

    static int compareVersion(String version1, String version2){

        List<String> tokens1 = getTokens(version1);
        List<String> tokens2 = getTokens(version2);

        int m = tokens1.size();
        int n = tokens2.size();

        int i=0;

        while(i<m || i<n){
            int num1 = (i<m) ? Integer.parseInt(tokens1.get(i)) : 0 ;
            int num2 = (i<n) ? Integer.parseInt(tokens2.get(i)) : 0 ;

            if(num1 > num2){
                return 1;
            }
            else if(num1 < num2){
                return -1;
            }

            i++;
        }
        return 0;


    }

    public static void main(String[] args) {
        String version1 = "1.01.2";
        String version2 = "1.001";

        // Optimal Solution : TC: O(N)  ;  SC: O(1)
        int ans = compareVersion(version1, version2);

        System.out.println(ans);
    }
}
