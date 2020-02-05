import java.util.ArrayList;

/**
* @author Phillip Archuleta
* This class controls methods directly related to the creation, deletion, and status 
 * checking of cells.
 */
public class Cells {
    
    /**
     * This method changes any cell in the board to a live cell.
     * @param Xcord Any x-coordinate of any given valid location on the board.
     * @param Ycord Any y-coordinate of any given valid location on the board.
     */
    public static void CreateCell(int Xcord, int Ycord){
        Board.BoardRep[Ycord][Xcord] = "X";
    }
    
    /**
     * This method changes any cell in the board to a dead cell.
     * @param Xcord Any x-coordinate of any given valid location on the board.
     * @param Ycord Any y-coordinate of any given valid location on the board.
     */
    public static void DeleteCell(int Xcord, int Ycord){
        Board.BoardRep[Ycord][Xcord] = "_";
    }
    
    /**
     * This method checks whether any cell in the board is alive or dead.
     * @param Xcord Any x-coordinate of any given valid location on the board.
     * @param Ycord Any y-coordinate of any given valid location on the board.
     * @return
     */
    public static String CheckCell(int Xcord, int Ycord){
        if((Board.BoardRep[Ycord][Xcord]).equals("X")){
            return "X";
        }
        else{
            return "_";
        }
    }
    
    /**
     * Determines the neighbors of any given cell on the board.
     * @param Xcord Any x-coordinate of any given valid location on the board.
     * @param Ycord Any y-coordinate of any given valid location on the board.
     * @return An Arraylist of the X and Y coordinates of all neighbors of any given cell.
     */
    public static ArrayList<Integer> getLivingNeighbors(int Xcord, int Ycord){
        ArrayList<Integer> LivingNeighbors = new ArrayList<Integer>();
        
        int BoardXCord = Player.Width - 1;
        int BoardYCord = Player.Length - 1;
        
        //Calculates the neighbors of cells on the left board wall excluding corners.
        if(Xcord == 0 && Ycord != 0 && Ycord != BoardYCord){
            for(int i = (Ycord - 1);i < (Ycord + 2); i++){
                if(CheckCell(Xcord + 1, i) == "X"){
                    LivingNeighbors.add(Xcord + 1);
                    LivingNeighbors.add(i);
                }
            }
            if(CheckCell(Xcord, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord - 1);
            }
            if(CheckCell(Xcord, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord + 1);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells on the right board wall excluding corners.
        else if(Xcord == BoardXCord && Ycord != 0 && Ycord != BoardYCord){
            for(int i = (Ycord - 1);i < (Ycord + 2); i++){
                if(CheckCell(Xcord - 1, i) == "X"){
                    LivingNeighbors.add(Xcord - 1);
                    LivingNeighbors.add(i);
                }
            }
            if(CheckCell(Xcord, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord - 1);
            }
            if(CheckCell(Xcord, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord + 1);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells on the upper board wall excluding corners.
        else if(Ycord == 0 && Xcord != 0 && Xcord != BoardXCord){
            for(int i = (Xcord - 1);i < (Xcord + 2); i++){
                if(CheckCell(i, Ycord + 1) == "X"){
                    LivingNeighbors.add(i);
                    LivingNeighbors.add(Ycord + 1);
                }
            }
            if(CheckCell(Xcord - 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord - 1);
                LivingNeighbors.add(Ycord);
            }
            if(CheckCell(Xcord + 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord + 1);
                LivingNeighbors.add(Ycord);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells on the bottom board wall excluding corners.
        else if(Ycord == BoardYCord && Xcord != 0 && Xcord != BoardXCord){
            for(int i = (Xcord - 1);i < (Xcord + 2); i++){
                if(CheckCell(i, Ycord - 1) == "X"){
                    LivingNeighbors.add(i);
                    LivingNeighbors.add(Ycord - 1);
                }
            }
            if(CheckCell(Xcord - 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord - 1);
                LivingNeighbors.add(Ycord);
            }
            if(CheckCell(Xcord + 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord + 1);
                LivingNeighbors.add(Ycord);
            }
            return LivingNeighbors;
        }
        //Calculates the neighbors of cells in the upper left corner.
        else if(Xcord == 0 && Ycord == 0){
            if(CheckCell(Xcord + 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord + 1);
                LivingNeighbors.add(Ycord);
            }
            if(CheckCell(Xcord + 1, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord + 1);
                LivingNeighbors.add(Ycord + 1);
            }
            if(CheckCell(Xcord, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord + 1);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells in the bottom right corner.
        else if(Xcord == BoardXCord && Ycord == BoardYCord){
            if(CheckCell(Xcord - 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord - 1);
                LivingNeighbors.add(Ycord);
            }
            if(CheckCell(Xcord - 1, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord - 1);
                LivingNeighbors.add(Ycord - 1);
            }
            if(CheckCell(Xcord, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord - 1);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells in the bottom left corner.
        else if(Xcord == 0 && Ycord == BoardYCord){
            if(CheckCell(Xcord + 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord + 1);
                LivingNeighbors.add(Ycord);
            }
            if(CheckCell(Xcord + 1, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord + 1);
                LivingNeighbors.add(Ycord - 1);
            }
            if(CheckCell(Xcord, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord - 1);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells in the upper right corner.
        else if(Xcord == BoardXCord && Ycord == 0){
            if(CheckCell(Xcord - 1, Ycord) == "X"){
                LivingNeighbors.add(Xcord - 1);
                LivingNeighbors.add(Ycord);
            }
            if(CheckCell(Xcord - 1, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord - 1);
                LivingNeighbors.add(Ycord + 1);
            }
            if(CheckCell(Xcord, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord + 1);
            }
            return LivingNeighbors;
        }
        
        //Calculates the neighbors of cells not on any board wall or corner.
        else{
            for(int i = (Ycord - 1);i < (Ycord + 2); i++){
                if(CheckCell(Xcord + 1, i) == "X"){
                    LivingNeighbors.add(Xcord + 1);
                    LivingNeighbors.add(i);
                }
            }
            for(int i = (Ycord - 1);i < (Ycord + 2); i++){
                if(CheckCell(Xcord - 1, i) == "X"){
                    LivingNeighbors.add(Xcord - 1);
                    LivingNeighbors.add(i);
                }
            }
            if(CheckCell(Xcord, Ycord - 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord - 1);
            }
            if(CheckCell(Xcord, Ycord + 1) == "X"){
                LivingNeighbors.add(Xcord);
                LivingNeighbors.add(Ycord + 1);
            }
            return LivingNeighbors;
        }
    }
    
    /**
     * @param Xcord Any x-coordinate of any given valid location on the board.
     * @param Ycord Any y-coordinate of any given valid location on the board.
     * @return 1 if the amount of neighbors for any given cell is less than 2.
     * @return 2 if the amount of neighbors for any given cell is 2.
     * @return 3 if the amount of neighbors for any given cell is 3.
     * @return 4 if the amount of neighbors for any given cell is more than 3.
     */
    public static int CheckStatus(int Xcord, int Ycord){
        int neighbors = ((getLivingNeighbors(Xcord,Ycord)).size()) / 2;
        if(neighbors < 2){
            return 1;
        }
        else if(neighbors == 2){
            return 2;
        }
        else if(neighbors == 3){
            return 3;
        }
        else{
            return 4;
        }
    }
}