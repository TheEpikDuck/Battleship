public class BattleShip {
public static void main(String[] args) {
    int[][] board = new int[10][10];
    int[][] ships = new int[3][2];
    int[] shoot = new int[2];
    int attempts=0,
        shotHit=0;

    intBoard(board)
    intShips(ships)

    System.out.println();

    do
    {
        showBoard(board);
        shoot(shoot);
        attempts++

        if(hit(shoot,ships)){
            hint(shoot,ships,attempts);
            shotHit++;
        }
        else
        hint(shoot,ships,attempts);
        changeboard(shoot,ships,board);
    }
}
