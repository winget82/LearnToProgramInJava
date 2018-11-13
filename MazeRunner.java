import java.util.*;

public class MazeRunner {
    static Maze myMap = new Maze();
    static int moves = 0;

    public static void main(String[] args) {
        intro();

        while (myMap.didIWin() == false){
            String moveDirection = userMove();
            if (moveDirection.equals("R") || moveDirection.equals("L") || moveDirection.equals("U") || moveDirection.equals("D")) {
                navigatePit(moveDirection);
            }
            myMap.printMap();
        }

        if (myMap.didIWin() == true) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + MazeRunner.moves + "moves.");
        }
    }

    public static void intro() {
        //welcome the user into the program and print the new map
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static String userMove() {
        //take in desired direction of move, and check if that direction is valid and possible.  If it is not continuously
        //prompt the user to select a valid direction
        Scanner input = new Scanner(System.in);
        System.out.println("What direction would you like to move? R, L, U, or D?");
        String direction = input.next().toUpperCase();

        if (direction.equals("R")) {
            System.out.println("Right");
            movesMessage(++MazeRunner.moves);
            if (myMap.canIMoveRight() == true) {
                myMap.moveRight();
            } else if (!myMap.canIMoveRight() && !myMap.isThereAPit(direction)) {
                System.out.println("You've hit a wall try another direction...");
            }

        } else if (direction.equals("L")) {
            System.out.println("Left");
            movesMessage(++MazeRunner.moves);
            if (myMap.canIMoveLeft() == true) {
                myMap.moveLeft();
            } else if (!myMap.canIMoveLeft() && !myMap.isThereAPit(direction)) {
                System.out.println("You've hit a wall try another direction...");
            }

        } else if (direction.equals("U")) {
            System.out.println("Up");
            movesMessage(++MazeRunner.moves);
            if (myMap.canIMoveUp() == true) {
                myMap.moveUp();
            } else if (!myMap.canIMoveUp() && !myMap.isThereAPit(direction)) {
                System.out.println("You've hit a wall try another direction...");
            }

        } else if (direction.equals("D")) {
            System.out.println("Down");
            movesMessage(++MazeRunner.moves);
            if (myMap.canIMoveDown() == true) {
                myMap.moveDown();
            } else if (!myMap.canIMoveDown() && !myMap.isThereAPit(direction)) {
                System.out.println("You've hit a wall try another direction...");
            }

        } else {
            System.out.println("Invalid input! Please enter R, L, U, or D...");
            userMove();
        }

        return direction;
    }

    public static void movesMessage(int moves) {
        //print message after certain number of moves
        //count moves will need to return the number of moves taken
        if (MazeRunner.moves == 50 && !myMap.didIWin()) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }

        if (MazeRunner.moves == 75 && !myMap.didIWin()) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }

        if (MazeRunner.moves == 90 && !myMap.didIWin()) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }

        if (MazeRunner.moves == 100 && !myMap.didIWin()) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.exit(0);
        }

    }

    public static void navigatePit(String direction) {
        //when the user runs into an obstacle, this method will be checking to see if it is a wall or a pit using the
        //line myMap.IsThereAPit will do the trick.  If it is a pit, you give the user an option to jump over the pit
        //myMap.JumpOverPit will move the character over the pit

        if (myMap.isThereAPit(direction) == true) {
            Scanner input = new Scanner(System.in);
            System.out.println("There is a pit.  Would you like to jump over it (Y/N)? ");
            String jumpPit = input.next().toUpperCase();

            if (jumpPit.equals("Y")) {
                myMap.jumpOverPit(direction);
                movesMessage(++MazeRunner.moves);
            } else if (jumpPit.equals("N")) {
                System.out.println("Chicken!");;
            } else if (!jumpPit.equals("N") || !jumpPit.equals("Y")) {
                System.out.println("Invalid input!");
            }
        }
    }
}
