import java.util.Random;
import java.util.Scanner;


public class MineSweeper {
    private final int row;
    private final int col;
    private int inputRow;
    private int inputCol;
    private int mineCount;
    private final int[][] mineBoard;
    private final String[][] mine;
    private final String[][] board;


    public MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.mineBoard = new int[this.row][this.col];
        this.mine = mineSet(row, col);
        this.board =mBoardSet(this.row, this.col);
    }

    public void setInputCol(int inputCol) {
        this.inputCol = inputCol;
    }

    public void setInputRow(int inputCol) {

        this.inputRow = inputCol;
    }

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void print(String[][] arr) {


        for (String[] strings : arr) {

            for (int j = 0; j < arr[0].length; j++) {

                System.out.print("[" + strings[j] + "]" + " ");
            }
            System.out.println(" ");
        }
    }
    public String[][] mineSet(int row, int col){
        String[][] arr = new String[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
        return  arr;
    }
    public String[][] mBoardSet(int row, int col){
        String[][] arr = new String[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
        return  arr;
    }

    public void mineBoard() {

        int randRow, randCol;

        for (int count = 1; count <= mineCount; count++) {

            randRow = random.nextInt(row);
            randCol = random.nextInt(col);


            if (mineBoard[randRow][randCol] == 0 ) {
                mineBoard[randRow][randCol] = -1;
                mine[randRow][randCol] = "*";
            }
        }
    }

    public void check(int r, int c) {

        if(mineBoard[r][c] == 0) {

            mineBoard[r][c] = 0;
            board[r][c] = String.valueOf(mineBoard[r][c]);

            if((r > 0) && (c > 0) &&  (mineBoard[r - 1][c -1] == -1)){
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }
            if ((r > 0) && (mineBoard[r - 1][c] == -1)) {
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }
            if ((r > 0) && (c < this.col - 1) && (mineBoard[r - 1][c + 1] == -1)){
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }
            if ((c > 0) && (mineBoard[r][c - 1] == -1)) {
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }

            if ((c < this.col - 1) && (mineBoard[r][c + 1] == -1)) {
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }

            if ((r < this.row - 1) && (c > 0) && (mineBoard[r + 1][c - 1] == -1)){
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }

            if ((r < this.row - 1) && (mineBoard[r + 1][c] == -1)) {
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }
            if ((r < this.row - 1) && (c < this.col - 1) && (mineBoard[r + 1][c + 1] == -1)){
                mineBoard[r][c]++;
                board[r][c] = String.valueOf(mineBoard[r][c]);
                mine[r][c]=String.valueOf(mineBoard[r][c]);
            }

        }

       if ((mineBoard[r][c] == -1)) {
            mineBoard[r][c] = -1;
        }

    }
        public void run ()
        {

            int success = 0;

            int size = row * col;
            this.mineCount = size / 4;


            print(board);
            System.out.println("---------------------------");
            mineBoard();
            print(mine);

            while (true) {
                System.out.println("Enter Line!");
                setInputRow(scanner.nextInt());

                System.out.println("Enter Column !");
                setInputCol(scanner.nextInt());

                if(this.inputRow > row || this.inputCol > col){
                    System.out.println("Please Enter a Value in The Range!");
                }

                else {
                    check(this.inputRow, this.inputCol);

                    if (mineBoard[this.inputRow][this.inputCol] != -1) {
                        success++;
                        if (success == (size - this.mineCount)) {
                            System.out.println("Congratulations");
                            break;

                        }
                        System.out.println("---------------------------");
                        print(board);
                    } else {
                        print(mine);
                        System.out.println("Game Over");

                        break;

                    }
                }

            }

    }
}



