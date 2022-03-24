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
    int num = in.nextInt();
    if (num==1) bubble(n);
    else if (num==2) insert(n);
    else if (num==3) choice(n);
    else if (num==4) shell(n);
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

    static void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
