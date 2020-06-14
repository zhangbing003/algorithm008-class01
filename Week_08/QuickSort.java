package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int counter = begin, pivot = end;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int tmp = arr[counter]; arr[counter] = arr[i]; arr[i] = tmp;
                counter++;
            }
        }
        int tmp = arr[counter]; arr[counter] = arr[pivot]; arr[pivot] = tmp;
        return counter;
    }


}
