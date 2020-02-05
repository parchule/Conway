import java.util.ArrayList;
import java.util.List;

/**
* @author Phillip Archuleta
* This is the class responsible for updating the board, initializing the board, printing the board,
* reporting the board population, and reporting the locations of the cells.
*/
public class Board {
   private List<String> InitialPlacement;
   public static String[][] BoardRep = new String[Player.Length][Player.Width];
   private int[] cells;

   /**
    * This constructor creates a new Board which the rest of the methods in this class can be called off of. 
    */
   public Board(){}

   /**
    * This method updates the board when it is called. It should be called to advance the board to the next tick.
    */
   public void EditBoard(){
       int[][] BoardChanges = new int[Player.Length][Player.Width];
       for(int y = 0; y < Player.Length; y++){
           for(int x = 0; x < Player.Width; x++){
               BoardChanges[y][x] = Cells.CheckStatus(x, y);
           }
       }
       for(int i = 0; i < Player.Length; i++){
           for(int j = 0; j < Player.Width; j++){
               if(BoardChanges[i][j] == 1){
                   Cells.DeleteCell(j, i);
               }
               else if(BoardChanges[i][j] == 2){}
               else if(BoardChanges[i][j] == 3){
                   Cells.CreateCell(j, i);
               }
               else{
                   Cells.DeleteCell(j, i);
               }
           }
       }
   }

   /**
    * This methods initializes the board. It should be called once when the game first begins. 
    */
   public void initializeBoard(){
       Input PlayerInput = new Input(Player.Filename);
       PlayerInput.InterpretInput();
       List<String> InitialPlacement = new ArrayList<String>();
       InitialPlacement = Input.lines;
       int i = 0;
       int[] cells = new int[InitialPlacement.size() * 3];
       for(String e: InitialPlacement){
           try{
               int FirstComma = e.indexOf(',');
               int SecondComma = e.indexOf(',', FirstComma + 1);
               String FirstNumber = e.substring(0,FirstComma);
               String SecondNumber = e.substring(FirstComma + 1, SecondComma);
               String ThirdNumber = e.substring(SecondComma + 1);
               int CellType = Integer.parseInt(FirstNumber);
               int XPosition = Integer.parseInt(SecondNumber);
               int YPosition = Integer.parseInt(ThirdNumber);
               cells[i] = CellType;
               i++;
               cells[i] = XPosition;
               i++;
               cells[i] = YPosition;
               i++;
           }
           catch(StringIndexOutOfBoundsException s){
               System.out.println("Invalid Input.txt file format, please refer to the general notes, terminating program.");
               System.exit(0);
           }
       }
       for(int a = 0; a < Player.Length; a++){
           for(int b = 0; b < Player.Width; b++){
               BoardRep[a][b] = "_";
           }
       }

       int h = 1;
       while((h + 1) <= cells.length){
           BoardRep[cells[h+1]][cells[h]] = "X";
           h = h + 3;
       }   
   }

   /**
    * @return The population of the board at the current tick.
    */
   public static int BoardPopulation(){
       int i = 0;
       for(int j = 0; j < Player.Length; j++){
           for(int k = 0; k < Player.Width; k++){
               if((BoardRep[j][k]).equals("X")){
                   i++;
               }
           }
       }
       return i;
   }

   /**
    * @return An one dimensional array of strings which give the locations and types of the cells in the same
    * format given in the input file.
    */
   public static String[] ReportBoardValues(){
       String[] FinalBoardLocations = new String[BoardPopulation()];
       int z = 0;
       for(int j = 0; j < Player.Length; j++){
           for(int k = 0; k < Player.Width; k++){
               if((BoardRep[j][k]).equals("X")){
                   FinalBoardLocations[z] = "1," + k + "," + j;
                   z++;
               }
           }
       }
       return FinalBoardLocations;
   }

   /**
    * Prints a printout of the board with numbers indicating the locations of the y-axis and x-axis.
    */
   public void GetBoardStats(){
       System.out.println();
       System.out.print("   ");
       if(BoardRep[0].length > 10){
           for(int h = 0; h < BoardRep[0].length; h++){
               System.out.print(" ");
               System.out.print(h/10);
               System.out.print(" ");    
           }
       }
       System.out.println();
       System.out.print("   ");
       for(int h = 0; h < BoardRep[0].length; h++){
           if(h < 10){
               System.out.print(" ");
               System.out.print(h);
               System.out.print(" ");
           }
           else{
               System.out.print(" ");
               System.out.print(h%10);
               System.out.print(" ");
           }

       }
       System.out.println(" ");
       for(int i = 0; i < BoardRep.length; i++){
           if(i < 10){
               System.out.print(i + " ");
               System.out.print(" ");
           }
           else{
               System.out.print(i + " ");
           }
           for(int j = 0; j < BoardRep[0].length; j++){
               System.out.print("|");
               System.out.print(BoardRep[i][j]);
               System.out.print("|");
           }
           System.out.println();
       }

   }
}
