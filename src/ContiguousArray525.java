import java.util.HashMap;

public class ContiguousArray525 {
    static void findMaxLengthBrute(int[] arr){
        int n=arr.length;

        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int count0=0, count1=0;
            for(int j=i; j<n; j++){
                for(int k=i; k<=j; k++){
                    if(arr[k]==0) count0++;
                    else count1++;
                }
                if(count0==count1){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        System.out.println("Max. Length of contiguous array with equal no. of 0s and 1s : "+maxLen);
    }

    static void findMaxLengthOptimal(int[] arr) {
        int n = arr.length;

        if(n==0 || n==1) return ;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int currSum = 0, maxLen = 0;
        mp.put(currSum, -1);

        for(int i=0; i<n; i++){
            if(arr[i]==0){   // treat 0 as -1
                currSum += -1;
            }
            else{
                currSum += arr[i];
            }

            if(!mp.containsKey(currSum)){
                mp.put(currSum, i);
            }
            else{
                int len = i-mp.get(currSum);
                maxLen = Math.max(maxLen, len);
            }
        }

        System.out.println("Max. Length of contiguous array with equal no. of 0s and 1s : "+maxLen);

    }
    public static void main(String[] args){
        int[] arr = {0,1,0,0,0,1,1};

        findMaxLengthBrute(arr);

        findMaxLengthOptimal(arr);
    }
}
