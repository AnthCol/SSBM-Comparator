package src; 

import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path; 


// FIXME Update GALINT stats 


public class FileReader {

    private Path path; 
    private BufferedReader br; 


    public FileReader(){
        path = FileSystems.getDefault().getPath("assets", "charData.txt"); 
    }

    public void readCharData(Character[] characters){

        try{
            br = Files.newBufferedReader(path); 

            for (Character current : characters){
                current.characterName = br.readLine(); //name
                System.out.println("printing char name: " + current.characterName); 
                variableDoubleLoop(current.jabs, current.jabs.length, current.jabs[0].length);  // jabs 
                variableDoubleLoop(current.tilts, current.tilts.length, current.tilts[0].length); // tilts
                variableSingleLoop(current.dashAttack, current.dashAttack.length); 
                variableDoubleLoop(current.smashAttacks, current.smashAttacks.length, current.smashAttacks[0].length);     // smash attacks
                variableDoubleLoop(current.aerials, current.aerials.length, current.aerials[0].length);    // aerials
               
               
                // FIXME -> for these two, we will need alternating logic. 
                // File was setup so that its Grounded, Aerial, Grounded, Aerial. 
                // so a custom loop here will be needed since manually changing the file is a pain. 
                variableDoubleLoop(current.specialAttacksGrounded, current.specialAttacksGrounded.length, current.specialAttacksGrounded[0].length);     // specialAttacksGroudned
                variableDoubleLoop(current.specialAttacksAerial, current.specialAttacksAerial.length, current.specialAttacksAerial[0].length);     // specialATtacksAerial
               
               
                variableDoubleLoop(current.grabs, current.grabs.length, current.grabs[0].length);    // grabs
                variableDoubleLoop(current.grabThrows, current.grabThrows.length, current.grabThrows[0].length);    // grabthrows
                variableDoubleLoop(current.dodgesRolls, current.dodgesRolls.length, current.dodgesRolls[0].length);     // dodges & rolls
                variableSingleLoop(current.airDodge, current.airDodge.length); 
                variableSingleLoop(current.misc, current.misc.length); 
            }

            br.close(); 
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



    private void variableSingleLoop(float[] array, int length){
        try{
            for (int i = 0; i < length; i++){
                array[i] = Integer.parseInt(br.readLine()); 
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage()); 
        }
    }



    private void variableSingleLoop(int[] array, int length){
        try{
            for (int i = 0; i < length; i++){
                array[i] = Integer.parseInt(br.readLine()); 
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage()); 
        }
    }


    private void variableDoubleLoop(int[][] array, int outer, int inner){
        try{
            for (int i = 0; i < outer; i++){
                for (int x = 0; x < inner; x++){
                    array[i][x] = Integer.parseInt(br.readLine()); 
                    System.out.println(array[i][x]); 
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage()); 
        }
    }

    

}
