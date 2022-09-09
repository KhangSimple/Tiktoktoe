import java.util.Scanner;

public class Game {
    // Ham kiem tra trang thai game
    public boolean isEnd(CellStatic cell[][]){
        for(int i=0;i<3;i++){
            if(cell[i][0]==cell[i][1]&& cell[i][1]==cell[i][2] && cell[i][0]!=CellStatic.Empty){
                return true;
            }
            if(cell[0][i]==cell[1][i]&& cell[1][i]==cell[2][i] && cell[0][i]!=CellStatic.Empty){
                return true;
            }
        }
        if((cell[0][0]==cell[1][1]&& cell[1][1]==cell[2][2] && cell[0][0]!=CellStatic.Empty)
        ||(cell[0][2]==cell[1][1]&& cell[1][1]== cell[2][0] && cell[1][1]!=CellStatic.Empty))
        {
            return true;
        }
        return false;
        /*      
        .....   
        */
    }

    // Ham check xem da dien het o chua
    public boolean checkDraw(CellStatic cell[][]){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(cell[i][j]==CellStatic.Empty) return false;
            }
        }
        return true;
    }

    public boolean check(CellStatic cell[][],int x,int y){
        if((x>=3 || x<0) || (y>=3 || y<0)) return false;
        if(cell[x][y] != CellStatic.Empty){
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        CellStatic cell[][]= new CellStatic[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cell[i][j]=CellStatic.Empty;
            }
        }
        Scanner scanner = new Scanner(System.in);
        boolean isTurnX=true;
        Game control =new Game();
        while(!control.checkDraw(cell) && !control.isEnd(cell)){   // Kiem tra xem game ket thuc chua??
            if(isTurnX){
                System.out.println("This is X turn:");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                while(!control.check(cell,x,y)){ // kiem tra xem dien hop le chua??
                    System.out.println("Invalid!! Please try again:");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                }

                cell[x][y] = CellStatic.X; 

                Board.printBoard(cell); // In ra bang su dung static
                if(control.isEnd(cell)){
                    System.out.println("\nCongratulation!! X win");
                    break;
                }
                isTurnX = false;
            }
            if(control.checkDraw(cell)) break;
            if(!isTurnX){
                System.out.println("This is O turn:");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                while(!control.check(cell,x,y)){ // kiem tra xem dien hop le chua??
                    System.out.println("Invalid!! Please try again:");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                }

                cell[x][y] = CellStatic.O; 
                Board.printBoard(cell);
                if(control.isEnd(cell)){
                    System.out.println("\nCongratulation!! O win");
                    break;
                }
                isTurnX=true;
            }
            if(control.checkDraw(cell)) break;
        }
        if(!control.isEnd(cell) && control.checkDraw(cell)) System.out.println("\nDraw");
    }
}
