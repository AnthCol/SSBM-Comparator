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
            current.characterName = br.nextLine();  // name 
            variableLoop(current.jabs, 3, 4);  // jabs 
            variableLoop(current.tilts, 3, 4); // tilts
            for (int i = 0; i < 4; i++){ // READ HERE BECAUSE 1D ARRAY     // dash attack
                current.dashAttack[i] = Integer.parseInt(br.nextLine()); 
            } 
            variableLoop(current.smashAttacks, 3, 4);     // smash attacks
            variableLoop(current.aerials, 5, 4);    // aerials
            variableLoop(current.specialAttacksGrounded, 5, 4);     // specialAttacksGroudned
            variableLoop(current.specialAttacksAerial, 5, 4);     // specialATtacksAerial
            variableLoop(current.grabs, 2, 2);    // grabs
            variableLoop(current.grabThrows, 4, 3);    // grabthrows
            variableLoop(current.dodgesRolls, 4, 4);     // dodges & rolls
            for (int i = 0; i < 8; i++){// READ HERE BECAUSE FLOATS     // misc
                current.misc[i] = Float.parseFloat(br.nextLine()); 
            }

        }
    }


    private void variableLoop(int[][] array, int outer, int inner){
        for (int i = 0; i < inner; i++){
            for (int x = 0; x < outer; x++){
                array[i][x] = Integer.parseInt(br.nextLine()); 
            }
        }
    }
    
}
