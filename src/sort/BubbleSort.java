package sort;

public class BubbleSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }
}
