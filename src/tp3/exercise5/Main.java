package src.tp3.exercise5;

import java.util.Scanner;

import src.tp3.exercise5.Exercise5.IntegerNumber;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        IntegerNumber integer = new IntegerNumber(num);

        System.out.println("Number: " + integer.getNumber());
        System.out.println("Square: " + integer.square()); // cuadrado
        System.out.println("Is even?: " + integer.isEven()); // es par
        System.out.println("Factorial: " + integer.factorial()); // factorial
        System.out.println("Is prime?: " + integer.isPrime()); // es primo

        scanner.close();
    }
}
