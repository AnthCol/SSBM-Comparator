
package src; 

import javax.swing.*;
import javax.swing.text.*;

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

        JMenu compare = new JMenu("Compare Characters");
        JMenu view = new JMenu("View");
        JMenu rank = new JMenu ("Rank"); 
        JMenu help = new JMenu("Help"); 
    
        menuBar.add(compare);
        menuBar.add(view);
        menuBar.add(rank); 
        menuBar.add(help); 

        JMenuItem charSelect = new JMenuItem ("Character Select"); 
       // JMenuItem threeChars = new JMenuItem("Three Characters"); 
    //    JMenuItem fourChars = new JMenuItem("Four Characters");             ** FIX ME, may not be capable of doing four cahracters, considering how java swing works, we'll see
        compare.add(charSelect); 
       // compare.add(threeChars); 
      //  compare.add(fourChars);  

        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Created by Anthony Colaiacovo, May 2022");
        panel.add(label); 


        
        charSelect.addActionListener(new ActionListener(){
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
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.weightx = 0.5; 
                constraints.gridx = 1;
                constraints.gridy = 0; 
                comparePane.add(addChar2, constraints); 

                JButton addChar3 = new JButton("+"); 
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.weightx = 0.5; ; 
                constraints.gridx = 2;
                constraints.gridy = 0; 
                comparePane.add(addChar3, constraints); 

                JButton addChar4 = new JButton("+"); 
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.weightx = 0.5; ; 
                constraints.gridx = 3;
                constraints.gridy = 0; 
                comparePane.add(addChar4, constraints);

                JTextPane char1 = new JTextPane(); 
              //  char1.setContentType("text/html"); 
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.ipady = 450; 
                constraints.weightx = 0.5; 
                constraints.gridx = 0; 
                constraints.gridy = 1; 
                comparePane.add(char1, constraints); 
                char1.setBackground(Color.LIGHT_GRAY); 
              //  char1.setText("Add Character"); 
              //  char1.setEditable(false);

                JTextPane char2 = new JTextPane(); 
                char2.setContentType("text/html"); 
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.ipady = 450; 
                constraints.weightx = 0.5; 
                constraints.gridx = 1; 
                constraints.gridy = 1; 
                comparePane.add(char2, constraints); 
                char2.setBackground(Color.LIGHT_GRAY); 
              //  char2.setText("Add Character"); 
                char2.setEditable(false);

                JTextPane char3 = new JTextPane(); 
                char3.setContentType("text/html"); 
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.ipady = 450; 
                constraints.weightx = 0.5; 
                constraints.gridx = 2; 
                constraints.gridy = 1; 
                comparePane.add(char3, constraints); 
                char3.setBackground(Color.LIGHT_GRAY); 
             //   char3.setText("Add Character"); 
                char3.setEditable(false); 

                JTextPane char4 = new JTextPane(); 
                char4.setContentType("text/html"); 
                constraints.fill = GridBagConstraints.HORIZONTAL; 
                constraints.ipady = 450;   // **FIX ME ** might need to change this value to be much greater, so that the scroll pane works 
                constraints.weightx = 0.5; 
                constraints.gridx = 3; 
                constraints.gridy = 1; 
                comparePane.add(char4, constraints); 
                char4.setBackground(Color.LIGHT_GRAY); 
              //  char4.setText("Add Character"); 
                char4.setEditable(false);
               
                // array of JComboBox's to make this less code????? is that possible???? **FIX ME**
                
                addChar1.addActionListener (new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        System.out.println("CHAR 1 ADDITION CLICKED"); 
                        JComboBox<String> char1Combo = new JComboBox<>(charOptions); 
                        
                        /*GridBagConstraints constraints2 = new GridBagConstraints(); 
                        constraints2.fill = GridBagConstraints.HORIZONTAL;  */
                      //  char1.removeAll(); ????????????????????????????????????????????????????????????????????????????????????????????
                       // char1.setText(""); ????????????????????????????????????????????????????????????????????????????????????????????
                        char1Combo.setBounds(40, 50, 130, 30); 
                        char1.add(char1Combo); 

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
                        char2Combo.setBounds(30, 50, 130, 30); 
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
                        char3Combo.setBounds(30, 50, 130, 30); 
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
                        char4Combo.setBounds(30, 50, 130, 30); 
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
                frame.add(comparePane); 
               // frame.add(compareScroll);      ????????????? **FIX ME** 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.setVisible(true); 

            }
            
        });
   
        







        JMenuItem tierList = new JMenuItem("Tier List"); 
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
                "<br><br><br><br><br>"+
                "<strong>Source:</strong> https://www.ssbwiki.com/List_of_SSBM_tier_lists_(NTSC)"+
                "<br>"+
                "</center></body></html>"; 
                /* FINALLY FIGURED OUT HOW TO LOAD SHIT LOCALLY THANK FUCK HOPEFULLY IT WILL BE A LOT FASTER NOW SWAG SWAG 360 SWAG FIX ME */
                

        tierList.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("tier list clicked"); 
             //   JScrollBar scrollBar = new JScrollBar(); 
              //  JScrollPane TLScroll = new JScrollPane(); 
              /*  TLScroll.add(scrollBar); 
                TLScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
                TLScroll.setViewport(viewport); 
                scrollBar.addAdjustmentListener(new AdjustmentListener(){
                    public void adjustment (AdjustmentEvent event){
                        
                    }
                });  */
               
              //  TLScroll.setViewportView(tierListPane); 
             //   Font tierListFont = new Font("Century Gothic", Font.PLAIN, 24);   // THIS DOES NOT WORK ON TEXT/HTML CONTENT TYPE, AND NEITHER DOES CSS
               // tierListPane.setFont(tierListFont); 
               
                // might need to use JScrollPane for the images                 **FIX ME**     HOW THE FUCK DO YOU CHANGE THE FONT SIZE!?!?!!?!??!?!?!!??!?!?!
                // **FIX ME** MIGHT NEED TO COMPLETELY END UP TAKING OUT THE TEXT/HTML SHIT AND CHANGING IT TO DEFAULT ANDY AND LOAD IMAGES LOCALLY SOMEHOW
                
               // tierListPane.setFont(tierListFont); 
                /*imageSources[0] */
                
                frame.getContentPane().removeAll();
                
                tierListPane.setText(info); 
                tierListPane.setEditable(false);
                // USED TO BE HERE 
              //  frame.getContentPane().add(BorderLayout.SOUTH, panel);
                frame.add(tierListScroll); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                //frame.getContentPane().add(BorderLayout.CENTER, tierListPane);  
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
       // charMenu.setSelectedIndex(1);   is this really needed?

        indivData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("indivData clicked"); 
                // **FIX ME**  MIGHT NEED TO CHANGE THIS TO GRID BAG TO MAKE IT SEXY
                
                /*
                if the charData.txt file reads in the characters in the order of the current tier list, then no second string needs to be created. 
                Then you can just have the loop run, and have the index go in the order of the tier list. 

                Advanta

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
    


        JMenuItem baseDmg = new JMenuItem("Base Damage");  // pick a move when they click
        baseDmg.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JTextPane baseDmgPane = new JTextPane(); 
          
                // will need to do a JScrollPane here 
                baseDmgPane.setContentType("text/html");
         
                baseDmgPane.setBackground(Color.LIGHT_GRAY);
                baseDmgPane.setText("<br><br><br><br><center>Select a move from the menu: </center>");
           
                baseDmgPane.setEditable(false);
            
                frame.add(baseDmgPane); 
                
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
        Font defaultFont = new Font("Century Gothic", Font.PLAIN, 40); 
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
            for (int i = 0; i < 50000; i++){
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