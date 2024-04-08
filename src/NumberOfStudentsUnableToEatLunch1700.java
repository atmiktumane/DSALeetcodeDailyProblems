public class NumberOfStudentsUnableToEatLunch1700 {
    static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;

        for(int stud : students){
            arr[stud]++;
        }

        for(int i=0; i<n; i++){
            int sand = sandwiches[i];

            if(arr[sand]==0){
                return n-i;
            }

            arr[sand]--;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};

        int res = countStudents(students, sandwiches);

        System.out.println("Number of Students Unable to eat Lunch are : "+ res);
    }
}
