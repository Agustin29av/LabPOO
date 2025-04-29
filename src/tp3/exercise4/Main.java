package src.tp3.exercise4;

import java.util.Arrays;
import java.util.Scanner;

import src.tp3.exercise4.Exercise4.IntegerArray;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntegerArray array = new IntegerArray(); // instancia de la clase

        System.out.println("Element count: " + array.countElements());
        System.out.println("Max Value: " + array.finxMax());
        System.out.println("Average: " + array.calculateAverage());
        System.out.println("Ascending order: " + Arrays.toString(array.sortAscending()));
        System.out.println("Descending order: " + Arrays.toString(array.sortDescending()));

        scanner.close();
    }
}
