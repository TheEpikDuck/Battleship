public class BattleShip {
 
    static int numRows = 10;
    static int numCols = 10;
    static String[][] grid = new String[numRows][numCols];

    public static void main(String[] args){
        System.out.println("**** Welcome to BattleShip! ****");
        createMap();
}
    public static void createMap(){
    
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

    
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " |";
            if (j == 0)
                System.out.print("|" + grid[i][j]);
            else if (j == grid[i].length - 1)
                System.out.print(grid[i][j] + "-");
            else
                System.out.print(grid[i][j]);
        }
        System.out.println();
    }

    
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
        System.out.print(i);
    System.out.println();
}

}
