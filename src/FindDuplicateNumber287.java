import java.util.HashMap;

public class FindDuplicateNumber287 {

    static int findDuplicate(int[] arr) {
        int n = arr.length;
        if(n==0 || n==1) return -1;

        HashMap<Integer, Integer> mp = new HashMap<>();

        // store (element + occurence) in HashMap
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
                return key;
            }
        }

        return -1;

    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,2};

        int dupElement = findDuplicate(arr);

        System.out.println("Duplicate Element in given input array : "+dupElement);
    }
}
