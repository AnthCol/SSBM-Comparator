package src; 

import java.io.BufferedReader; 
import java.io.FileNotFoundException; 

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path; 


// FIXME Update GALINT stats 


public class FileReader {

    private Path path; 
    private BufferedReader br; 


    public FileReader(){
        path = FileSystems.getDefault().getPath("assets", "charData.txt"); 
        br = Files.newBufferedReader(path); 
    }

    public void readCharData(Character[] characters){

        try{
            readFile(characters); 
        }
        catch(FileNotFoundException e){
            // FIXME JOptionPane to let the user know
            // System exit AFTER THEY CLICK ON THE OPTION PANE 
            System.out.println(e.getMessage()); 
            System.exit(1); 

        }
        catch (IOException e){
            //JOptionPane FIXME
            // System.exit() AFTER THEY CLICK ON THE OPTION PANE 
            System.out.println(e.getMessage()); 

            System.exit(1); 
        }


        return; 
    }


    private void readFile(Character[] characters){
    
        for (Character current : characters){
            current.characterName = br.nextLine();  // name 
            variableLoop(current.jabs, current.jabs.length, current.jabs[0].length);  // jabs 
            variableLoop(current.tilts, current.tilts.length, current.tilts[0].length); // tilts
            for (int i = 0; i < current.dashAttack.length; i++){ // READ HERE BECAUSE 1D ARRAY     // dash attack
                current.dashAttack[i] = Integer.parseInt(br.nextLine()); 
            } 
            variableLoop(current.smashAttacks, current.smashAttacks.length, current.smashAttacks[0].length);     // smash attacks
            variableLoop(current.aerials, current.aerials.length, current.aerials[0].length);    // aerials
            variableLoop(current.specialAttacksGrounded, current.specialAttacksGrounded.length, current.specialAttacksGrounded[0].length);     // specialAttacksGroudned
            variableLoop(current.specialAttacksAerial, current.specialAttacksAerial.length, current.specialAttacksAerial[0].length);     // specialATtacksAerial
            variableLoop(current.grabs, current.grabs.length, current.grabs[0].length);    // grabs
            variableLoop(current.grabThrows, current.grabThrows.length, current.grabThrows[0].length);    // grabthrows
            variableLoop(current.dodgesRolls, current.dodgesRolls.length, current.dodgesRolls[0].length);     // dodges & rolls
            for (int i = 0; i < current.misc.length; i++){      // READ HERE BECAUSE FLOATS     // misc
                current.misc[i] = Float.parseFloat(br.nextLine()); 
            }
        }
    }

    private void variableLoop(int[][] array, int outer, int inner){
        for (int i = 0; i < outer; i++){
            for (int x = 0; x < inner; x++){
                array[i][x] = Integer.parseInt(br.nextLine()); 
            }
        }
    }

}
