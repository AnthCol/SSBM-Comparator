
package src; 

import javax.swing.*;

import java.awt.*;
import java.io.File; 
import java.io.FileNotFoundException;

import java.util.Scanner; 
import java.awt.event.*; 
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

public class Main extends Character {

   
    public static void main(String args[]) {
        
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
        
        JFrame frame = new JFrame("SSBM Comparator"); 
        JMenuBar menuBar = new JMenuBar();
        ImageIcon icon = new ImageIcon("./images/icon.png"); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setMinimumSize(new Dimension(450, 450)); 
        frame.setIconImage(icon.getImage()); 

        JMenu compare = new JMenu("Compare Characters");
        JMenu view = new JMenu("View");
        JMenu rank = new JMenu ("Rank"); 
        JMenu help = new JMenu("Help"); 
    
        menuBar.add(compare);
        menuBar.add(view);
        menuBar.add(rank); 
        menuBar.add(help); 

        JMenuItem twoChars = new JMenuItem ("Two Characters"); 
        JMenuItem threeChars = new JMenuItem("Three Characters"); 
        JMenuItem fourChars = new JMenuItem("Four Characters"); 
        compare.add(twoChars); 
        compare.add(threeChars); 
        compare.add(fourChars); 

        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Created by Anthony Colaiacovo, May 2022");
        panel.add(label); 


        
        twoChars.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("2 clicked"); 
            }
        });
        threeChars.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("3 clicked"); 
            }
        });
        fourChars.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("4 clicked"); 
            }
        });

        /* make a sub menu for compare and ask two, three, or four characters? */
        JMenuItem tierList = new JMenuItem("Tier List"); 
        tierList.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("tier list clicked"); 
                JTextPane tierListPane = new JTextPane(); 
                tierListPane.setContentType("text/html");
                tierListPane.setText("13th Official SSBM Tier List\r\n As of March 29th, 2021");
                tierListPane.setEditable(false);
                frame.getContentPane().removeAll();
              //  frame.getContentPane().add(BorderLayout.SOUTH, panel);
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.getContentPane().add(BorderLayout.CENTER, tierListPane);  
                frame.setVisible(true); 
            }
        }); 
        /*
        Indices (alphabetical order):
        0 = bowser, 1 = captain falcon, 2 = donkey kong, 3 = dr. mario, 4 = falco, 5 = fox, 6 = ganon, 7 = ICs, 8 = kirby, 9 = link, 10 = luigi, 11 = mario, 12 = marth, 
        7 = mew2, 14 = g&w, 15 = ness, 16 = peach, 17 = pichu, 18 = pika, 19 = puff, 20 = roy, 21 = samus, 22 = sheik, 23 = yoshi, 24 = yink, 25 = zelda
*/
        JMenuItem indivData = new JMenuItem("Individual Character Data");  
        indivData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("indivData clicked"); 
            }
        });
            
        view.add(tierList); 
        view.add(indivData); 
    


        JMenuItem baseDmg = new JMenuItem("Base Damage");  // pick a move when they click
        baseDmg.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JTextPane baseDmgPane = new JTextPane(); 
                baseDmgPane.setContentType("text/html");
                baseDmgPane.setText("Select a move: ");
                baseDmgPane.setEditable(false);
                frame.getContentPane().removeAll(); 
             //   frame.getContentPane().add(BorderLayout.SOUTH, panel);
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.getContentPane().add(BorderLayout.CENTER, baseDmgPane);  
                frame.setVisible(true); 
                System.out.println("baseDmg clicked"); 
            }
        }); 


        JMenuItem startingF = new JMenuItem ("Startup Frames");  // pick a move when they click
        startingF.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("starting frames clicked"); 
            }
        });

        JMenuItem activeF = new JMenuItem ("Active Frames (Length)"); // pick a move when they click
        activeF.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("active frames clicked"); 
            }
        });

        JMenuItem endingF = new JMenuItem ("Ending Frames");  // pick a move when they click
        endingF.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("ending frames clicked"); 
            }
        });

  

        rank.add(baseDmg); 
        rank.add(startingF); 
        rank.add(activeF); 
        rank.add(endingF);

        JMenuItem about = new JMenuItem ("About the Creator"); 
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("about the creator clicked"); 
            }
        });
        JMenuItem howToUse = new JMenuItem ("How To Use"); 
        howToUse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("how to use clicked"); 
            }
        });
        
        help.add(howToUse); 
        help.add(about); 


      
        
        JTextPane defaultTP = new JTextPane();
        
        Font defaultFont = new Font("Tahoma", Font.PLAIN, 40); 
        defaultTP.setBackground(Color.LIGHT_GRAY); 
        defaultTP.setText("Welcome to SSBM Comparator"); 
        defaultTP.setFont(defaultFont); 
        defaultTP.getCaret().setVisible(false);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, defaultTP);
        frame.setVisible(true);
        
    }

}

class Character{
    String charName; 
    float[] values = new float[133]; 

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