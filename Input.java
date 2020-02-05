import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Phillip Archuleta
 * This class reads the input file and returns it so that other classes can access the initial locations and types
 * of the cells.
 */
public class Input{
    public static List<String> lines = new ArrayList<String>();
    private String InputPath;
    
    /**
     * This constructor creates a new Input type for the rest of the methods of the class to be called of off.
     * @param Filename The filepath of the input file.
     */
    public Input(String Filename){
        InputPath = Filename;
    }
    
    /**
     * Reads the input.txt file and assigns it into an ArrayList named lines. If the filepath is determined to be
     * invalid, a message is printed to the console which states this. 
     */
    public void InterpretInput(){
        try {
            File inFile = new File(InputPath);
            Scanner sc = new Scanner(inFile);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                lines.add(line);
            }
            sc.close();
            
        }
        catch (IOException e){
            System.out.println("File not found, terminating program.");
               System.exit(0);
        }
        
    }
    
    /**
     * @return The Arraylist containing the contents of the input.txt file.
     */
    public List GetInput(){
        return lines;
    }

}