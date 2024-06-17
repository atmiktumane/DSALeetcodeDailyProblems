public class SumOfSquareNumbers633 {

    static boolean judgeSquareSum(int c) {
        long num = (int)(Math.sqrt(c));

        long a=0, b=num;

        while(a <= b){
            long sum = a*a + b*b;

            if(sum == c){
                return true;
            }
            else if(sum < c){
                a++;
            }
            else {
                b--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int c = 5;

        boolean ans = judgeSquareSum(c);
        System.out.println("Sum of 2 Square numbers is equal to given number : "+ ans);


    }
}
