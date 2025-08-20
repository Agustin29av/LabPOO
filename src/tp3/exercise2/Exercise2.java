package tp3.exercise2;
import java.util.Scanner;

public class Exercise2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your rating: ");
        int rating = scanner.nextInt();

        if(rating>=8){
            System.out.println("Exempt - Passed with distinction");
        }else if(rating>=7){
            System.out.println("Exempt");
        }else if(rating>=4){
            System.out.println("Conditional Pass - In Progress");
        }else if(rating<=3){
            System.out.println("Failed - Retake Required");
        }

        scanner.close();
    }
}
