public class Board {
    public static void printBoard(CellStatic cell[][]){
        System.out.print("\n");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(cell[i][j]==CellStatic.Empty) System.out.print("[ ] ");
                if(cell[i][j]==CellStatic.X) System.out.print("[X] ");
                if(cell[i][j]==CellStatic.O) System.out.print("[O] ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
