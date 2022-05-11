
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
        0 = bowser, 1 = captain falcon, 2 = doc, 3 = dk, 4 = falco, 5 = fox, 6 = ganon, 7 = ICs, 8 = kirby, 9 = link, 10 = luigi, 11 = mario, 12 = marth, 
        7 = mew2, 14 = g&w, 15 = ness, 16 = peach, 17 = pichu, 18 = pika, 19 = puff, 20 = roy, 21 = samus, 22 = sheik, 23 = yoshi, 24 = yink, 25 = zelda
*/

// VALUE WILL BE SET AS NEGATIVE ONE IF IT IS UNAVAILABLE/INCALCULABLE

class Main extends Character{


    static Character[] readFile (Character[] characters){
        //Character character = new Character(); 
        int index = 0; 
        try{
            //C:/Users/tonyc/OneDrive/University Files/Personal Projects/SSBM COMPARATOR/src/
            File file = new File ("C:/Users/tonyc/OneDrive/University Files/Personal Projects/SSBM COMPARATOR/src/charData.txt"); 
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){
                characters[index].charName = fileReader.nextLine();
                System.out.println("PRINTING CHAR NAME: " + characters[index].charName); 
                for (int i = 0; i < 4; i++){
                    characters[index].jab1[i] = fileReader.nextInt(); 
                    System.out.println("PRINTING " + index + " JAB1[" + i + "]"); 
                    System.out.println(characters[index].jab1[i]); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].jab2[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].jab3[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].ftilt[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].utilt[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].dtilt[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].dashAttack[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].fsmash[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].usmash[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].dsmash[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].nair[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].fair[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].bair[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].uair[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].dair[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].neutralBGrounded[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].neutralBAerial[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].sideBGrounded[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].sideBAerial[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].upBGrounded[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].upBAerial[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].downBGrounded[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].downBAerial[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 2; i++){
                    characters[index].standGrab[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 2; i++){
                    characters[index].dashGrab[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].fthrow[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].bthrow[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].dthrow[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].uthrow[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 3; i++){
                    characters[index].spotDodge[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 3; i++){
                    characters[index].backRoll[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 3; i++){
                    characters[index].forwardRoll[i] = fileReader.nextInt(); 
                }
                for (int i = 0; i < 4; i++){
                    characters[index].airDodge[i] = fileReader.nextInt(); 
                }
                characters[index].weight = fileReader.nextInt(); 
                characters[index].ffSpeed = fileReader.nextDouble(); 
                characters[index].dashSpeed = fileReader.nextDouble(); 
                characters[index].runSpeed = fileReader.nextDouble(); 
                characters[index].wavedashLen = fileReader.nextInt();  // rank
                characters[index].pldif = fileReader.nextInt(); 
                characters[index].jumpSquat = fileReader.nextInt(); 
                characters[index].wallJump = fileReader.nextInt(); 
                System.out.println("PRINTING WALLJUMP: " + characters[index].wallJump); 
                index += 1; 
            }
            fileReader.close(); 
        }   
        catch (FileNotFoundException error){
            System.out.println("File was unable to be read"); // need to make this some sort of pop-up in the gui  ** FIX ME **
            error.printStackTrace();
        }
        System.out.println("PRINTING INDEX: " + index);
        
        return characters; 
    }
    
    public static void main(String args[]) {
        //ArrayList<Character> characters = new ArrayList<Character>(); 
        Character[] characters = new Character[26]; 
        int x = 0; 
        /* this is an absolute fucking abomination of a way to initialize variables, but I currently do not know of any other way to do it :P, will 
        refactor in the future hopefully */
        for (int i = 0; i < 26; i++){
            characters[i] = new Character(); 
            characters[i].charName = "Temp"; 
            for (x = 0; x < 4; x++){
                characters[i].jab1[x] = 1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].jab2[x] = 1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].jab3[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].ftilt[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].utilt[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].dtilt[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].dashAttack[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].fsmash[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].usmash[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].dsmash[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].nair[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].fair[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].bair[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].uair[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].dair[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].neutralBGrounded[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].neutralBAerial[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].sideBGrounded[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].sideBAerial[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].upBGrounded[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].upBAerial[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].downBGrounded[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].downBAerial[x] =1; 
            }
            for (x = 0; x < 2; x++){
                characters[i].standGrab[x] =1; 
            }
            for (x = 0; x < 2; x++){
                characters[i].dashGrab[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].fthrow[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].bthrow[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].dthrow[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].uthrow[x] =1; 
            }
            for (x = 0; x < 3; x++){
                characters[i].spotDodge[x] =1; 
            }
            for (x = 0; x < 3; x++){
                characters[i].backRoll[x] =1; 
            }
            for (x = 0; x < 3; x++){
                characters[i].forwardRoll[x] =1; 
            }
            for (x = 0; x < 4; x++){
                characters[i].airDodge[x] =1; 
            }
            characters[i].weight = 1; 
            characters[i].ffSpeed = 1.0; 
            characters[i].dashSpeed = 1.0; 
            characters[i].runSpeed = 1.0; 
            characters[i].wavedashLen = 1;   // rank
            characters[i].pldif = 1; 
            characters[i].jumpSquat = 1;  
            characters[i].wallJump = 1; 
        }

        readFile(characters);  
        System.out.println("PRINTING IN MAIN: " + characters[0].charName); 
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
    // if a character does not have a value that some sort of substitute value will be used. 
    // 0 = strong hit dmg 
    // 1 = Startup Frames
    // 2 = active frames (duration)
    // 3 = ending frames 

    /* the plan is to add a file in the source files, where the program will retrieve the data in that by calling the population function, 
    and fill out the array. I will need to manually input the data into the file, unforunately */ 

    String charName = "test"; 
    int[] jab1 = new int[4];
    int[] jab2 = new int[4]; 
    int[] jab3 = new int[4]; 
    int[] ftilt = new int[4];  
    int[] utilt = new int[4]; 
    int[] dtilt = new int[4]; 
    int[] dashAttack = new int[4]; 
    int[] fsmash = new int[4]; 
    int[] usmash = new int[4]; 
    int[] dsmash = new int[4]; 
    int[] nair = new int[4]; 
    int[] fair = new int[4]; 
    int[] bair = new int[4]; 
    int[] uair = new int[4]; 
    int[] dair = new int[4]; 
    int[] neutralBGrounded = new int[4]; 
    int[] neutralBAerial = new int[4]; 
    int[] sideBGrounded = new int[4]; 
    int[] sideBAerial = new int[4]; 
    int[] upBGrounded = new int[4]; 
    int[] upBAerial = new int[4]; 
    int[] downBGrounded = new int[4]; 
    int[] downBAerial = new int[4]; 
    // for the grabs, 0 = startup, 1 = total frames
    int[] standGrab = new int[2]; 
    int[] dashGrab = new int[2]; 
    int[] fthrow = new int[4]; 
    int[] bthrow = new int[4]; 
    int[] dthrow = new int[4]; 
    int[] uthrow = new int[4]; 
    /* in the following cases: 
    0 = startup
    1 = invuln frames (active)
    2 = end frames */
    int[] spotDodge = new int[3];      
    int[] backRoll = new int[3]; 
    int[] forwardRoll = new int[3]; 
    int[] airDodge = new int[4]; 
    // for air dodge, 0 = startup, 1 = active/invuln, 2 = end lag, 3 = special land lag 
    int weight; 
    double ffSpeed; 
    double dashSpeed; 
    double runSpeed; 
    int wavedashLen; // rank
    int pldif; // perfect ledgedash intangibility frames 
    int jumpSquat; 
    int wallJump; // 1 = yes, 0 = no. 
}


