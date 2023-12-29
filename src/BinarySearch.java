import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] num = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
//        정렬이 되어있어야 이분탐색 가능함
        Arrays.sort(num);
        int target = 12;
        System.out.println(bin(target, num));
    }

    static int bin(int target, int[] num) {
        int start = 0;
        int last = num.length - 1;
        while (start <= last) {
            int middle = (start + last) / 2;
            if (target == num[middle]) {
                return middle;
            }
            if (num[middle] > target) {
                last = middle - 1;
            }
            if (num[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
}