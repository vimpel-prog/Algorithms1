package org.example;

import java.util.Random;

public class ArrayService {
    public static Integer[] createRandomIntegerArray(int size) {
        Random rnd = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(0, size);
//            arr[i]= (int) (Math.random() * size);
        }
        return arr;
    }

    private static void swap(Integer[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idMin]) {
                    idMin = j;
                }
            }
            swap(arr, i, idMin);
        }
    }

    public static void sortInsertion(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
