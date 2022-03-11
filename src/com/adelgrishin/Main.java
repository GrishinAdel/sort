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
    int num = in.nextInt();
    if (num==1) bubble(n);
    else if (num==2) insert(n);
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

    static void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
