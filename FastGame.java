public class FastGame {

    
//adding in computer ships 
//I haven't really finished any of the things below, i just put down like the basic things that i'm going to do
public static void deployComputerShips(){
    System.out.println("Computer is deploying ships");
    
    BattleShip.computerShips = 3;
    for (int i = 1; i <= BattleShip.computerShips; ) {
        int x = (int)(Math.random() * 8);
        int y = (int)(Math.random() * 8);

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
