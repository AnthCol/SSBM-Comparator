
package src; 

import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.awt.event.*; 
//import javax.swing.plaf.metal.MetalLookAndFeel;



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

public class Main extends Character{
    
   
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

        readFile(characters); // the reason I chose to read from a file here instead of actually just hardcoding the values is to learn how files work in java. 
      /*  try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ex) {
            // swag
        }  */
        

        // **FIX ME** BE ABLE TO COMPARE CHARACTERS TO AVERAGES 

        String[] damagingMoves = {
            "Jab 1", "Jab 2", "Jab 3", "Forward Tilt", "Up Tilt", "Down Tilt", 
            "Dash Attack", "Forward Smash", "Up Smash", "Down Smash", "Neutral Air", "Forward Air", "Back Air", "Up Air", "Down Air", 
            "Grounded Neutral B", "Aerial Neutral B", "Grounded Side B", "Aerial Side B", "Grounded Up B", "Aerial Up B", "Grounded Down B", "Aerial Down B", 
            "Standing Grab", "Dash Grab", "Forward Throw", "Back Throw", "Down Throw", "Up Throw"
        }; 
        String[] nonDamagingMoves = {
            "Spot Dodge", "Backwards Roll", "Forwards Roll", "Air Dodge"
        }; 
        String[] charAttributes = {
            "Weight", "Fast Fall Speed", "Dash Speed", "Run Speed", "Wavedash Length (rank/26)", 
            "Perfect Ledgedash Intangibility Frames", "Jump Squat", "Wall Jump"
        }; 

        String[] rankingOptions = {
            "Damage", "Startup Frames", "Active Frames", "Ending Frames"
        };
        // might need to move backwards and fowards roll around with air dodge so that spot dodge and air dodge are next to one another
        // and that way it will be less scuffed, this involves using the charData.txt file entry properly as well. 


        String[] charOptions = {
            "Fox", "Marth", "Jigglypuff", "Falco", 
            "Sheik", "Captain Falcon",  "Peach",
            "Ice Climbers", "Pikachu", "Yoshi", "Samus", 
            "Luigi", "Dr. Mario", 
            "Ganondorf", "Mario", 
            "Donkey Kong", "Young Link", "Link",   "Mr. Game&Watch",  "Mewtwo", 
            "Roy",   "Pichu",  "Ness",    "Zelda", 
            "Kirby",   "Bowser"
        }; 

        String[] imageSources = new String[26]; 
        // ** FIX ME ** would be nice to make these load faster somehow. They don't load locally for some reason. 
        imageSources[0] = "<img src='file:images/FoxHeadSSBM.png'>"; 
        imageSources[1] = "<img src='file:images/MarthHeadSSBM.png'>"; 
        imageSources[2] = "<img src='file:images/JigglypuffHeadSSBM.png'>"; 
        imageSources[3] = "<img src='file:images/FalcoHeadSSBM.png'>"; 

        imageSources[4] = "<img src='file:images/SheikHeadSSBM.png'>"; 
        imageSources[5] = "<img src='file:images/CaptainFalconHeadSSBM.png'>"; 
        imageSources[6] = "<img src='file:images/PeachHeadSSBM.png'>"; 

        imageSources[7] = "<img src='file:images/IceClimbersHeadSSBM.png'>"; 
        imageSources[8] = "<img src='file:images/PikachuHeadSSBM.png'>"; 
        imageSources[9] = "<img src='file:images/YoshiHeadSSBM.png'>"; 
        imageSources[10] = "<img src='file:images/SamusHeadSSBM.png'>"; 

        imageSources[11] = "<img src='file:images/LuigiHeadSSBM.png'>"; 
        imageSources[12] = "<img src='file:images/DrMarioHeadSSBM.png'>"; 

        imageSources[13] = "<img src='file:images/GanondorfHeadSSBM.png'>"; 
        imageSources[14] = "<img src='file:images/MarioHeadSSBM.png'>"; 

        imageSources[15] = "<img src='file:images/DonkeyKongHeadSSBM.png'>"; 
        imageSources[16] = "<img src='file:images/YoungLinkHeadSSBM.png'>"; 
        imageSources[17] = "<img src='file:images/LinkHeadSSBM.png'>"; 
        imageSources[18] = "<img src='file:images/MrGame&WatchHeadSSBM.png'>"; 

        imageSources[19] = "<img src='file:images/MewtwoHeadSSBM.png'>"; 
        imageSources[20] = "<img src='file:images/RoyHeadSSBM.png'>"; 
        imageSources[21] = "<img src='file:images/PichuHeadSSBM.png'>"; 
        imageSources[22] = "<img src='file:images/NessHeadSSBM.png'>"; 
        imageSources[23] = "<img src='file:images/ZeldaHeadSSBM.png'>"; 

        imageSources[24] = "<img src='file:images/KirbyHeadSSBM.png'>"; 
        imageSources[25] = "<img src='file:images/BowserHeadSSBM.png'>"; 

        JFrame frame = new JFrame("SSBM Comparator"); 
       // JViewport viewport = new JViewport();
     /*   JScrollBar vertical = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500); 
        vertical.addAdjustmentListener(new MyAdjustmentListener( )); // do something with scrollpane **FIXEME** */
        // somewith with JScrollPane and ViewPort

        // will need JScrollPane for some of the other pages in the app 
        JMenuBar menuBar = new JMenuBar();
        ImageIcon icon = new ImageIcon("./images/icon.png"); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 615);
        frame.setMinimumSize(new Dimension(950, 600)); 
        frame.setIconImage(icon.getImage()); 

        JMenu compare = new JMenu("Compare");
        JMenu view = new JMenu("View");
        JMenu rank = new JMenu ("Rank Moves"); 
        JMenu help = new JMenu("Help"); 
    
        menuBar.add(compare);
        menuBar.add(view);
        menuBar.add(rank); 
        menuBar.add(help); 

        JMenuItem vsCharacters = new JMenuItem ("vs Characters"); 
        JMenuItem vsAverage = new JMenuItem("vs Averages"); 
       // JMenuItem threeChars = new JMenuItem("Three Characters"); 
    //    JMenuItem fourChars = new JMenuItem("Four Characters");             ** FIX ME, may not be capable of doing four cahracters, considering how java swing works, we'll see
        compare.add(vsCharacters); 
        compare.add(vsAverage); 

       // compare.add(threeChars); 
      //  compare.add(fourChars);  

        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Created by Anthony Colaiacovo, May 2022");
        panel.add(label); 


        
        vsCharacters.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            
                System.out.println("char select clicked"); 
                JTextPane comparePane = new JTextPane(); 
                JScrollPane compareScroll = new JScrollPane(comparePane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 

                comparePane.setLayout(new GridBagLayout()); 

                GridBagConstraints constraints = new GridBagConstraints(); 
                
                JButton addChar1 = new JButton("+"); 
                constraints.weightx = 0.5; 
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.gridx = 0; 
                constraints.gridy = 0; 
                comparePane.add(addChar1, constraints); 

                JButton addChar2 = new JButton("+"); 
                constraints.gridx = 1;
                constraints.gridy = 0; 
                comparePane.add(addChar2, constraints); 

                JButton addChar3 = new JButton("+"); 
                constraints.gridx = 2;
                constraints.gridy = 0; 
                comparePane.add(addChar3, constraints); 

                JButton addChar4 = new JButton("+"); 
                constraints.gridx = 3;
                constraints.gridy = 0; 
                comparePane.add(addChar4, constraints);

                JTextPane char1 = new JTextPane(); 
                char1.setContentType("text/html"); 
             //   constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.ipady = 450; 
                constraints.weightx = 0.5; 
                constraints.gridx = 0; 
                constraints.gridy = 1; 
                comparePane.add(char1, constraints);  
                char1.setBackground(Color.LIGHT_GRAY); 
                char1.setText("<br>"); 
                char1.setEditable(false);

                JTextPane char2 = new JTextPane(); 
                char2.setContentType("text/html");
                constraints.gridx = 1; 
                constraints.gridy = 1; 
                comparePane.add(char2, constraints); 
                char2.setBackground(Color.LIGHT_GRAY); 
                char2.setText("<br>"); 
                char2.setEditable(false);

                JTextPane char3 = new JTextPane(); 
                char3.setContentType("text/html"); 
                constraints.gridx = 2; 
                constraints.gridy = 1; 
                comparePane.add(char3, constraints); 
                char3.setBackground(Color.LIGHT_GRAY); 
                char3.setText("<br>"); 
                char3.setEditable(false); 

                JTextPane char4 = new JTextPane(); 
                char4.setContentType("text/html"); 
                constraints.gridx = 3; 
                constraints.gridy = 1; 
                comparePane.add(char4, constraints); 
                char4.setBackground(Color.LIGHT_GRAY); 
                char4.setText("<br>"); 
                char4.setEditable(false);
               
                // array of JComboBox's to make this less code????? is that possible???? **FIX ME**
                
                addChar1.addActionListener (new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        System.out.println("CHAR 1 ADDITION CLICKED"); 
                        JComboBox<String> char1Combo = new JComboBox<>(charOptions); 
                        
                        /*GridBagConstraints constraints2 = new GridBagConstraints(); 
                        constraints2.fill = GridBagConstraints.HORIZONTAL;  */
                        char1.removeAll(); //????????????????????????????????????????????????????????????????????????????????????????????
                        char1.setText(""); //????????????????????????????????????????????????????????????????????????????????????????????
                        char1Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); // get content pane of char1 width and divide it by two to centre it ?? **fix me** 
                        // OR WHOLE FRAME 1/4 OF IT LIKE DONE WITH INDIIVDIAUL CAR AND HALF OF IT 
                        char1.add(char1Combo); 
                        char1.setVisible(true); 

                           /*
                        constraints.fill = GridBagConstraints.HORIZONTAL; 
                        constraints.ipady = 450; // remember, might need to change this value 
                        constraints.weightx = 0.5; 
                        constraints.gridx = 0; 
                        constraints.gridy = 1; 
                        char1Combo.setBounds(30, 50, 130, 30); 
                        char1Combo.setVisible(true); 
                        char1.setText(""); 
                        char1.add(char1Combo); 
                        comparePane.add(char1, constraints);  */
                        // ADD ALL THE GARBO HERE **fix me
                      //  frame.pack();  // something with frame pack here is weird. 
                        char1Combo.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent event){
                                System.out.println("CHAR1 COMPARISION COMBO BOX CLICKED"); 
                          /* when this is clicked, all of the buttons get removed, do i need
                          to add them back? */
                              
                                int index = 0; 
                                String selection = char1Combo.getSelectedItem().toString(); // should it not alreayd be a string???? **FIX ME**
                                for (int i = 0; i < 26; i++){
                                    if (selection == characters[i].charName){
                                        index = i; 
                                        i = 26; 
                                    }
                                }
                        
                                String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                                tempString = tempString + "width = '40' height ='40'>"; 
                                String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                                "<br><strong>&nbsp Jab 1:</strong>" + 
                                "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                                "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                                "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                                "<br> &nbsp Ending Frames: " + characters[index].values[3];  
                                // maybe turn this big thing into a string so it can be re-used **fix me**
                                char1.setText(compareText); 
                            
                                // SCROLL PANE DOES NOT WORK, AND THIS LOOKS AWFUL. NEED TO MAKE IT SO ADDITION BUTTONS DONT GO AWAY WHEN YOU SELECT A CHARACTER. 
                            }
                        }); 

                    }
                }); 
                addChar2.addActionListener (new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JComboBox<String> char2Combo = new JComboBox<>(charOptions); 
                        char2.removeAll(); 
                        char2.setText(""); 
                        char2Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); 
                        char2.add(char2Combo); 
                        char2Combo.addActionListener(new ActionListener(){

                        

                            public void actionPerformed(ActionEvent event){
                                System.out.println("CHAR1 COMPARISION COMBO BOX CLICKED"); 
                          /* when this is clicked, all of the buttons get removed, do i need
                          to add them back? */
                              
                                int index = 0; 
                                String selection = char2Combo.getSelectedItem().toString(); // should it not alreayd be a string???? **FIX ME**
                                for (int i = 0; i < 26; i++){
                                    if (selection == characters[i].charName){
                                        index = i; 
                                        i = 26; 
                                    }
                                }
                        
                                String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                                tempString = tempString + "width = '40' height ='40'>"; 
                                String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                                "<br><strong>&nbsp Jab 1:</strong>" + 
                                "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                                "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                                "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                                "<br> &nbsp Ending Frames: " + characters[index].values[3];  
                                // maybe turn this big thing into a string so it can be re-used **fix me**
                                char2.setText(compareText); 
                            
                                // SCROLL PANE DOES NOT WORK, AND THIS LOOKS AWFUL. NEED TO MAKE IT SO ADDITION BUTTONS DONT GO AWAY WHEN YOU SELECT A CHARACTER. 
                            }
                        }); 
                    }
                }); 
                addChar3.addActionListener (new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JComboBox<String> char3Combo = new JComboBox<>(charOptions); 
                        char3.removeAll(); 
                        char3.setText(""); 
                        char3Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); 
                        char3.add(char3Combo); 
                        char3Combo.addActionListener(new ActionListener(){

                        

                            public void actionPerformed(ActionEvent event){
                                System.out.println("CHAR1 COMPARISION COMBO BOX CLICKED"); 
                          /* when this is clicked, all of the buttons get removed, do i need
                          to add them back? */
                              
                                int index = 0; 
                                String selection = char3Combo.getSelectedItem().toString(); // should it not alreayd be a string???? **FIX ME**
                                for (int i = 0; i < 26; i++){
                                    if (selection == characters[i].charName){
                                        index = i; 
                                        i = 26; 
                                    }
                                }
                        
                                String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                                tempString = tempString + "width = '40' height ='40'>"; 
                                String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                                "<br><strong>&nbsp Jab 1:</strong>" + 
                                "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                                "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                                "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                                "<br> &nbsp Ending Frames: " + characters[index].values[3];  
                                // maybe turn this big thing into a string so it can be re-used **fix me**
                                char3.setText(compareText); 
                            
                                // SCROLL PANE DOES NOT WORK, AND THIS LOOKS AWFUL. NEED TO MAKE IT SO ADDITION BUTTONS DONT GO AWAY WHEN YOU SELECT A CHARACTER. 
                            }
                        }); 
                    }
                }); 
                addChar4.addActionListener (new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JComboBox<String> char4Combo = new JComboBox<>(charOptions); 
                        char4.removeAll(); 
                        char4.setText(""); 
                        char4Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); 
                        char4.add(char4Combo); 
                        char4Combo.addActionListener(new ActionListener(){

                            public void actionPerformed(ActionEvent event){
                                System.out.println("CHAR1 COMPARISION COMBO BOX CLICKED"); 
                          /* when this is clicked, all of the buttons get removed, do i need
                          to add them back? */
                              
                                int index = 0; 
                                String selection = char4Combo.getSelectedItem().toString(); // should it not alreayd be a string???? **FIX ME**
                                for (int i = 0; i < 26; i++){
                                    if (selection == characters[i].charName){
                                        index = i; 
                                        i = 26; 
                                    }
                                }
                        
                                String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                                tempString = tempString + "width = '40' height ='40'>"; 
                                String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                                "<br><strong>&nbsp Jab 1:</strong>" + 
                                "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                                "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                                "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                                "<br> &nbsp Ending Frames: " + characters[index].values[3];  
                                // maybe turn this big thing into a string so it can be re-used **fix me**
                                char4.setText(compareText); 
                            
                                // SCROLL PANE DOES NOT WORK, AND THIS LOOKS AWFUL. NEED TO MAKE IT SO ADDITION BUTTONS DONT GO AWAY WHEN YOU SELECT A CHARACTER. 
                            }
                        }); 
                    }
                }); 
                comparePane.setEditable(false);
                comparePane.setBackground(Color.LIGHT_GRAY); 
                frame.getContentPane().removeAll();
                frame.add(compareScroll);      
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.setVisible(true); 

            }
            
        });
   

        vsAverage.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("vs averages clicked"); 
                JTextPane averagePane = new JTextPane(); 
                averagePane.setLayout(new GridBagLayout());
                averagePane.setContentType("text/html"); 
                averagePane.setBackground(Color.LIGHT_GRAY);
                averagePane.setEditable(false); 
                JScrollPane averageScroll = new JScrollPane(averagePane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                GridBagConstraints constraints = new GridBagConstraints();  
                JComboBox<String> charSelect = new JComboBox<>(charOptions); 

                JTextPane left = new JTextPane(); 
                JTextPane right = new JTextPane(); 

                
                constraints.weightx = 0.5; 
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.ipady = 400; 
                constraints.ipadx = 70; 
                constraints.gridx = 0; 
                constraints.gridy = 0;
                left.setContentType("text/html"); 
                left.setBackground(Color.LIGHT_GRAY); 
                left.setText("<center><b><br>Select a character</b></center>"); 
                left.setEditable(false); 
                
                charSelect.setBounds(left.getWidth() + 177, 60, 130, 30); 
                left.add(charSelect); 
                averagePane.add(left, constraints); 

                constraints.gridx = 1; 
                constraints.gridy = 0; 
                right.setContentType("text/html"); 
                right.setBackground(Color.LIGHT_GRAY); 
                right.setEditable(false); 
                right.setText("<center> <b>Averages: </b></center>"); 

                // ** FIX ME ** need to add the code to calculate the averages here so it can be done. 
                averagePane.add(right, constraints); 

      

                charSelect.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){

                        String selection = charSelect.getSelectedItem().toString(); 
                        System.out.println(selection + "printing selection"); 
                        int index = 0; 
                        for (int i = 0; i < 26; i++){  
                            if (selection == characters[i].charName){
                                index = i; // WHY IS THIS ALWAYS ZERO. MIGHT FIX ITSELF WHEN THE CHARDATAFILE IS FINISHED **FIX ME**
                                i = 26; 
                            }
                        }
                       
                        System.out.println("PRINTING I " + index + "PRINTING CHARNAME" + characters[index].charName); 
                        
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width='40' height='40'>"; 
                        
                        left.setText("<br><br><br><br><br><center>*Please Note: Any value that is '-1' is either unavailable, or does not exist*</center><br>" + 
                        "<center>" + tempString +
                        "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "</center>"
                        
                        ); 
                        left.setVisible(true); 
                    }
                });




                frame.getContentPane().removeAll(); 
                left.setVisible(true);
                right.setVisible(true); 
                frame.add(averageScroll);  // which to use here? pane or scroll?
                frame.getContentPane().add(BorderLayout.NORTH, menuBar); 
                frame.setVisible(true); 

               
               

            }
        }); 


        JMenuItem tierList = new JMenuItem("Tier List"); 
       
        tierList.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("tier list clicked"); 
                // lines below used to be in the action listener 
                JTextPane tierListPane = new JTextPane(); 
                JScrollPane tierListScroll = new JScrollPane(tierListPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                tierListPane.setBackground(Color.LIGHT_GRAY);
                tierListPane.setContentType("text/html"); 
                     String info = "<html>"+
                        "<body><center><strong><u><font size=30px>13th Official SSBM Tier List - March 29th, 2021 (Ordered)</font></u></strong><center><br><br>"+ 
                        "<center>(S)&nbsp" + "&nbsp" + imageSources[0] +  "&nbsp" + imageSources[1] +  "&nbsp" + imageSources[2] + "&nbsp" + imageSources[3] + 
                        "<br><br>(A)&nbsp" + "&nbsp" + imageSources[4] + "&nbsp" + imageSources[5] + "&nbsp" + imageSources[6] + 
                        "<br><br>(B+)&nbsp" + "&nbsp" + imageSources[7] + "&nbsp" + imageSources[8] + "&nbsp" + imageSources[9] + "&nbsp" + imageSources[10] +
                        "<br><br>(B-)&nbsp" + "&nbsp" + imageSources[11] + "&nbsp" + imageSources[12] +
                        "<br><br>(C+)&nbsp" + "&nbsp" + imageSources[13] + "&nbsp" + imageSources[14] +
                        "<br><br>(C-)&nbsp" + "&nbsp" + imageSources[15] + "&nbsp" + imageSources[16] + "&nbsp" + imageSources[17] + "&nbsp" + imageSources[18] +
                        "<br><br>(D)&nbsp" + "&nbsp" + imageSources[19] + "&nbsp" + imageSources[20] + "&nbsp" + imageSources[21] + "&nbsp" + imageSources[22] + "&nbsp" + imageSources[23] +
                        "<br><br>(F)&nbsp" + "&nbsp" + imageSources[24] + "&nbsp" + imageSources[25] +
                        "<br><br><br><br><br>" +
                        "<strong>Source:</strong> https://www.ssbwiki.com/List_of_SSBM_tier_lists_(NTSC)" +
                        "<br>" + "</center></body></html>"; 
                frame.getContentPane().removeAll();
                tierListPane.setText(info); 
                tierListPane.setEditable(false);
                frame.add(tierListScroll); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.setVisible(true); 
            }
        }); 
        /*
        Indices (alphabetical order):
        0 = bowser, 1 = captain falcon, 2 = donkey kong, 3 = dr. mario, 4 = falco, 5 = fox, 6 = ganon, 7 = ICs, 8 = kirby, 9 = link, 10 = luigi, 11 = mario, 12 = marth, 
        7 = mew2, 14 = g&w, 15 = ness, 16 = peach, 17 = pichu, 18 = pika, 19 = puff, 20 = roy, 21 = samus, 22 = sheik, 23 = yoshi, 24 = yink, 25 = zelda
*/
        JMenuItem indivData = new JMenuItem("Individual Character Data");  
        JTextPane textPaneIndiv = new JTextPane(); 
                
        JComboBox<String> charMenu = new JComboBox<>(charOptions); 
                //charMenu.addActionListener(charMenu); 
        frame.pack(); 
        charMenu.setBounds((frame.getContentPane().getWidth() / 2 ) - 65, 65, 130, 30); 
                /* this is a bullshit solution to get the frame centred, it would be nice in the future to make it not an absolute position 
                
                **FIX ME**
                This also has an issue where if you resize the window from another option, and then click the option to view individual character data, 
                then you end up with the window resizing back to the original size. 

                */
       

        indivData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("indivData clicked"); 
                // **FIX ME**  MIGHT NEED TO CHANGE THIS TO GRID BAG TO MAKE IT SEXY
                
                /*
                if the charData.txt file reads in the characters in the order of the current tier list, then no second string needs to be created. 
                Then you can just have the loop run, and have the index go in the order of the tier list.
                */

                charMenu.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent event){
                        String selection = charMenu.getSelectedItem().toString(); 
                        System.out.println(selection + "printing selection"); 
                        int index = 0; 
                        for (int i = 0; i < 26; i++){  // check which character was selected 
                            if (selection == characters[i].charName){
                                index = i; // WHY IS THIS ALWAYS ZERO. MIGHT FIX ITSELF WHEN THE CHARDATAFILE IS FINISHED **FIX ME**
                                i = 26; // break should also work
                                // to add the picture NEED TO ADD A STRING THAT HAS THE IMAGE DEPENDING ON INDEX. SWITCH STATMENT MAYBE **FIX ME**
                                // so that is can be added properly to the set text statement below. 
                            }
                        }
                        System.out.println("PRINTING I " + index + "PRINTING CHARNAME" + characters[index].charName); 
                        
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width='40' height='40'>"; 
                        
                        // TEST TO SEE IF THE FILE: TYPE SHIT IN IMAGESOURCES WILL WORK WITH CSS HERE. **FIX ME** MAYBE IT WONT LOOK SO UGLY THAT WAY 
                        
                        textPaneIndiv.setText("<center><br>Select a character from the dropdown menu: </center>" +
                        "<br><br><br><br><center>*Please Note: Any value that is '-1' is either unavailable, or does not exist*</center><br>" + 
                        "<center>" + tempString + "</center>" +
                        "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] 
                        
                        ); 
                    }
                });

                
                textPaneIndiv.setContentType("text/html");
                JScrollPane scrollPaneIndiv = new JScrollPane(textPaneIndiv, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                textPaneIndiv.setBackground(Color.LIGHT_GRAY); 
                textPaneIndiv.setText("<center><br>Select a character from the dropdown menu: </center>"); 
            
                /*
                public void actionPerformed(ActionEvent event){
                    if (event.getSource() == charMenu){
                        String charInfo = (String)charMenu.getSelectedItem(); 
                        for (int i = 0; i < 26; i++){
                            if (charInfo == charOptions[i]){
                                textPaneIndiv.setText("<center><br>Select a character from the dropdown menu: </center>"); 
                                break; 
                            }
                        }
                        
                    }
                }
                */

                textPaneIndiv.setEditable(false);
                frame.getContentPane().removeAll(); 
                
                frame.add(scrollPaneIndiv); 
                textPaneIndiv.add(charMenu); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar); 
                frame.setVisible(true); 

            }
        });
            
        view.add(tierList); 
        view.add(indivData); 
    

        JMenuItem damaging = new JMenuItem("Damaging Moves"); 
        damaging.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JTextPane damagingPane = new JTextPane(); 
                JScrollPane damagingScroll = new JScrollPane(damagingPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                damagingPane.setContentType("text/html"); 
                damagingPane.setBackground(Color.LIGHT_GRAY); 
                damagingPane.setText("<br><br> <br><center><b> Select the type of attribute that you would like to rank. </b> </center>"); 
                JComboBox<String> rankOptions = new JComboBox<>(rankingOptions); 
                rankOptions.setBounds((frame.getContentPane().getWidth() / 2 ) - 65, 85, 130, 30); 
                damagingPane.add(rankOptions); 
                damagingPane.setEditable(false);
                rankOptions.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        String selection = rankOptions.getSelectedItem().toString(); 
                        System.out.println(selection + "printing selection"); 
                        int index = 0; 
                        for (int i = 0; i < 4; i++){  // check which character was selected 
                            if (selection == rankingOptions[i]){
                                index = i; 
                                i = 4; // break should also work
                            }
                        }
                        System.out.println("PRINTING I " + index + "PRINTING CHARNAME" + characters[index].charName); 
                        System.out.println(selection); 
                        JComboBox<String> moveOptions = new JComboBox<>(damagingMoves); 
                        damagingPane.setText("<center><b><br><br>" + "'" + selection + "'" + " selected. </b><br>Please select a move. " + "</center>"); 
                        damagingPane.remove(rankOptions); 
                        moveOptions.setBounds((frame.getContentPane().getWidth() / 2 ) - 75, 85, 145, 30); 
                        damagingPane.add(moveOptions); 
                        moveOptions.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent event){
                                String selection = rankOptions.getSelectedItem().toString(); 
                                    System.out.println(selection + "printing selection"); 
                                    int index = 0; 
                                     for (int i = 0; i < 4; i++){  // check which character was selected 
                                        if (selection == rankingOptions[i]){
                                            index = i; 
                                            i = 4; // break should also work
                                        }
                                    }
                                System.out.println("PRINTING I " + index + "PRINTING CHARNAME" + characters[index].charName); 
                                System.out.println(selection); 
                                /*
                                
                                                    NEED TO MAKE IT DISPLAY SOMETHING AT THIS POINT HERE **FIX ME**

                                */
                            }
                        }); 
                        

                        frame.getContentPane().removeAll(); 
                        frame.getContentPane().add(BorderLayout.NORTH, menuBar); 
                        frame.getContentPane().add(BorderLayout.CENTER, damagingScroll); 
                        frame.setVisible(true); 
                        // ADD ANOTHER COMBOBOX HERE WITH THE DAMAGING MOVES, INSIDE OF THE PUBLIC VOID, AND FIX IT SO THAT IT DOES THE THING ** FIX ME** 
                    }
                });
                frame.getContentPane().removeAll(); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.getContentPane().add(BorderLayout.CENTER, damagingScroll);  
                frame.setVisible(true); 
                

            }
        }); 
        JMenuItem nonDamaging = new JMenuItem("Non-Damaging Moves"); 

        rank.add(damaging); 
        rank.add(nonDamaging); 

        JMenuItem howToUse = new JMenuItem ("How To Use"); 
        howToUse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("how to use clicked"); 
                JTextPane howPane = new JTextPane(); 
                JScrollPane howScroll = new JScrollPane(howPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 

                howPane.setContentType("text/html"); 
                howPane.setBackground(Color.LIGHT_GRAY); 
                howPane.setEditable(false);
                howPane.setText("<center><b><u>HOW TO USE</u></b></center>" + "<br><br>" + 
                "<center><b><u>Compare Tab</u></b></center><br>" + "<b>vs Characters</b> <br> To use this option, simply select the " +
                "number of characters you would like to compare, and then select them from the dropdown menu. You can do this by clicking, or typing" + 
                "the characters name. If you misclick or mistype, you can re-select from the dropdown menu.<br>" +
                "<br><b>vs Averages </b> <br> On the left side of this tab, you will see a dropdown menu, with the average values on the right side." + 
                "After selecting a character, you can compare the traits of each move of the character you picked to the averages. <br><br>" + 
                "<center><b><u>View Tab</u></b></center><br>" + "<b>Tier List </b> <br> Press this to view the tier list. Character icons are ordered within the tiers.<br>" + 
                "<br><b> Individual Character Data </b><br>" + "To use this option, simply select a character from the dropdown menu by scrolling and clicking on" + 
                "a character or typing their name. You can re-select a character if you misclick or mistype." + "<br><br>" +
                "<center><b><u>Rank Moves</u></b></center> <br>" + "<b> All Options </b> <br>" + "All of the options in this submenu work the same way." + 
                "Simply select a character by clicking on, or typing a characters name after interacting with the dropdown menu. After doing so, you" + 
                "will see data show up for the character that you selected. FIX ME FIX ME FIX ME You can re-select a character if you misclick or mistype. <br>"
                            // ** FIX ME ** THIS NEEDS TO BE FIXED FOR THE RANKING PART SINCE THAT WAS CHANGED FROM THE ORIGINAL DESIGN 
                ); 

                frame.getContentPane().removeAll(); 
                
                
                frame.getContentPane().add(BorderLayout.NORTH, menuBar); 
                frame.getContentPane().add(BorderLayout.CENTER, howScroll); 
                frame.setVisible(true); 

            }
        });
        
        help.add(howToUse); 
        

        
        JTextPane defaultTP = new JTextPane();
        Font defaultFont = new Font("Century Gothic", Font.PLAIN, 36); 
        //defaultTP.getCaret().setVisible(false);
        defaultTP.setBackground(Color.LIGHT_GRAY); 
        defaultTP.setEditable(false);
        /*defaultTP.setContentType("text/html"); 
        String homeText = "<html><body><p style =\"color:red>" + "Welcome to SSBM Comparator</p>" + 
        "<br><br>"+
        "Select a menu option at the top to get started"+
        "</body></html>"; */
        
        defaultTP.setText("\n\n\n\nWelcome to SSBM Comparator\nSelect a menu option at the top to get started"); 
        defaultTP.setFont(defaultFont); 
        StyledDocument doc = defaultTP.getStyledDocument(); 
        SimpleAttributeSet center = new SimpleAttributeSet(); 
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false); 

       /* ImageIcon smashLogo = new ImageIcon("./images/FightingWireFramesHeadsSSBM.png"); 
        defaultTP.add(smashLogo); 
        // https://stackoverflow.com/questions/24407190/center-alignment-of-a-word-in-jtextpane
        // defaultTP.insertIcon(new ImageIcon("./images/FightingWireFramesHeadsSSBM.png")); 
      /*  Style style = doc.addStyle("StyleName", null); 
        StyleConstants.setIcon(style, new ImageIcon("./images/FightingWireFramesHeadsSSBM.png")); 
        doc.insertString(doc.getLength(), "ignored text", style); */ 

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, defaultTP);
     //   frame.getContentPane().add(BorderLayout.EAST, vertical); 
        frame.setVisible(true);
        
    }

}

class Character {
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
                if (index == 1 || index == 2 || index == 3 || index == 7 || index == 14 || index == 24){ // **FIX ME, MAKE IT RELATIVE TO THE TIER LIST**
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
            JFrame errorFrame = new JFrame(); 
            JTextPane errorText = new JTextPane(); 
            errorText.setContentType("text/html"); 
            errorText.setText("<center>ERROR IN READING FILE</center>");
            errorFrame.getContentPane().add(BorderLayout.CENTER, errorText);
            error.printStackTrace();
            for (int i = 0; i < 500000; i++){
                // bootleg ass sleep timer
            }

            System.exit(0); 
           
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