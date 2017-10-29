package sort;

public class QuickSort extends AbstractSort{
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pos = partition(arr, start, end);
            sort(arr, start, pos - 1);
            sort(arr, pos + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int index = start - 1;
        for (int i = start; i < end; i++) {
            if(arr[i] < value) {
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, ++index, end);
        return index;
    }
}
