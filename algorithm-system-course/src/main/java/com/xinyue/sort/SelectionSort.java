package com.xinyue.sort;

public class SelectionSort {

    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        for (int i=0; i<arr.length; i++) {
            int minIndex = i;
            for (int j=i; j<arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // swap arr[i] and arr[minIndex]
            E tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5,6,3,2,10,0,-3};
        SelectionSort.sort(arr);
        for (int a: arr)
            System.out.print(a + " ");
    }
}
