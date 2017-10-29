package sort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int len = 10;
        int[] arr = new int[len];

        Random random = new Random();

        for(int i = 0; i < len; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        SortAble sortTest = new MergeSort();
        sortTest.test(arr);
    }
}
