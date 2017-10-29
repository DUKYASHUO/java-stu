package sort;

public abstract class AbstractSort implements SortAble {

    @Override
    public void test(int[] arr) {
        System.out.println("---------before sort------------");
        printArr(arr);
        sort(arr);
        System.out.println("---------after sort------------");
        printArr(arr);
    }

    public void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("");
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
