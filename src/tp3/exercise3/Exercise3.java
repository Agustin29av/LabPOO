package tp3.exercise3;
import java.util.Scanner;

public class Exercise3{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //I request the floor from the user
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        word = word.trim().toLowerCase();

        //I create a variable to save the inverted word
        String invertedWord  = "";
        System.out.println("Entered word: '" + word + "'");
        System.out.println("Word lenght: " + word.length());

        // Build the reversed word
        for (int i = word.length()-1; i>=0; i--){
            invertedWord  += word.charAt(i);
        }

        // I compare the original word with the inverted one
        if (word.equals(invertedWord )) {
            System.out.println("The word is a palindre");
        }else{
            System.out.println("The word isn't palindre");
        }

        scanner.close();
    }
}
