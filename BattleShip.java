public class BattleShip {
 
    static int numRows = 10;
    static int numCols = 10;
    static int playerShips;
    static int computerShips;
    static String[][] grid = new String[numRows][numCols];
    static int[][] missedGuesses = new int [numRows][numCols];

    public static void main(String[] args){
        System.out.println("**** Welcome to BattleShip! ****");
        //add instructions and ask the player if they want to play or not then make the map
        createMap();
        deployPlayerShips();
        deployPlayerShips();
        gameOver();
}
private static void gameOver() {
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

public static void deployPlayerShips(){
    Scanner input = new Scanner(System.in);

    System.out.println("Please deploy your ships:");
    BattleShip.playerShips = 5;
    for (int i = 1; i <= BattleShip.playerShips;){
        System.out.print("Enter X coordinate for your " + i + " ship: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate for your " + i + " ship: ");
        int y = input.nextInt();
    }
}
//adding in computer ships 
public static void deployComputerShips(){
    System.out.println("Computer is deploying ships");
    
    BattleShips.computerShips = 5;
    for (int i = 1; i <= BattleShips.computerShips; ) {
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);

}
