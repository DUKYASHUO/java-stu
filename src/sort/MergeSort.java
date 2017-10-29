package sort;

public class MergeSort extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0 , arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int index = (start + end) / 2;
            sort(arr, start, index);
            sort(arr, index + 1, end);
            merge(arr, start, index, end);
        }
    }

    private void merge(int[] arr, int start, int index, int end) {
        int n1 = index - start + 1;
        int n2 = end - index;
        int[] arrL = new int[n1 + 1];
        int[] arrR = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            arrL[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            arrR[i] = arr[index + i + 1];
        }

        arrL[n1] = Integer.MAX_VALUE;
        arrR[n2] = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        for (int i = start; i <= end; i++) {
            if (arrL[l] < arrR[r]) {
                arr[i] = arrL[l];
                l++;
            } else {
                arr[i] = arrR[r];
                r++;
            }
        }
    }
}
