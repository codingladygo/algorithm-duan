package class02;

public class Code02_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int ele : arr) {
            eor = eor ^ ele;
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor = eor ^ num;
        }
        int rightOne = eor & (-eor);

        int onlyOne = 0;
        for (int num : arr) {
            if ((num & rightOne) != 0) {
                onlyOne ^= num;
            }
        }
        int result1 = onlyOne;
        int result2 = eor ^ onlyOne;
        System.out.println("result1: " + result1);
        System.out.println("resut2: " + result2);


    }


    public static int bit1counts(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
        }
        return count;

    }


    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNum2(arr2);

    }

}
