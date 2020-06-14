package sort;

import java.util.Arrays;

public class BasicSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        doBubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void doBubblesort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    private static void doInsertionsort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length-1; i++) {
            int j = i+1;
            while (j > 0 && arr[j] < arr[j-1]) {
                int tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void doSelectionsort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index > i) {
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
