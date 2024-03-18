public class ContiguousArray525 {
    static void findContigousArrayBrute(int[] arr){
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
    public static void main(String[] args){
        int[] arr = {0,1,0,0,0,1,1};

        findContigousArrayBrute(arr);
    }
}
