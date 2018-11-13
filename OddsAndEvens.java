import java.util.Scanner;
import java.util.Random;

public class OddsAndEvens {

    public static void main(String[] args){
        System.out.println("Let's play a game called \"Odds and Evens\"");
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String choice = input.nextLine();

        if (choice.equals("O")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }

        System.out.println("-------------------------------------------------------------------------------------");

        System.out.print("How many fingers do you put out? ");
        int fingers = input.nextInt();
        Random rand = new Random(); //makes a new random object
        int computer = rand.nextInt(6); //picks a random int between 0 and 5
        System.out.println("The computer plays " + computer + " fingers.");

        System.out.println("-------------------------------------------------------------------------------------");

        int sum = fingers + computer;

        //determine if odd or even by using a modulo to get a remainder
        boolean oddOrEven = sum % 2 == 0; //this will return true if sum is even (==0), or false if odd (1)

        if (oddOrEven == true) {
            String result = "even";
            System.out.println(sum + " is ..." + result + "!");
            if (choice.equals("E")) {
                System.out.println("That means " + name + " wins!");
            } else {
                System.out.println("That means the computer wins!");
            }
        } else {
            String result = "odd";
            System.out.println(sum + " is ..." + result + "!");
            if (choice.equals("O")) {
                System.out.println("That means " + name + " wins!");
            } else {
                System.out.println("That means the computer wins!");
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

}
