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
            variableLoop(current.jabs, current.jabs.size(), current.jabs[0].size());  // jabs 
            variableLoop(current.tilts, current.tilts.size(), current.tilts[0].size()); // tilts
            for (int i = 0; i < 4; i++){ // READ HERE BECAUSE 1D ARRAY     // dash attack
                current.dashAttack[i] = Integer.parseInt(br.nextLine()); 
            } 
            variableLoop(current.smashAttacks, current.smashAttacks.size(), current.smashAttacks[0].size());     // smash attacks
            variableLoop(current.aerials, current.aerials.size(), current.aerials[0].size());    // aerials
            variableLoop(current.specialAttacksGrounded, current.specialAttacksGrounded.size(), current.specialAttacksGrounded[0].size());     // specialAttacksGroudned
            variableLoop(current.specialAttacksAerial, current.specialAttacksAerial.size(), current.specialAttacksAerial[0].size());     // specialATtacksAerial
            variableLoop(current.grabs, current.grabs.size(), current.grabs[0].size());    // grabs
            variableLoop(current.grabThrows, current.grabThrows.size(), current.grabThrows[0].size());    // grabthrows
            variableLoop(current.dodgesRolls, current.dodgesRolls.size(), current.dodgesRolles[0].size());     // dodges & rolls
            for (int i = 0; i < 8; i++){      // READ HERE BECAUSE FLOATS     // misc
                current.misc[i] = Float.parseFloat(br.nextLine()); 
            }
        }

        return; 
    }


    private void variableLoop(int[][] array, int outer, int inner){
        for (int i = 0; i < inner; i++){
            for (int x = 0; x < outer; x++){
                array[i][x] = Integer.parseInt(br.nextLine()); 
            }
        }
    }

}
