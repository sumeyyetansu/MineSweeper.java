import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int row , col ;
        System.out.println("Welcome to Minesweeper Game !");

        System.out.println("Enter Your Game Board Lenght ");
        System.out.println("Count of Line");
        row = scanner.nextInt();
        System.out.println("Count of Column");
        col = scanner.nextInt();

        MineSweeper mine = new MineSweeper(row , col);
        mine.run();


    }

}