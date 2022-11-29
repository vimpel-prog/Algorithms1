package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyStringList list = new MyStringList(10);
        list.add("popa1");
        list.add("popa2");
        list.add(2,"popa3");
        list.add(2,"popa4");
        list.add(0,"popaBig");



        System.out.println(list);
    }
}