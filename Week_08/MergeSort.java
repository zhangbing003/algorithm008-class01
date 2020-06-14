package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        Arrays.fill(arr, 1, 4, 100);
//        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, begin, mid, end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int l = begin, r = mid + 1, k = 0;
        while (l <= mid && r <= end) {
            temp[k++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= mid) temp[k++] = arr[l++];
        while (r <= end) temp[k++] = arr[r++];

        for (int i = 0; i < temp.length; i++) {
            arr[begin+i] = temp[i];
        }
    }
}
