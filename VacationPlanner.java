import java.util.Scanner;

public class VacationPlanner {

    public static void main (String[] args) {
        intro();
        budget();
        time();
        distance();

    }

    public static void intro() {
        Scanner input = new Scanner(System.in);
        //takes in user name and destination
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String city = input.nextLine();
        System.out.println("Great! " + city + " sounds like a great trip.");
        System.out.println("***********");

    }

    public static void budget() {
        Scanner input = new Scanner(System.in);
        //takes in days planned on trip, allowance, and converting info
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double money = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many " + currency + " are there in 1 USD? ");
        double amount = input.nextDouble();
        System.out.println();
        int hrs;
        hrs = days * 24;
        int mins;
        mins = hrs * 60;
        double perDay = money / days;
        double totalCurrency = amount * money;
        double curPerDay = totalCurrency / days;
        System.out.println("If you are travelling for " + days + " days that is the same as " + hrs + " hours or " + mins + " minutes.");
        System.out.println("If you are going to spend " + money + " USD that means per day you can spend up to $" + perDay + " USD.");
        System.out.println("Your total budget in " + currency + " is " + totalCurrency + " " + currency + ", which per day is " + curPerDay + " " + currency);
        System.out.println("***********");

    }

    public static void time() {
        Scanner input = new Scanner(System.in);
        //takes in the time difference between home and destination
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int hrs = input.nextInt();
        int difference = 0;
        int time = difference + hrs;
        int noon = 12 + hrs;
        System.out.println("That means that when it is midnight at home it will be " + time + ":00 in your travel destination");
        System.out.println("and when it is noon at home it will be " + noon + ":00.");
        System.out.println("***********");

    }

    public static void distance() {
        Scanner input = new Scanner(System.in);
        //takes in distance between home and destination in square kilometers and
        //converts it into square miles.
        System.out.print("What is the square area of your destination country in square kilometers? ");
        int km2 = input.nextInt();
        //kilometers * 0.62137 = miles
        //square km * 0.38610216 = square miles
        double miles2 = km2 * 0.38610216;
        System.out.println("In square miles that is " + miles2);
        System.out.println("***********");

    }
}
