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
                current.spritePath = br.readLine(); 
                variableNestedLoop(current.jabs, current.jabs.length, current.jabs[0].length);  // jabs 
                variableNestedLoop(current.tilts, current.tilts.length, current.tilts[0].length); // tilts
                variableSingleLoop(current.dashAttack, current.dashAttack.length); 
                variableNestedLoop(current.smashAttacks, current.smashAttacks.length, current.smashAttacks[0].length);     // smash attacks
                variableNestedLoop(current.aerials, current.aerials.length, current.aerials[0].length);    // aerials
               
               
                // FIXME -> for these two, we will need alternating logic logical not
                // File was setup so that its Grounded, Aerial, Grounded, Aerial CHANGE THIS 
                // LAST TO DO BECAUSE IT'S A PAIN FIXME FIXME FIXME
                // so a custom loop here will be needed since manually changing the file is a pain. 


                // outer loop: neutral, side, down, up  -> b attacks
                for (int i = 0; i < current.specialAttacksGrounded.length; i++){
                    for (int x = 0; x < current.specialAttacksGrounded.length; x++){
                        current.specialAttacksGrounded[i][x] = Integer.parseInt(br.readLine()); 
                    }
                    for (int x = 0; x < current.specialAttacksAerial.length; x++){
                        current.specialATtacksAerial[i][x] = Integer.parseInt(br.readLine()); 
                    }
                }

                
           //     variableNestedLoop(current.specialAttacksGrounded, current.specialAttacksGrounded.length, current.specialAttacksGrounded[0].length);     // specialAttacksGroudned
            //     variableNestedLoop(current.specialAttacksAerial, current.specialAttacksAerial.length, current.specialAttacksAerial[0].length);     // specialATtacksAerial
               
                // FIXME [MIGHT BE BETTER TO JUST LEAVE IT AS 8 SINCE THE HIGHEST DAMAGE VALUES ARE USED ELSEWHERE THROUGHOUT THE PROJECT]
                // Donkey Kong forward throw has three damages 7, 8 and 8.
                // TODO: make not of this change on the README 
                // In the charData.txt file the average is calculated. 
                // Options:
                // -> Make every single value a floating point for every character. 
                // -> Make DK throw the median (8%, since the throws are 7%, 8%, and 8%)
                // FOR NOW IT HAS BEEN CHANGED TO 8 (final decision will be made after the GUI stuff is done)
                // line 366 in charData.txt

                variableNestedLoop(current.grabs, current.grabs.length, current.grabs[0].length);    // grabs
                variableNestedLoop(current.grabThrows, current.grabThrows.length, current.grabThrows[0].length);    // grabthrows
                variableNestedLoop(current.dodgesRolls, current.dodgesRolls.length, current.dodgesRolls[0].length);     // dodges & rolls
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
                array[i] = Float.parseFloat(br.readLine()); 
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


    private void variableNestedLoop(int[][] array, int outer, int inner){
        try{
            for (int i = 0; i < outer; i++){
                for (int x = 0; x < inner; x++){
                    array[i][x] = Integer.parseInt(br.readLine()); 
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage()); 
        }
    }

    

}
