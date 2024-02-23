public class Soduku{
        public static void printSoduku(int soduku[][]) {
            for(int i=0; i<=8; i++) {
                for(int j=0; j<=8; j++) {
                    System.out.print(soduku[i][j] + " ");
                }
                System.out.println();
            }
        }
    
        public static boolean SodukuSolver(int soduku[][], int row, int col) {
            //Base case
            if(row == 9) {
                return true;
            }
    
            //Recursion
            int nextRow = row, nextCol = col+1;
            if(col+1 == 9) { 
                nextRow = row+1;
                nextCol = 0;
            }
    
            if(soduku[row][col] != 0) {
                return SodukuSolver(soduku, nextRow, nextCol);
            }
        
            for(int digit=1; digit<=9; digit++) {
                if(isSafe(soduku,row,col,digit)) {
                    soduku[row][col] = digit;
                    if(SodukuSolver(soduku, nextRow, nextCol)) { //solution exist
                        return true;
                    }
                    soduku[row][col] = 0;
                }
            }
    
            return false;
        }
        public static boolean isSafe(int soduku[][], int row, int col, int digit) {
            //horizontal
            for(int i=0; i<=8; i++) {
                if(soduku[i][col] == digit) {
                    return false;
                }
            }
    
            //vertical
            for(int j=0; j<=8; j++) {
                if(soduku[row][j] == digit) {
                    return false;
                }
            }
    
            //Grid
            int sr = (row / 3) * 3;
            int sc = (col / 3) * 3;
            for(int i=sr; i<sr+3; i++) {
                for(int j=sc; j<sc+3; j++) {
                    if(soduku[i][j] == digit) {
                        return false;
                    }
                }
            }
    
            return true;
        }
        public static void main(String args[]) {
            int soduku[][] = { {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3} };
    
            if(SodukuSolver(soduku, 0, 0)) {
                System.out.println("Soution exist");
                printSoduku(soduku);
            } else {
                System.out.println("Solution does not exist");
            }
                                        
    
        
        }
    }
