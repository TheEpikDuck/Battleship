public class FastGame {

public static void deployComputerShips(){
    System.out.println("Computer is deploying ships");
    
    BattleShip.computerShips = 3;
    for (int i = 1; i <= BattleShip.computerShips; ) {
        int x = (int)(Math.random() * 8);
        int y = (int)(Math.random() * 8);

    }
}


