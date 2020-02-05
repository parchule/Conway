import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
* @author Phillip Archuleta 
* This class is a general player which collects the user inputed arguments and calls methods from the other
 * classes to allow the game to operate correctly. 
 */
public class Player {

    public static int Width;
    public static int Length;
    public static String Filename;
    public static int Ticks;

    /**
     * @param args The user inputed arguments indicating the width of the board, the length of the board,
     * the file location of the input file, and the amount of ticks that the world is to take. 
     * 
     * This method is what also runs the game. It calls methods from other classes to allow the game to operate
     * correctly. 
     */
    public static void main(String[] args){
    	// The general notes to be printed out.
        System.out.println("Thank you for using our Version of Conway's Game of Life!");
        System.out.println("General Notes:");
        System.out.println("- Please limit the size of the board to 100 x 100.");
        System.out.println("- If living cells go out of the board range, they will no longer be considered \n   when determining the fate of cells in the board");
        System.out.println("- Please do not include any blank lines in the input file.");
        System.out.println("- The initial printout of the board does not count as a tick.");
        System.out.println("- All cells are recognized as type 1 cells, and will be reported as such in the output file.");
        System.out.println();
                
        // Prints the arguments into console so that the user knows if they mistyped some of the arguments.
        Width = Integer.parseInt(args[0]);
        System.out.println("Your desired width (x-axis)(columns) of the board is detected as: " + Width);
        Length = Integer.parseInt(args[1]);
        System.out.println("Your desired length (y-axis)(rows) of the board is detected as: " + Length);
        Filename = args[2];
        System.out.println("Your desired filename indicating the starting location of the cells is detected as: "+ Filename);
        Ticks = Integer.parseInt(args[3]);
        System.out.println("Your desired the number of ticks to take in the world before stopping is detected as: " + Ticks);
        

        //Creates a new board, initializes that board, prints the board population, prints the current tick,
        // and calls the method to edit the board to advance the ticks. After all of this, it calls onto the 
        // output class to create and write the output.txt file.
        Board PlayerBoard = new Board();
        PlayerBoard.initializeBoard();
        for(int i = 0; i <= Ticks; i++){
            System.out.println();
            System.out.println("Tick Value of Below Board: " + i);
            System.out.println("World Population of Below Board: " + PlayerBoard.BoardPopulation());
            PlayerBoard.GetBoardStats();
            if(i != Ticks){
                PlayerBoard.EditBoard();
            }
            else{}
        }
        Output.WriteToFile();
    }
}