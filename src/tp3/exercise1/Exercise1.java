package src.tp3.exercise1;
import java.util.Scanner;

public class Exercise1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //se piden los numeros

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();
        
        if(num1>0){
            int product = num2*num3;
            System.out.println("The first number is positive. The product of the other two " + product);
        }else{
            int sum = num2+num3;
            System.out.println("The first number isn't positive. The sum of the other two is: " + sum);
        }
        scanner.close();
    }

}