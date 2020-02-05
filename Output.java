import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

/**
* @author Phillip Archuleta
* This class creates the output file and writes the final types and locations of the cells to it.
 */
public class Output {
    
    /**
     * Creates and writes the final cell locations and types to output.txt. If an IOException occurs,
     * it is reported to the console.
     */
    public static void WriteToFile(){
        try {
            File file = new File("output.txt");
            file.createNewFile();
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String[] FinalBoard = new String[Board.ReportBoardValues().length];
            FinalBoard = Board.ReportBoardValues();
            for(int i = 0; i < Board.ReportBoardValues().length; i++){
                bw.write(FinalBoard[i]);
                bw.newLine();
            }
            bw.close();
            fw.close();
            
        }
        catch (IOException e) {
            System.out.println ("Output error");
        }
    }
}
