package src; 

import javax.swing.*;
import java.awt.*;

class Main extends Character{

    public static void main(String args[]) {
        
        Character[] characters = new Character[26]; 
        populate(characters); 

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
    /*THERE IS NO WAY THERE IS NOT A BETTER WAY TO DO THIS LMFAO*/

    // if a character does not have a value that some sort of substitute value will be used. 
    // 0 = strong hit dmg 
    // 1 = Startup Frames
    // 2 = active frames (duration)
    // 3 = ending frames 

    /* the plan is to add a file in the source files, where the program will retrieve the data in that by calling the population function, 
    and fill out the array. I will need to manually input the data into the file, unforunately */ 

    String charName; 
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
    int[] standGrab = new int[4]; 
    int[] dashGrab = new int[4]; 
    /* in the following cases: 
    0 = startup
    1 = invuln frames (active)
    2 = end frames */
    int[]  spotDodgeDmg= new int[3];      
    int[] backRoll = new int[3]; 
    int[] forward = new int[3]; 
    int[] airDodge = new int[3]; 
 

    public static void populate(Character[] characters){
        /*
        Indices (alphabetical order):
        0 = captain falcon, 1 = dk, 2 = doc, 3 = falco, 4 = fox, 5 = ganon, 6 = ICs, 7 = kirby, 8 = bowser, 9 = link, 10 = luigi, 11 = mario, 12 = marth, 
        7 = mew2, 14 = g&w, 15 = ness, 16 = peach, 17 = pichu, 18 = pika, 19 = puff, 20 = roy, 21 = samus, 22 = sheik, 23 = yoshi, 24 = yink, 25 = zelda
        */
       
        // NEED TO READ FROM A FILE HERE, the file will be downloaded by the user in a folder. 

    }
}