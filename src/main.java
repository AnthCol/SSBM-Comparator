
package src; 

import javax.swing.*;
import java.awt.*;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 
/* FIX ME recreate character class and have main extend it. 

do all of the readfile stuff inside of Main's main. */
/*
        Indices (alphabetical order):
        0 = bowser, 1 = captain falcon, 2 = donkey kong, 3 = dr. mario, 4 = falco, 5 = fox, 6 = ganon, 7 = ICs, 8 = kirby, 9 = link, 10 = luigi, 11 = mario, 12 = marth, 
        7 = mew2, 14 = g&w, 15 = ness, 16 = peach, 17 = pichu, 18 = pika, 19 = puff, 20 = roy, 21 = samus, 22 = sheik, 23 = yoshi, 24 = yink, 25 = zelda
*/

// VALUE WILL BE SET AS NEGATIVE ONE IF IT IS UNAVAILABLE/INCALCULABLE

/* TO DO:
    Create the GUI with functional buttons. 
    Finish the charData.txt file (cringe! but needs to be done), hopefully can be done in a day 
*/

class Main extends Character{


    static void readFile (Character[] characters){
        //Character character = new Character(); 
        int index = 0; 
        try{
            //C:/Users/tonyc/OneDrive/University Files/Personal Projects/SSBM COMPARATOR/src/
            File file = new File ("./src/charData.txt"); 
            Scanner fileReader = new Scanner(file);
            while (index < 2 && fileReader.hasNextLine()){ 
                if (index == 1 || index == 2 || index == 3 || index == 7 || index == 14 || index == 24){ // indices for chars with more than one word in their name
                    characters[index].charName = fileReader.next(); 
                    characters[index].charName = characters[index].charName.concat(" "); 
                    characters[index].charName = characters[index].charName.concat(fileReader.next()); 
                }
                else{
                    characters[index].charName = fileReader.next(); 
                }
                for (int i = 0; i < 133; i++){
                    characters[index].values[i] = fileReader.nextFloat(); 
                }
                
                index += 1; 
            }
            fileReader.close(); 
        }   
        catch (FileNotFoundException error){
            System.out.println("File was unable to be read"); // need to make this some sort of pop-up in the gui  ** FIX ME **
            error.printStackTrace();
        } 
        return; 
    }
    
    public static void main(String args[]) {
        //ArrayList<Character> characters = new ArrayList<Character>(); 
        Character[] characters = new Character[26]; 
       /* double y = 5; 
        System.out.println(String.format("%.0f", y));  for a value without decimals */
        
        for (int i = 0; i < 26; i++){ // initialize everything so it can be passed to the readFile method
            characters[i] = new Character(); 
            characters[i].charName = "Temp"; 
            for (int x = 0; x < 133; x++){
                characters[i].values[x] = 0; 
            }
        }
        readFile(characters);  
     
        // so stuff will be accessed like characters.utiltEnding[0] for fox utilt end lag for example

        /* This array will contain all of the character data and will be passed to functions for manipulation
        The characters at the beginning here, will be */

        JFrame frame = new JFrame("SSBM Comparator"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

       // ImageIcon icon = new ImageIcon("images/icon.png");                ****UNCOMMENT LATER****
        
        JMenuBar menuBar = new JMenuBar();

        JMenu choiceOne = new JMenu("Compare Characters");
        JMenu choiceTwo = new JMenu("View");
        JMenu choiceThree = new JMenu ("Rank"); 
        JMenu choiceFour = new JMenu("Help"); 

        menuBar.add(choiceOne);
        menuBar.add(choiceTwo);
        menuBar.add(choiceThree); 
        menuBar.add(choiceFour); 



        JMenuItem choiceTwoOne = new JMenuItem("Tier List"); 
        JMenuItem choiceTwoTwo = new JMenuItem("Individual Character Data");  

        JMenuItem choiceThreeOne = new JMenuItem("Base Damage");  // pick a move when they click
        JMenuItem choiceThreeTwo = new JMenuItem ("Startup Frames");  // pick a move when they click
        JMenuItem choiceThreeThree = new JMenuItem ("Active Frames (Length)"); // pick a move when they click
        JMenuItem choiceThreeFour = new JMenuItem ("Ending Frames");  // pick a move when they click
        

        choiceTwo.add(choiceTwoOne); 
        choiceTwo.add(choiceTwoTwo); 


        choiceThree.add(choiceThreeOne); 
        choiceThree.add(choiceThreeTwo); 
        choiceThree.add(choiceThreeThree); 
        choiceThree.add(choiceThreeFour); 
        
        

        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Created by Anthony Colaiacovo, May 2022");
        panel.add(label); 
       /* JTextField tf = new JTextField(10); 
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        
        panel.add(tf);
        panel.add(send);
        panel.add(reset); */

    
        JTextArea ta = new JTextArea();

       
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

    }
}

class Character {
    String charName; 
    float[] values = new float[133]; 
}
    /*
    indices for float array:
    0 - jab1 dmg
    1 - jab1 startup
    2 - jab1 active
    3 - jab1 ending
    4 - 7 -> jab2
    8 - 11 -> jab3
    12 - 15 -> ftilt
    16 - 19 -> utilt
    20 - 23 -> dtilt
    24 - 27 -> dashAttack
    28 - 31 -> fsmash
    32 - 35 -> usmash
    36 - 39 -> dsmash  
    40 - 43 -> nair
    44 - 47 -> fair 
    48 - 51 -> bair
    52 - 55 -> uair
    56 - 59 -> dair
    60 - 63 -> neutralBGrounded
    64 - 67 -> neutralBAerial
    68 - 71 -> sideBGrounded
    72 - 75 -> sideBAerial
    76 - 79 -> upBGrounded
    80 - 83 -> upBAerial
    84 - 87 -> downBGrounded
    88 - 91 -> downBAerial
    // for the grabs 0 = startup, 1 = total frames
    92 - 93 -> standGrab
    94 - 95 -> dashGrab
    // back to normal now
    96 - 99 -> fthrow
    100 - 103 -> bthrow
    104 - 107 -> dthrow
    108 - 111 -> uthrow
    // in the following: 0 = startup, 1 = invuln (Active), 2 = end
    112 - 114 -> spotDodge
    115 - 117 -> backRoll
    118 - 120 -> forwardroll
    // for airdodge, 0 = startup, 1 = active, 2 = end, 3 = special land lag 
    121 - 124 -> airDodge
    125 -> weight
    126 -> ffSpeed
    127 -> dashSpeed
    128 -> runSpeed
    129 -> wavedashLen // rank
    130 -> pldif // perfect ledgefash intangibility frames
    131 -> jumpSquat
    132 -> wallJump // 1 yes, 0 no. 
    */
    



