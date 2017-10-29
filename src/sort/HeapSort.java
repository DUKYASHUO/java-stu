package sort;

public class HeapSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        buildHeap(arr);
        int heapSize = arr.length;
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }

    private void buildHeap(int[] arr) {
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    private void maxHeapify(int[] arr, int index, int heapSize) {
        int left = left(index);
        int right = righ(index);
        int maxIndex = index;
        if (left < heapSize && arr[left] > arr[index]) {
            maxIndex = left;
        }
        if (right < heapSize && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            swap(arr, maxIndex, index);
            maxHeapify(arr, maxIndex, heapSize);
        }
    }

    private int left(int index) {
        return (index << 1) + 1;
    }

    private int righ(int index) {
        return (index << 1) + 2;
    }
}
