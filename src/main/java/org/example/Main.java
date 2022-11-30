package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        MyStringList list = new MyStringList(10);
//        list.add("name1");
//        list.add("name2");
//        list.add(2,"name3");
//        list.add(2,"name4");
//        list.add(0,"nameBig");
//
//        System.out.println(list);

        Integer[] arr1 = ArrayService.createRandomIntegerArray(1000);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);
//        System.out.println(Arrays.toString(arr1));

        long start1 = System.currentTimeMillis();
        ArrayService.sortBubble(arr1);
        System.out.println("sort by bubble = "+(System.currentTimeMillis()-start1));

        long start2 = System.currentTimeMillis();
        ArrayService.sortBubble(arr2);
        System.out.println("sort by select = "+(System.currentTimeMillis()-start2));


        long start3 = System.currentTimeMillis();
        ArrayService.sortInsertion(arr3);
        System.out.println("sort by insert = "+(System.currentTimeMillis()-start3));

//        System.out.println(Arrays.toString(arr3));

        IntegerList list = new IntegerList(500);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(1);
        for(int i = 0 ; i<496; i++) {
            list.add(5);
        }
        list.set(250, 250);

        long start4 = System.currentTimeMillis();
        int a = list.indexOf(250);
        System.out.println("find by insert = "+(System.currentTimeMillis()-start4));

        long start5 = System.currentTimeMillis();
        int b = list.lastIndexOf(250);
        System.out.println("find by binary = "+(System.currentTimeMillis()-start5));



    }


}