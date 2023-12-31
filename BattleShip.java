import java.util.Scanner;
//this is still a very much work in progress, a lot of things are currently half finished
public class BattleShip {

    static int numRows = 11;
    static int numCols = 11;
    static int player1Ships;
    static int player2Ships;
    static int computerShips;
    static String[][] grid = new String[numRows][numCols];
    static int[][] missedGuesses = new int [numRows][numCols];

    public static void main(String[] args){
        //innsturctions
        System.out.println("**** Welcome to BattleShip! ****");
        System.out.println("The main goal of this game is to sink the computer's ships");
        System.out.println("To sink ships and place ships, type in the coordinates of the tile");
        System.out.println("Would you like to play a fast or normal round?");
        //I forgot to add the part where i give the player an option of picking fast or normal, would have done an if else statement
        

        
        createMap();
        deployPlayer1Ships();
        deployPlayer2Ships();
        player1Turn();
        player2Turn();
        do {
            Battle();
        }while(BattleShip.player1Ships != 0 && BattleShip.player2Ships != 0);
    }


//creating the map    
public static void createMap(){
    
        System.out.print("     ");
        for(int i = 1; i < numCols; i++)
            System.out.print(i + "  ");
        System.out.println();

    
        for(int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = "  ";
            if (j == 0)
                System.out.print(" " + grid[i][j]);
            else if (i == 1)
                System.out.print("~" + grid[i][j]);
            else 
                System.out.print(grid[i][j] + "~");
        }
        System.out.println();
    }

    
    System.out.print("     ");
        for(int i = 1; i < numCols; i++)
            System.out.print(i + "  ");
        System.out.println();
}
//adding in player ships now
public static void deployPlayer1Ships(){
    Scanner input = new Scanner(System.in);

    System.out.println("Player 1 please deploy your ships:");
        BattleShip.player1Ships = 4;
        for (int i = 0; i++ <= BattleShip.player1Ships;){
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i +" ship: ");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
                {
                    grid[x][y] =   "@";
                    i++;
                } //not sure why this is not working but this is suspposed to be the error handling part, same with p2 part
                else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
                    System.out.println("You can't place two or more ships on the same location");
                else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                    System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
            }
    

    }
    

public static void deployPlayer2Ships(){
    Scanner input = new Scanner(System.in); {
        
       System.out.println("Player 2 please deploy your ships:");
    
        BattleShip.player2Ships = 4;
        for (int i = 0; i++ <= BattleShip.player2Ships;){
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
                {
                    grid[x][y] =   "@";
                    i++;
                }
                else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
                    System.out.println("You can't place two or more ships on the same location");
                else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                    System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
            }
        }
    

    

    }

    public static void player1Turn(){
        System.out.println("Player 1's turn");
        int x = -1, y = -1;
         do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();
    
            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == "x") //not sure why ut's not showing up on the board
                    System.out.println("Boom! You sunk the ship!");
                    grid[x][y] = "!"; //Hit mark
                    --BattleShip.player1Ships;
                }
    
                else if (grid[x][y] == "#") {
                    System.out.println("Oh no, you sunk your own ship :(");
                    grid[x][y] = "x";
                    --BattleShip.player2Ships;
                    ++BattleShip.player1Ships;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Sorry, you missed");
                    grid[x][y] = "-";
                }
                
            
            else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    
}
    public static void player2Turn(){
        System.out.println("Player 2's turn");
        int x = -1, y = -1;
         do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();
    
            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == "x") 
                    System.out.println("Boom! You sunk the ship!");
                    grid[x][y] = "!"; //Hit mark
                    --BattleShip.player1Ships;
                }
    
                else if (grid[x][y] == "#") {
                    System.out.println("Oh no, you sunk your own ship :(");
                    grid[x][y] = "x";
                    --BattleShip.player2Ships;
                    ++BattleShip.player1Ships;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Sorry, you missed");
                    grid[x][y] = "-";
                }
                
            
            else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));
      }  //keep re-prompting till valid guess


    public static void Battle(){
        player1Turn();
        player2Turn();

        System.out.println();
        System.out.println("Player 1 ships: " + BattleShip.player1Ships + " | Player 2 ships: " + BattleShip.player2Ships);
        System.out.println();
    }

public static void gameOver(){
    System.out.println("Player 1 ships: " + BattleShip.player1Ships + " | Player 2 ships: " + BattleShip.player2Ships);
    if(BattleShip.player1Ships > 0 && BattleShip.player2Ships <= 0)
        System.out.println("Player 1 won yey :)");
    else
        System.out.println("Player 2 won yey :)");
    System.out.println();
}



   //for fast game
   public static void deployComputerShips(){
    System.out.println("Computer is deploying ships");
    
    BattleShip.computerShips = 3;
    for (int i = 1; i <= BattleShip.computerShips; ) {
        int x = (int)(Math.random() * 8);
        int y = (int)(Math.random() * 8);

        if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
        {
            grid[x][y] =   "x";
            System.out.println(i + ". ship deployed");
            i++;
        }
    }
}
public static void playerTurn(){
    System.out.println("\nYOUR TURN");
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
            else if (grid[x][y] == " ") {
                System.out.println("Sorry, you missed");
                grid[x][y] = "-";
            }

        
        else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess

}

}







