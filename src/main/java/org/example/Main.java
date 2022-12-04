package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyStringList listStr = new MyStringList(10);
        listStr.add("name1");
        listStr.add("name2");
        listStr.add(1,"name3");
        listStr.add(2,"name4");
        listStr.add(0,"nameBig");

        System.out.println(listStr);


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

        IntegerList list = new IntegerList(10000);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(1);
        for(int i = 0 ; i<9996; i++) {
            list.add(5);
        }
        list.set(5000, 250);

        long start4 = System.currentTimeMillis();
        int a = list.indexOf(250);
        System.out.println("find by binary O(logN) + sort = "+(System.currentTimeMillis()-start4));

        long start5 = System.currentTimeMillis();
        int b = list.lastIndexOf(250);
        System.out.println("find by O(n) = "+(System.currentTimeMillis()-start5));



    }


}