package com.adelgrishin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 10;

    for (int i = 0; i < n; i++) {
        array.add((int) Math.round((Math.random()*30)-15));
    }

    print(n);
    System.out.println();
    System.out.println("Какой метод сортировки применить?");
    System.out.println("1. Пузырьком");
    System.out.println("2. С вставками");
    System.out.println("3. Выбором");
    System.out.println("4. Алгоритм шелла");
    System.out.println("5. Алгоритм быстрой сортировки (Quicksort)");
    System.out.println("6. Пирамидная");
    int num = in.nextInt();
    if (num==1) bubble(n);
    else if (num==2) insert(n);
    else if (num==3) choice(n);
    else if (num==4) shell(n);
    else if (num==5) {
        int low = 0;
        int high = n - 1;
        quickSort(low, high, n);
    } else if (num==6) {

    }
    print(n);
    }

    static void bubble(int n) {
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n-1; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    int t = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, t);
                }
            }
        }
    }

    static void insert(int n) {
        for (int left = 1; left < n; left++) {
            int value = array.get(left);
            for (int i = left - 1; i >= 0; i--) {
                if (value < array.get(i)) {
                    array.set(i + 1 , array.get(i));
                } else {
                    array.set(i+1,value);
                    break;
                }
            }
        }
    }

    static void choice(int n) {
        int min;
        for (int i = 0; i < n-1; i++) {
            min = i;
            for (int j = i+1; j < n; j++ ) {
                if (array.get(min) > array.get(j)) min = j;
            }
            if (min!= i) {
                int t = array.get(i);
                array.set(i, array.get(min));
                array.set(min, t);
            }
        }
    }

    static void shell(int n) {
        int step = n/2;
        while (step>0) {
            for (int i = step; i < n; i++) {
                for (int j = i; j >= step; j-= step) {
                    if (array.get(j) < array.get(j-step)) {
                        int t = array.get(j);
                        array.set(j, array.get(j-step));
                        array.set(j-step, t);
                    }
                }
            }
            step/=2;
        }
    }

    public static void quickSort(int low, int high, int n) {

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i) < opora) {
                i++;
            }

            while (array.get(j) > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(low, j, n);
        if (high > i)
            quickSort(i, high, n);
    }


    static void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
