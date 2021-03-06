package src.com.own.oct;

import java.util.Random;
import java.util.Scanner;

public class Code01 {
    /* Write a funny console application to visualize the Monty Hall Problem
     * Goal is to win the car.
     * There are three closed doors behind of which are two goats and one car
     * After you have picked your first door the game show moderator unveils one of
     * the other remaining doors with a goat. Then he asks you whether you want to
     * change your current door or stay with your decision.
     * Which decision do you think has the highest probability to win a car?
     *
     * Idea from the Movie 21, ASCII art from asciiart.eu (car) and ascii.13375.de (goat)
     */

    private final static String[] GOAT = {
            "                   ",
            ",-----------------,",
            "                   ",
            "|-----------------|",
            "|                 |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|  )_(            |",
            "| ≠° °≠__ ___     |",
            "|  `*´   ´    \\=, |",
            "|    \\  ,---| /   |",
            "|     ||    ||    |",
            "|     ^^    ^^    |",
            "|_________________|"
    };
    
    private final static String[] DOOR = {
            "                   ",
            ",-----------------,",
            "                   ",
            "|-----------------|",
            "|                 |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|              O  |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|_________________|"
    };
        
    private final static String[] CAR = {
            "                   ",
            ",-----------------,",
            "                   ",
            "|-----------------|",
            "|                 |",
            "|    -------------|",
            "|  `/\"\"\"\"/\"\"\"\"/|\"\"|",
            "|  /    /    / |__|",
            "| /----------=====|",
            "| | \\  /V\\  /    _|",
            "| |()\\ \\W/ /()   _|",
            "| |   \\   /     / |",
            "| =C========C==_| |",
            "|  \\_\\_/__..  \\_\\_|",
            "|_________________|"
    };

    private final static String DIVIDER =
            "_____________________________________________________________";


    public static void montyHallProblem() {
        clearTerminal();

        boolean revealedDoors [] = {false, false, false};
        String doors[][] = {DOOR, DOOR, DOOR};
        boolean[] carPosition = createGameShowCarArr();

        // Step #1 -> Display empty doors ----------------------------------------------------------
        doorOutput(doorBuilder(doors, 0));
        
        // Step #2 -> Let the user choose a door ---------------------------------------------------
        System.out.println("Game Show Moderator: Which door to choose? (1, 2, 3)");  
        Scanner sc = new Scanner(System.in);
        int currDoor = sc.nextInt();
        String message = "";

        if ( !(currDoor >= 1 && currDoor <= 3)) {
            message = "You didn't enter a valid door, we use door 3 instead (because I don't know"
                      + "how to handle exceptions yet)\n";
            currDoor = 3;
        }
        
        // Step #3 -> Reveal a goat-----------------------------------------------------------------
        int slotToReveal = getGoatToUnveil(currDoor-1, carPosition);

        doors[slotToReveal] = GOAT;
        revealedDoors[slotToReveal] = true;
        int revealedDoor = slotToReveal+1;
        
        clearTerminal();
        doorOutput(doorBuilder(doors, currDoor));
        
        // Step #4 -> Ask wheter to change door or stay --------------------------------------------
        System.out.println(
                message
                + "You chose door "
                + currDoor
                + ". "
                + "I revealed a goat for you, which was behind door "
                + revealedDoor
                + ". Would you like to change (c) or stay (any other input) with your initial choice?"
        );
        
        char change = sc.next().charAt(0);
        sc.close();
        
        // Step #5 -> Unveil door ------------------------------------------------------------------
        boolean hasWon = false;

        if (change == 'c') {
            currDoor = getDoorToUnveil(currDoor-1, revealedDoors) + 1;
        }
        if (carPosition[currDoor-1]) {
            doors[currDoor-1] = CAR;
            hasWon = true;
        } else {
            doors[currDoor-1] = GOAT;
        }

        clearTerminal();
        doorOutput(doorBuilder(doors, currDoor));
        
        printWinningMessage(hasWon);
    }

    public static void montyHallProblemProof() {
        int tests = 3000;
        int timesWonWithChange = 0;
        int timesWonWithoutChange = 0;

        for (int test = 0; test < tests; test++) {
            boolean revealedDoors [] = {false, false, false};
            boolean[] carPosition = createGameShowCarArr();

            // Randomly choose a door
            Random random = new Random();
            int door = random.nextInt(3);

            // Reveal one goat
            int slotToReveal = getGoatToUnveil(door, carPosition);
            revealedDoors[slotToReveal] = true;

            // Check for price without change
            if (carPosition[door]) {
                timesWonWithoutChange++;
            }

            // Check for price with change
            door = getDoorToUnveil(door, revealedDoors);

            if (carPosition[door]) {
                timesWonWithChange++;
            }
        }

        int probabilityWithoutChange = (int)Math.round(timesWonWithoutChange / (double)tests * 100);
        int probabilityWithChange = (int)Math.round(timesWonWithChange / (double)tests * 100);

        System.out.println("Probability of winning without change: " + probabilityWithoutChange + "%");
        System.out.println("Probability of winning with change: " + probabilityWithChange + "%");
    }


    /** Creates the Game Show array with length 3 where one array index is
      * randomly set to true,
      */
    public static boolean[] createGameShowCarArr () {
        boolean[] gameShowArr = new boolean[3];

        Random random = new Random();
        int randomIndex = random.nextInt(3);
        gameShowArr[randomIndex] = true;

        return gameShowArr;
    }

    /** Returns the slot that can be revealed by the game show moderator
      */
    public static int getGoatToUnveil(int currDoorIndex, boolean[] carPosition){
        Random random = new Random();
        int slot = 0;

        // Randomly use the rising or falling loop to search for slots
        if (random.nextBoolean()) {
            for (int i = 0; i <= 2 ; i++) {
                if ( !(i == currDoorIndex || carPosition[i])) {
                    slot = i;
                }
            }
        } else {
            for (int i = 2; i >= 0 ; i--) {
                if ( !(i == currDoorIndex || carPosition[i])) {
                    slot = i;
                }
            } 
        }
        return slot;
    }

    /** Prepares the arrays to be printed. Takes three arrays and the current
      * choice. If no choice markup is required use default 0. 
      */
    public static String[][] doorBuilder(String[][] doors, int currDoorIndex) {
        String[][] renderDoor = new String[3][15];

        // Copy two dimensional array (copyOf() only works on one dimensional)
        for (int i = 0; i < doors.length; i++)
            for (int j = 0; j < doors[i].length; j++)
                renderDoor[i][j] = doors[i][j];

        renderDoor[0][2] =   "|     DOOR # 1    |";
        renderDoor[1][2] =   "|     DOOR # 2    |";
        renderDoor[2][2] =   "|     DOOR # 3    |";

        if (currDoorIndex >= 1 && currDoorIndex <= 3) {
            renderDoor[currDoorIndex-1][0] = "    YOUR CHOICE    ";
        }

        return renderDoor;
    }

    /** Takes a two-dimensional array and prints them side by side */
    public static void doorOutput(String[][] arr) {
        for (int row = 0; row < 15; row++ ) {
            for (int col = 0; col < 3; col++) {
                System.out.print(arr[col][row]);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println(DIVIDER);
        System.out.println();
    }

    /** Clears whatever was printed out before from the terminal */
    public static void clearTerminal() {
        System.out.print(String.format("\033[2J"));
    }

    /** Returns the index of the door to be unveiled at the end */
    public static int getDoorToUnveil(int currDoorIndex, boolean[] revealedDoors) {
        int doorToUnveil = 0;
        for (int i = 0; i < 3 ; i++) {
            if ( !(revealedDoors[i] || i == currDoorIndex)) {
                doorToUnveil = i;
                break;
            }
        }
        return doorToUnveil;
    }

    /** Prints winning or loosing message depending on parameter
      * true -> won
      */
    public static void printWinningMessage(boolean hasWon) {
        if (hasWon) {
            System.out.println("Congratulations to your new car.\n\n\n");
        } else {
            System.out.println("You can still ride home on the goat...\n\n\n");
        }
    }
}
