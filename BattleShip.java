import java.util.Scanner;

public class BattleShip {
 
    static int numRows = 10;
    static int numCols = 10;
    static int playerShips;
    static int computerShips;
    static String[][] grid = new String[numRows][numCols];
    static int[][] missedGuesses = new int [numRows][numCols];

    public static void main(String[] args){
        //innsturctions
        System.out.println("**** Welcome to BattleShip! ****");
        System.out.println("The main goal of this game is to sink the computer's ships");
        System.out.println("To sink ships and place ships, type in the coordinates of the tile");
        System.out.println("Are you ready?");
        
        createMap();
        deployPlayerShips();
        deployComputerShips();
        playerTurn();
        computerTurn();
    }


    
//creating the map    
public static void createMap(){
    
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

    
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
            if (j == 0)
                System.out.print("~" + grid[i][j]);
            else if (j == grid[i].length - 1)
                System.out.print(grid[i][j] + "~" + 1);
            else
                System.out.print(grid[i][j]);
        }
        System.out.println();
    }

    
    System.out.print("  ");
    for(int i = 0; i < numRows; i++)
        System.out.print(i);
    System.out.println();
}
//adding in player ships now
//something is wrong with this code right now, not sure how to fix it yet
public static void deployPlayerShips(){
    Scanner input = new Scanner(System.in) {
    System.out.println("Please deploy your ships:");
        BattleShip.playerShips = 5;
        for (int i = 1; i <= BattleShip.playerShips;){
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
                {
                    grid[x][y] =   "X";
                    i++;
                }
                else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
                    System.out.println("You can't place two or more ships on the same location");
                else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                    System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
            }
    

    }


//adding in computer ships 
//I haven't really finished any of the things below, i just put down like the basic things that i'm going to do
public static void deployComputerShips(){
    System.out.println("Computer is deploying ships");
    
    BattleShip.computerShips = 5;
    for (int i = 1; i <= BattleShip.computerShips; ) {
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);

    }
}


public static void playerTurn(){
    System.out.println("your turn");
    int x = -1, y = -1;
     do {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X coordinate: ");
        x = input.nextInt();
        System.out.print("Enter Y coordinate: ");
        y = input.nextInt();

        if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
        {
            if (grid[x][y] == "x") //if computer ship is already there; computer loses ship
            {
                System.out.println("Boom! You sunk the ship!");
                grid[x][y] = "!"; //Hit mark
                --BattleShip.computerShips;
            }
        }


    }
}

public static void computerTurn(){
    System.out.println("computer's turn");
    //Guess co-ordinates
    int x = -1, y = -1;
    {
        x = (int)(Math.random() * 10);
        y = (int)(Math.random() * 10);


    }
}
