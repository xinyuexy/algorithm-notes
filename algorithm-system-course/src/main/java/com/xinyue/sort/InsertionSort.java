/**
 * @(#)InsertionSort.java, 6月 01, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.xinyue.sort;

/**
 * @author liuxinyuebj
 */
public class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        // 循环不变量：a[0,i)有序，a[i,n)无序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j-1]) >= 0) {
                    break;
                }
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        // 优化：不是每次交换，而是平移
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (arr[j-1].compareTo(t) >= 0) {
                    arr[j] = arr[j-1];
                } else {
                    break;
                }
            }
            arr[j] = t;
        }
    }

    // 改变循环不变量：a[0, i)无序，a[i, n)有序
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        for (int i = arr.length-1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j+1 < arr.length && arr[j+1].compareTo(t) < 0; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = t;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {6,5,3,4,1,2};
        InsertionSort.sort3(arr);
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
}
