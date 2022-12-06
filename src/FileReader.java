package src; 

import java.util.Scanner; 
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.Path; 

public class FileReader {
    private BufferedReader br; 

    public FileReader(){
        Path path = FileSystems.getDefault().getPath("assets", "charData.txt"); 
        br = Files.newBufferedReader(path); 
    }

    public void readCharData(Character[] characters){
        for (Character current : characters){
            
        }
    }
}
