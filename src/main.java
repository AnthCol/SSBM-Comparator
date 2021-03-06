
package src; 

import javax.swing.*;
import javax.swing.text.*;

import java.text.DecimalFormat; 
import java.awt.*;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.awt.event.*; 


// **NOTE donkey kongs cargo (forward) throw damage in the original text file is an average of the three
// (cargo up == 7%, forward is 8%, and back == 8%) **FIX ME include this in readme ** 

/*
        Indices (alphabetical order):
        0 = bowser, 1 = captain falcon, 2 = donkey kong, 3 = dr. mario, 
        4 = falco, 5 = fox, 6 = ganon, 7 = ICs, 8 = kirby, 9 = link, 
        10 = luigi, 11 = mario, 12 = marth, 
        13 = mew2, 14 = g&w, 15 = ness, 16 = peach, 17 = pichu, 18 = pika, 
        19 = puff, 20 = roy, 21 = samus, 22 = sheik, 23 = yoshi, 24 = yink, 
        25 = zelda
*/

// VALUE WILL BE SET AS NEGATIVE ONE IF IT IS UNAVAILABLE/INCALCULABLE


class Main extends Character{
    
    static int index = 0; 
    static int index2 = 0; 
    static String selection = "";
    static String selection2 = ""; 
    static int rankIndex = 0; 
    static int moveIndex = 0; 
    static int whichAttribute = 0; 
    
    public static void main(String args[]) {
        
        Character[] characters = new Character[26]; 
        
        
        for (int i = 0; i < 26; i++){ // initialize everything so it can be passed to the readFile method
            characters[i] = new Character(); 
            characters[i].charName = "Temp"; 
            for (int x = 0; x < 133; x++){
                characters[i].values[x] = 0; 
            }
        }

        readFile(characters); 


        int[] charIndices = new int[26]; 
        for (int i = 0; i < 26; i++){
            charIndices[i] = i; 
        }
     
        String[] damagingMoves = {
            "Jab 1", "Jab 2", "Jab 3", "Forward Tilt", "Up Tilt", "Down Tilt", 
            "Dash Attack", "Forward Smash", "Up Smash", "Down Smash", "Neutral Air", "Forward Air", "Back Air", "Up Air", "Down Air", 
            "Grounded Neutral B", "Aerial Neutral B", "Grounded Side B", "Aerial Side B", "Grounded Up B", "Aerial Up B", "Grounded Down B", "Aerial Down B", 
            "Forward Throw", "Back Throw", "Down Throw", "Up Throw"
            
        }; 

        String[] attributesList = {
            "Weight", "Fast Fall Speed", "Dash Speed", "Run Speed", "Wavedash Length (rank/26)", 
            "Perfect Ledgedash Intangibility Frames", "Jump Squat", "Wall Jump", "Standing Grab Startup Frames", "Standing Grab Total Frames", "Dash Grab Starting Frames", 
            "Dash Grab Total Frames", "Spotdodge Startup Frames", "Spotdodge Active Frames", "Spotdodge Ending Frames", "Back Roll Startup Frames", "Back Roll Active Frames", 
            "Back Roll Ending Frames", "Forward Roll Startup Frames", "Forward Roll Active Frames", "Forward Roll Ending Frames", "Air Dodge Startup Frames", "Air Dodge Active Frames", 
            "Air Dodge Ending Frames", "Air Dodge Special Land Lag"
        }; 

        String[] rankingOptions = {
            "Damage", "Startup Frames", "Active Frames", "Ending Frames"
        };


        String[] charOptions = {
            "Fox", "Marth", "Jigglypuff", "Falco", 
            "Sheik", "Captain Falcon",  "Peach",
            "Ice Climbers", "Pikachu", "Yoshi", "Samus", 
            "Luigi", "Dr. Mario", 
            "Ganondorf", "Mario", 
            "Donkey Kong", "Young Link", "Link",   "Mr. Game & Watch",  "Mewtwo", 
            "Roy",   "Pichu",  "Ness",    "Zelda", 
            "Kirby",   "Bowser"
        }; 

        String[] imageSources = new String[26]; 
        imageSources[0] = "<img src='file:images/BowserHeadSSBM.png'>"; 
        imageSources[1] = "<img src='file:images/CaptainFalconHeadSSBM.png'>"; 
        imageSources[2] = "<img src='file:images/DonkeyKongHeadSSBM.png'>"; 
        imageSources[3] = "<img src='file:images/DrMarioHeadSSBM.png'>"; 
        imageSources[4] = "<img src='file:images/FalcoHeadSSBM.png'>"; 
        imageSources[5] = "<img src='file:images/FoxHeadSSBM.png'>"; 
        imageSources[6] = "<img src='file:images/GanondorfHeadSSBM.png'>"; 
        imageSources[7] = "<img src='file:images/IceClimbersHeadSSBM.png'>"; 
        imageSources[8] = "<img src='file:images/KirbyHeadSSBM.png'>"; 
        imageSources[9] = "<img src='file:images/LinkHeadSSBM.png'>"; 
        imageSources[10] = "<img src='file:images/LuigiHeadSSBM.png'>"; 
        imageSources[11] = "<img src='file:images/MarioHeadSSBM.png'>"; 
        imageSources[12] = "<img src='file:images/MarthHeadSSBM.png'>"; 
        imageSources[13] = "<img src='file:images/MewtwoHeadSSBM.png'>"; 
        imageSources[14] = "<img src='file:images/MrGame&WatchHeadSSBM.png'>"; 
        imageSources[15] = "<img src='file:images/NessHeadSSBM.png'>"; 
        imageSources[16] = "<img src='file:images/PeachHeadSSBM.png'>"; 
        imageSources[17] = "<img src='file:images/PichuHeadSSBM.png'>"; 
        imageSources[18] = "<img src='file:images/PikachuHeadSSBM.png'>"; 
        imageSources[19] = "<img src='file:images/JigglypuffHeadSSBM.png'>"; 
        imageSources[20] = "<img src='file:images/RoyHeadSSBM.png'>"; 
        imageSources[21] = "<img src='file:images/SamusHeadSSBM.png'>"; 
        imageSources[22] = "<img src='file:images/SheikHeadSSBM.png'>"; 
        imageSources[23] = "<img src='file:images/YoshiHeadSSBM.png'>"; 
        imageSources[24] = "<img src='file:images/YoungLinkHeadSSBM.png'>"; 
        imageSources[25] = "<img src='file:images/ZeldaHeadSSBM.png'>"; 

        String[] imageSourcesTwo = new String[26];  // I KNOW ITS DISGUSTING
       
        imageSourcesTwo[0] = "<img src='file:images/FoxHeadSSBM.png'>"; 
        imageSourcesTwo[1] = "<img src='file:images/MarthHeadSSBM.png'>"; 
        imageSourcesTwo[2] = "<img src='file:images/JigglypuffHeadSSBM.png'>"; 
        imageSourcesTwo[3] = "<img src='file:images/FalcoHeadSSBM.png'>"; 
        imageSourcesTwo[4] = "<img src='file:images/SheikHeadSSBM.png'>"; 
        imageSourcesTwo[5] = "<img src='file:images/CaptainFalconHeadSSBM.png'>"; 
        imageSourcesTwo[6] = "<img src='file:images/PeachHeadSSBM.png'>"; 
        imageSourcesTwo[7] = "<img src='file:images/IceClimbersHeadSSBM.png'>"; 
        imageSourcesTwo[8] = "<img src='file:images/PikachuHeadSSBM.png'>"; 
        imageSourcesTwo[9] = "<img src='file:images/YoshiHeadSSBM.png'>"; 
        imageSourcesTwo[10] = "<img src='file:images/SamusHeadSSBM.png'>"; 
        imageSourcesTwo[11] = "<img src='file:images/LuigiHeadSSBM.png'>"; 
        imageSourcesTwo[12] = "<img src='file:images/DrMarioHeadSSBM.png'>"; 
        imageSourcesTwo[13] = "<img src='file:images/GanondorfHeadSSBM.png'>"; 
        imageSourcesTwo[14] = "<img src='file:images/MarioHeadSSBM.png'>"; 
        imageSourcesTwo[15] = "<img src='file:images/DonkeyKongHeadSSBM.png'>"; 
        imageSourcesTwo[16] = "<img src='file:images/YoungLinkHeadSSBM.png'>"; 
        imageSourcesTwo[17] = "<img src='file:images/LinkHeadSSBM.png'>"; 
        imageSourcesTwo[18] = "<img src='file:images/MrGame&WatchHeadSSBM.png'>"; 
        imageSourcesTwo[19] = "<img src='file:images/MewtwoHeadSSBM.png'>"; 
        imageSourcesTwo[20] = "<img src='file:images/RoyHeadSSBM.png'>"; 
        imageSourcesTwo[21] = "<img src='file:images/PichuHeadSSBM.png'>"; 
        imageSourcesTwo[22] = "<img src='file:images/NessHeadSSBM.png'>"; 
        imageSourcesTwo[23] = "<img src='file:images/ZeldaHeadSSBM.png'>"; 
        imageSourcesTwo[24] = "<img src='file:images/KirbyHeadSSBM.png'>"; 
        imageSourcesTwo[25] = "<img src='file:images/BowserHeadSSBM.png'>"; 

        JFrame frame = new JFrame("SSBM Comparator"); 
        JMenuBar menuBar = new JMenuBar();
        ImageIcon icon = new ImageIcon("./images/icon.png"); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650); // 615
        frame.setMinimumSize(new Dimension(1000, 600)); 
        frame.setIconImage(icon.getImage()); 

        JMenu compare = new JMenu("Compare");
        JMenu view = new JMenu("View");
        JMenu rank = new JMenu ("Rank"); 
        JMenu help = new JMenu("Help"); 
    
        menuBar.add(compare);
        menuBar.add(view);
        menuBar.add(rank); 
        menuBar.add(help); 

        JMenuItem vsCharacters = new JMenuItem ("vs Characters"); 
        JMenuItem vsAverage = new JMenuItem("vs Averages"); 
        compare.add(vsCharacters); 
        compare.add(vsAverage); 


        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Created by Anthony Colaiacovo, May - July 2022");
        panel.add(label); 


        
        vsCharacters.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            
               
                JPanel comparePanel = new JPanel(new GridLayout (0, 4));
                JScrollPane compareScroll = new JScrollPane(comparePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
                compareScroll.getVerticalScrollBar().setUnitIncrement(16);
                
                       
                JTextPane char1 = new JTextPane(); 
                char1.setContentType("text/html"); 
                char1.setBackground(Color.LIGHT_GRAY); 
                char1.setText("<br>"); 
                char1.setEditable(false);
                comparePanel.add(char1);  

                JTextPane char2 = new JTextPane(); 
                char2.setContentType("text/html");
                char2.setBackground(Color.LIGHT_GRAY); 
                char2.setText("<br>"); 
                char2.setEditable(false);
                comparePanel.add(char2);

                JTextPane char3 = new JTextPane(); 
                char3.setContentType("text/html"); 
                char3.setBackground(Color.LIGHT_GRAY); 
                char3.setText("<br>"); 
                char3.setEditable(false); 
                comparePanel.add(char3); 

                JTextPane char4 = new JTextPane(); 
                char4.setContentType("text/html"); 
                char4.setBackground(Color.LIGHT_GRAY); 
                char4.setText("<br>"); 
                char4.setEditable(false);
                comparePanel.add(char4); 
                
                String fillerData = "<center>" + "<br><br><br><br><br>" + "<img src='file:images/FightingWireFramesHeadSSBM.png'>" +
                "<br><br> <b> Select a Character To See Data</b>"; 
        
                
                JComboBox<String> char1Combo = new JComboBox<>(charOptions); 
                
                char1.setText(fillerData); 
               
                char1Combo.setBounds(char1.getWidth() + 65, 50, 130, 30); 
                char1.add(char1Combo); 
                char1.setVisible(true); 
                
                    

                char1Combo.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                       
                        selection = ""; 
                       
                        selection += char1Combo.getSelectedItem().toString();
                        for (int i = 0; i < 26; i++){
                            if (selection.equals(characters[i].charName)){
                                index = i; 
                                break; 
                            }
                        }
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width = '40' height ='40'>"; 
                        String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                        "<br><strong>&nbsp Jab 1:</strong><br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[4] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[5] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[6] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[7] +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[8] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[9] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[10] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[11] +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[12] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[13] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[14] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[15] +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[16] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[17] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[18] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[19] +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[20] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[21] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[22] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[23] +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[24] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[25] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[26] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[27] +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[28] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[29] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[30] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[31] +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[32] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[33] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[34] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[35] +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[36] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[37] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[38] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[39] +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[40] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[41] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[42] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[43] +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[44] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[45] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[46] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[47] +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[48] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[49] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[50] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[51] +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[52] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[53] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[54] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[55] +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[56] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[57] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[58] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[59] +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[60] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[61] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[62] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[63] +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[64] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[65] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[66] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[67] +
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[68] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[69] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[70] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[71] +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[72] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[73] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[74] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[75] +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[76] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[77] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[78] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[79] +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[80] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[81] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[82] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[83] +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[84] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[85] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[86] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[87] +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[88] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[89] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[90] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[91] +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[92] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[93] + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[94] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[95] + 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[96] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[97] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[98] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[99] +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[100] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[101] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[102] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[103] + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[104] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[105] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[106] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[107] +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[108] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[109] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[110] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[111] +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[112] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[113] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[114] +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[115] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[116] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[117] +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[118] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[119] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[120] +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[121] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[122] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[123] +
                        "<br> &nbsp Special Land Lag (Frames): " + characters[index].values[124] +
                        "<br><br><strong>&nbsp Weight:</strong> " + 
                        characters[index].values[125] +
                        "<br><br><strong>&nbsp Fast Fall Speed:</strong> " + 
                        characters[index].values[126] +
                        "<br><br><strong>&nbsp Dash Speed:</strong> " + 
                        characters[index].values[127] +
                        "<br><br><strong>&nbsp Run Speed:</strong> " + 
                        characters[index].values[128] +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26):</strong> " + 
                        characters[index].values[129] +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash<br> Intangibility Frames):</strong> " + 
                        characters[index].values[130] +
                        "<br><br><strong>&nbsp Jump Squat Frames:</strong> " + 
                        characters[index].values[131] +
                        "<br><br><strong>&nbsp Wall Jump:</strong> " ;  
                        String temp = compareText; 

                        if (characters[index].values[132] == 1){
                            temp += " Yes <br><br>"; 
                        }
                        else temp += " No <br><br>"; 
                        char1.setText(temp);  
                        char1.select(0, 0); 
                        selection = ""; 
                    }
                }); 

       
                JComboBox<String> char2Combo = new JComboBox<>(charOptions); 
                
                char2.setText(fillerData); 
                char2Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); 
                char2.add(char2Combo); 
                char2Combo.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        
                        selection = ""; 
                        selection += char2Combo.getSelectedItem().toString();
                        for (int i = 0; i < 26; i++){
                            if (selection.equals(characters[i].charName)){
                                index = i; 
                                break; 
                            }
                        }
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width = '40' height ='40'>"; 
                        String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                        "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[4] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[5] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[6] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[7] +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[8] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[9] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[10] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[11] +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[12] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[13] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[14] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[15] +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[16] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[17] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[18] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[19] +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[20] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[21] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[22] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[23] +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[24] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[25] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[26] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[27] +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[28] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[29] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[30] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[31] +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[32] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[33] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[34] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[35] +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[36] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[37] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[38] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[39] +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[40] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[41] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[42] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[43] +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[44] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[45] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[46] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[47] +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[48] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[49] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[50] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[51] +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[52] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[53] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[54] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[55] +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[56] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[57] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[58] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[59] +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[60] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[61] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[62] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[63] +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[64] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[65] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[66] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[67] +
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[68] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[69] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[70] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[71] +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[72] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[73] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[74] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[75] +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[76] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[77] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[78] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[79] +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[80] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[81] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[82] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[83] +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[84] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[85] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[86] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[87] +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[88] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[89] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[90] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[91] +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[92] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[93] + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[94] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[95] + 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[96] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[97] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[98] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[99] +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[100] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[101] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[102] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[103] + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[104] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[105] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[106] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[107] +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[108] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[109] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[110] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[111] +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[112] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[113] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[114] +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[115] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[116] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[117] +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[118] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[119] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[120] +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[121] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[122] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[123] +
                        "<br> &nbsp Special Land Lag (Frames): " + characters[index].values[124] +
                        "<br><br><strong>&nbsp Weight:</strong> " + 
                        characters[index].values[125] +
                        "<br><br><strong>&nbsp Fast Fall Speed:</strong> " + 
                        characters[index].values[126] +
                        "<br><br><strong>&nbsp Dash Speed:</strong> " + 
                        characters[index].values[127] +
                        "<br><br><strong>&nbsp Run Speed:</strong> " + 
                        characters[index].values[128] +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26):</strong> " + 
                        characters[index].values[129] +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash<br> Intangibility Frames):</strong> " + 
                        characters[index].values[130] +
                        "<br><br><strong>&nbsp Jump Squat Frames:</strong> " + 
                        characters[index].values[131] +
                        "<br><br><strong>&nbsp Wall Jump:</strong> " ;  
                        String temp = compareText; 
                        if (characters[index].values[132] == 1){
                            temp += " Yes <br><br>"; 
                        }
                        else temp += " No <br><br>"; 
                        char2.setText(temp);  
                        char2.select(0, 0); 
                        selection = ""; 
                    }
                }); 

                JComboBox<String> char3Combo = new JComboBox<>(charOptions); 
                //char3.removeAll(); 
                char3.setText(fillerData); 
                char3Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); 
                char3.add(char3Combo); 
                char3Combo.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent event){
                        selection = ""; 
                        
                        selection += char3Combo.getSelectedItem().toString(); 
                        for (int i = 0; i < 26; i++){
                            if (selection.equals(characters[i].charName)){
                                index = i; 
                                break; 
                            }
                        }
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width = '40' height ='40'>"; 
                        String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                        "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[4] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[5] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[6] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[7] +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[8] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[9] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[10] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[11] +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[12] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[13] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[14] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[15] +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[16] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[17] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[18] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[19] +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[20] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[21] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[22] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[23] +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[24] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[25] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[26] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[27] +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[28] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[29] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[30] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[31] +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[32] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[33] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[34] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[35] +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[36] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[37] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[38] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[39] +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[40] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[41] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[42] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[43] +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[44] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[45] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[46] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[47] +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[48] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[49] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[50] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[51] +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[52] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[53] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[54] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[55] +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[56] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[57] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[58] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[59] +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[60] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[61] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[62] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[63] +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[64] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[65] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[66] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[67] +
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[68] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[69] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[70] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[71] +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[72] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[73] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[74] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[75] +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[76] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[77] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[78] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[79] +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[80] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[81] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[82] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[83] +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[84] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[85] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[86] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[87] +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[88] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[89] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[90] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[91] +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[92] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[93] + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[94] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[95] + 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[96] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[97] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[98] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[99] +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[100] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[101] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[102] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[103] + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[104] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[105] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[106] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[107] +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[108] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[109] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[110] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[111] +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[112] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[113] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[114] +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[115] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[116] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[117] +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[118] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[119] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[120] +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[121] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[122] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[123] +
                        "<br> &nbsp Special Land Lag (Frames): " + characters[index].values[124] +
                        "<br><br><strong>&nbsp Weight:</strong> " + 
                        characters[index].values[125] +
                        "<br><br><strong>&nbsp Fast Fall Speed:</strong> " + 
                        characters[index].values[126] +
                        "<br><br><strong>&nbsp Dash Speed:</strong> " + 
                        characters[index].values[127] +
                        "<br><br><strong>&nbsp Run Speed:</strong> " + 
                        characters[index].values[128] +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26):</strong> " + 
                        characters[index].values[129] +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash<br> Intangibility Frames):</strong> " + 
                        characters[index].values[130] +
                        "<br><br><strong>&nbsp Jump Squat Frames:</strong> " + 
                        characters[index].values[131] +
                        "<br><br><strong>&nbsp Wall Jump:</strong> " ;  
                        String temp = compareText; 
                        if (characters[index].values[132] == 1){
                            temp += " Yes <br><br>"; 
                        }
                        else temp += " No <br><br>"; 
                        char3.setText(temp);  
                        char3.select(0, 0); 
                        selection += ""; 
                    }
                }); 
           
          
                JComboBox<String> char4Combo = new JComboBox<>(charOptions); 
               // char4.removeAll(); 
                char4.setText(fillerData); 
                char4Combo.setBounds((frame.getContentPane().getWidth() / 8 ) - 65, 50, 130, 30); 
                char4.add(char4Combo); 
                char4Combo.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                       
                        selection = ""; 
                        selection += char4Combo.getSelectedItem().toString();
                        for (int i = 0; i < 26; i++){
                            if (selection.equals(characters[i].charName)){
                                index = i; 
                                break; 
                            }
                        }
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width = '40' height ='40'>"; 
                        String compareText = "<center>" + "<br><br><br><br><br>" + tempString + "<br>" + 
                        "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[4] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[5] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[6] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[7] +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[8] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[9] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[10] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[11] +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[12] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[13] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[14] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[15] +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[16] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[17] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[18] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[19] +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[20] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[21] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[22] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[23] +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[24] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[25] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[26] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[27] +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[28] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[29] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[30] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[31] +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[32] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[33] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[34] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[35] +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[36] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[37] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[38] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[39] +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[40] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[41] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[42] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[43] +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[44] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[45] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[46] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[47] +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[48] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[49] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[50] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[51] +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[52] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[53] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[54] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[55] +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[56] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[57] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[58] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[59] +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[60] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[61] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[62] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[63] +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[64] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[65] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[66] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[67] +
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[68] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[69] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[70] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[71] +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[72] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[73] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[74] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[75] +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[76] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[77] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[78] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[79] +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[80] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[81] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[82] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[83] +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[84] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[85] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[86] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[87] +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[88] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[89] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[90] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[91] +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[92] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[93] + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[94] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[95] + 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[96] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[97] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[98] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[99] +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[100] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[101] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[102] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[103] + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[104] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[105] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[106] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[107] +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[108] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[109] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[110] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[111] +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[112] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[113] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[114] +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[115] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[116] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[117] +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[118] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[119] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[120] +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[121] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[122] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[123] +
                        "<br> &nbsp Special Land Lag (Frames): " + characters[index].values[124] +
                        "<br><br><strong>&nbsp Weight:</strong> " + 
                        characters[index].values[125] +
                        "<br><br><strong>&nbsp Fast Fall Speed:</strong> " + 
                        characters[index].values[126] +
                        "<br><br><strong>&nbsp Dash Speed:</strong> " + 
                        characters[index].values[127] +
                        "<br><br><strong>&nbsp Run Speed:</strong> " + 
                        characters[index].values[128] +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26):</strong> " + 
                        characters[index].values[129] +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash<br> Intangibility Frames):</strong> " + 
                        characters[index].values[130] +
                        "<br><br><strong>&nbsp Jump Squat Frames:</strong> " + 
                        characters[index].values[131] +
                        "<br><br><strong>&nbsp Wall Jump:</strong> " ;  
                        String temp = compareText; 
                        if (characters[index].values[132] == 1){
                            temp += " Yes <br><br>"; 
                        }
                        else temp += " No <br><br>"; 
                        char4.setText(temp);  
                        char4.select(0, 0); 
                        selection = ""; 
                    }
                }); 
            

                
                
                comparePanel.setBackground(Color.LIGHT_GRAY); 
                frame.getContentPane().removeAll();
                char1.select(0, 0); 
                frame.add(compareScroll);  
               
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.setVisible(true); 

            }
            
        });
   

        vsAverage.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                
                JPanel mainPanel = new JPanel ( new GridLayout (0, 2)); 
              
                /*FIX ME
                 * Adding ctrl + f functionality here, or buttons along the top to skip to a certain section would be fantastic (Skip to: Aerials, and then set the scrollbar somewhere)
                 */

                JScrollPane averageScroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                averageScroll.getVerticalScrollBar().setUnitIncrement(16);
             
                JComboBox<String> charSelect = new JComboBox<>(charOptions);


                JTextPane left = new JTextPane(); 
                left.setContentType("text/html"); 
                left.setBackground(Color.LIGHT_GRAY); 
                left.setEditable(false); 
                JTextPane right = new JTextPane(); 
                right.setContentType("text/html"); 
                right.setBackground(Color.LIGHT_GRAY); 
                right.setEditable(false); 


    
                left.setContentType("text/html"); 
                left.setBackground(Color.LIGHT_GRAY); 
                left.setText("<center><br><br><b>&nbsp&nbsp&nbsp&nbsp Select a character:</b></center>"); 
                left.setEditable(false); 
                //charSelect.setBounds(left.getWidth() + 170, 65, 150, 30); 
                charSelect.setBounds((frame.getContentPane().getWidth() / 4 ) - 63, 65, 135, 30); 
                // **FIX ME** this kind of thing still wont centre properly
                left.add(charSelect); 
        
                right.setContentType("text/html"); 
                right.setBackground(Color.LIGHT_GRAY); 
                right.setEditable(false); 
              
                float[] averages = new float[133]; 
                int count = 0; 
                for (int i = 0; i < 133; i++){
                    for (int x = 0; x < 26; x++){
                        if (characters[x].values[i] != -1){
                            averages[i] += characters[x].values[i]; 
                        }
                        else count++; 
                    }
                    averages[i] /= 26 - count; 
                    count = 0; 
                }

                DecimalFormat df = new DecimalFormat("0.00"); 

                String averageString = ("<center><br><br><br><br><b>&nbsp Averages: </b><<br><br><img src='file:images/FightingWireFramesHeadSSBM.png' width='40' height='40'><br>" + 
                "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[0]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[1]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[2]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[3]) +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[4]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[5]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[6]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[7]) +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[8]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[9]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[10]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[11]) +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[12]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[13]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[14]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[15]) +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[16]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[17]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[18]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[19]) +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[20]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[21] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[22] )+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[23]) +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[24]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[25] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[26]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[27]) +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[28]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[29])+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[30] )+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[31]) +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[32]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[33])+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[34]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[35]) +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[36]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[37]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[38]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[39]) +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[40]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[41]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[42]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[43]) +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[44]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[45] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[46]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[47]) +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[48]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[49]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[50]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[51]) +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[52])+ "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[53]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[54] )+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[55]) +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[56]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[57]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[58] )+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[59]) +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[60])+ "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[61])+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[62]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[63]) +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[64]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[65] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[66]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[67] )+
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[68] )+ "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[69] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[70] )+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[71]) +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[72]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[73]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[74]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[75]) +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[76]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[77]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[78]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[79]) +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[80] )+ "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[81]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[82])+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[83]) +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[84]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[85]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[86]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[87]) +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[88]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[89] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[90] )+ 
                        "<br> &nbsp Ending Frames: " + df.format(averages[91]) +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + df.format(averages[92]) + 
                        "<br> &nbsp Total Frames: " + df.format(averages[93]) + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[94]) + 
                        "<br> &nbsp Total Frames: " + df.format(averages[95])+ 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[96]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[97]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[98]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[99]) +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[100]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[101]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[102]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[103]) + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[104]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[105] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[106]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[107]) +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + df.format(averages[108]) + "%" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[109] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[110]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[111]) +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[112] )+ 
                        "<br> &nbsp Active Frames: " + df.format(averages[113]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[114]) +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + df.format(averages[115]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[116]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[117]) +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + df.format(averages[118]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[119]) + 
                        "<br> &nbsp Ending Frames: " + df.format(averages[120]) +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + df.format(averages[121]) + 
                        "<br> &nbsp Active Frames: " + df.format(averages[122]) +  
                        "<br> &nbsp Ending Frames: " + df.format(averages[123]) +
                        "<br> &nbsp Special Land Lag (Frames): " + df.format(averages[124]) +
                        "<br><br><strong>&nbsp Weight: &nbsp</strong>" + 
                        df.format(averages[125]) +
                        "<br><br><strong>&nbsp Fast Fall Speed: &nbsp</strong>" + 
                        df.format(averages[126]) +
                        "<br><br><strong>&nbsp Dash Speed: &nbsp</strong>" + 
                        df.format(averages[127]) +
                        "<br><br><strong>&nbsp Run Speed: &nbsp</strong>" + 
                        df.format(averages[128]) +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26): &nbsp</strong>" + 
                        df.format(averages[129]) +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash <br> Intangibility Frames): &nbsp</strong>" + 
                        df.format(averages[130]) +
                        "<br><br><strong>&nbsp Jump Squat Frames: &nbsp</strong>" + 
                        df.format(averages[131]) +
                        "<br><br><strong>&nbsp Wall Jump: &nbsp</strong>" 
                );  
                if (1 - averages[132] <= 0.5) averageString += "Yes";
                else averageString += "No"; 

                right.setText(averageString); 
           

                charSelect.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        selection += charSelect.getSelectedItem().toString(); 
                        
                        int index = 0; 
                        for (int i = 0; i < 26; i++){  
                            if (selection.equals(characters[i].charName)){
                                index = i; 
                                break; 
                            }
                        }
                       
                        
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width = '40' height ='40'>"; 
                        
                        String compareText = "<center>" + "<br><br><br><br><br><br>" + tempString + "<br>" + 
                        "<br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[4] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[5] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[6] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[7] +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[8] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[9] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[10] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[11] +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[12] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[13] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[14] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[15] +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[16] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[17] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[18] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[19] +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[20] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[21] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[22] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[23] +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[24] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[25] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[26] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[27] +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[28] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[29] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[30] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[31] +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[32] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[33] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[34] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[35] +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[36] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[37] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[38] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[39] +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[40] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[41] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[42] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[43] +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[44] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[45] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[46] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[47] +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[48] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[49] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[50] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[51] +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[52] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[53] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[54] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[55] +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[56] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[57] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[58] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[59] +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[60] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[61] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[62] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[63] +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[64] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[65] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[66] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[67] +
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[68] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[69] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[70] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[71] +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[72] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[73] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[74] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[75] +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[76] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[77] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[78] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[79] +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[80] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[81] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[82] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[83] +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[84] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[85] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[86] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[87] +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[88] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[89] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[90] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[91] +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[92] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[93] + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[94] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[95] + 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[96] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[97] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[98] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[99] +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[100] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[101] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[102] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[103] + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[104] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[105] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[106] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[107] +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[108] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[109] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[110] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[111] +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[112] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[113] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[114] +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[115] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[116] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[117] +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[118] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[119] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[120] +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[121] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[122] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[123] +
                        "<br> &nbsp Special Land Lag (Frames): " + characters[index].values[124] +
                        "<br><br><strong>&nbsp Weight:</strong> " + 
                        characters[index].values[125] +
                        "<br><br><strong>&nbsp Fast Fall Speed:</strong> " + 
                        characters[index].values[126] +
                        "<br><br><strong>&nbsp Dash Speed:</strong> " + 
                        characters[index].values[127] +
                        "<br><br><strong>&nbsp Run Speed:</strong> " + 
                        characters[index].values[128] +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26):</strong> " + 
                        characters[index].values[129] +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash<br> Intangibility Frames):</strong> " + 
                        characters[index].values[130] +
                        "<br><br><strong>&nbsp Jump Squat Frames:</strong> " + 
                        characters[index].values[131] +
                        "<br><br><strong>&nbsp Wall Jump:</strong> " ;  

                        
                        if (characters[index].values[132] == 1){
                            compareText += "&nbsp Yes <br><br>"; 
                        }
                        else compareText += "&nbsp No <br><br>"; 
                        left.setText(compareText); 
                        left.setVisible(true); 
                        left.select(0, 0); 
                        selection = ""; 
                    }
                });



                

                frame.getContentPane().removeAll(); 
                right.select(0, 0);
                mainPanel.add(left); 
                mainPanel.add(right); 
                frame.add(averageScroll); //, BorderLayout.CENTER); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar); 
                frame.setVisible(true); 


            }
        }); 


        JMenuItem tierList = new JMenuItem("Tier List"); 
       
        tierList.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent event){
               
                JTextPane tierListPane = new JTextPane(); 
                JScrollPane tierListScroll = new JScrollPane(tierListPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                tierListPane.setBackground(Color.LIGHT_GRAY);
                tierListPane.setContentType("text/html"); 
                     String info = "<html>"+
                        "<body><center><strong><u><font size=30px>13th Official SSBM Tier List - March 29th, 2021 (Ordered)</font></u></strong><center><br><br>"+ 
                        "<center>(S)&nbsp" + "&nbsp" + imageSourcesTwo[0] +  "&nbsp" + imageSourcesTwo[1] +  "&nbsp" + imageSourcesTwo[2] + "&nbsp" + imageSourcesTwo[3] + 
                        "<br><br>(A)&nbsp" + "&nbsp" + imageSourcesTwo[4] + "&nbsp" + imageSourcesTwo[5] + "&nbsp" + imageSourcesTwo[6] + 
                        "<br><br>(B+)&nbsp" + "&nbsp" + imageSourcesTwo[7] + "&nbsp" + imageSourcesTwo[8] + "&nbsp" + imageSourcesTwo[9] + "&nbsp" + imageSourcesTwo[10] +
                        "<br><br>(B-)&nbsp" + "&nbsp" + imageSourcesTwo[11] + "&nbsp" + imageSourcesTwo[12] +
                        "<br><br>(C+)&nbsp" + "&nbsp" + imageSourcesTwo[13] + "&nbsp" + imageSourcesTwo[14] +
                        "<br><br>(C-)&nbsp" + "&nbsp" + imageSourcesTwo[15] + "&nbsp" + imageSourcesTwo[16] + "&nbsp" + imageSourcesTwo[17] + "&nbsp" + imageSourcesTwo[18] +
                        "<br><br>(D)&nbsp" + "&nbsp" + imageSourcesTwo[19] + "&nbsp" + imageSourcesTwo[20] + "&nbsp" + imageSourcesTwo[21] + "&nbsp" + imageSourcesTwo[22] + "&nbsp" + imageSourcesTwo[23] +
                        "<br><br>(F)&nbsp" + "&nbsp" + imageSourcesTwo[24] + "&nbsp" + imageSourcesTwo[25] +
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
   
        JMenuItem indivData = new JMenuItem("Individual Character Data");  
        JTextPane textPaneIndiv = new JTextPane(); 
                
        JComboBox<String> charMenu = new JComboBox<>(charOptions); 
              
        frame.pack(); 
        charMenu.setBounds((frame.getContentPane().getWidth() / 2 ) - 65, 65, 130, 30); 
        
                /* improper centering
                
                **FIX ME**
                This also has an issue where if you resize the window from another option, and then click the option to view individual character data, 
                then you end up with the window resizing back to the original size. 

                */
        indivData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){

                charMenu.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent event){
                        selection += charMenu.getSelectedItem().toString(); 
                         
                        int index = 0; 
                        charMenu.setBounds((frame.getContentPane().getWidth() / 2 ) - 65, 65, 130, 30); 
                        for (int i = 0; i < 26; i++){  
                            if (selection.equals(characters[i].charName)){
                                index = i; 
                                break; 
                                
                            }
                        }
                        String tempString = imageSources[index].substring(0, imageSources[index].length() - 1); 
                        tempString = tempString + "width='40' height='40'>";
                        String compareText = 
                        "<center><br>Select a character from the dropdown menu: </center>" +
                        "<br><br><br><br><center>*Please Note: Any value that is '-1' is either unavailable, or does not exist*</center><br>" + 
                        "<center>" + tempString + "</center>" +
                        "<center><br><strong>&nbsp Jab 1:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[0] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[1] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[2] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[3] +
                        "<br><br><strong>&nbsp Jab 2:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[4] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[5] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[6] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[7] +
                        "<br><br><strong>&nbsp Jab 3:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[8] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[9] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[10] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[11] +
                        "<br><br><strong>&nbsp Forward Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[12] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[13] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[14] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[15] +
                        "<br><br><strong>&nbsp Up Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[16] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[17] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[18] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[19] +
                        "<br><br><strong>&nbsp Down Tilt:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[20] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[21] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[22] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[23] +
                        "<br><br><strong>&nbsp Dash Attack:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[24] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[25] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[26] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[27] +
                        "<br><br><strong>&nbsp Forward Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[28] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[29] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[30] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[31] +
                        "<br><br><strong>&nbsp Up Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[32] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[33] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[34] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[35] +
                        "<br><br><strong>&nbsp Down Smash:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[36] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[37] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[38] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[39] +
                        "<br><br><strong>&nbsp Neutral Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[40] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[41] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[42] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[43] +
                        "<br><br><strong>&nbsp Forward Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[44] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[45] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[46] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[47] +
                        "<br><br><strong>&nbsp Back Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[48] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[49] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[50] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[51] +
                        "<br><br><strong>&nbsp Up Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[52] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[53] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[54] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[55] +
                        "<br><br><strong>&nbsp Down Air:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[56] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[57] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[58] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[59] +
                        "<br><br><strong>&nbsp Grounded Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[60] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[61] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[62] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[63] +
                        "<br><br><strong>&nbsp Aerial Neutral B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[64] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[65] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[66] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[67] +
                        "<br><br><strong>&nbsp Grounded Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[68] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[69] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[70] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[71] +
                        "<br><br><strong>&nbsp Aerial Side B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[72] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[73] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[74] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[75] +
                        "<br><br><strong>&nbsp Grounded Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[76] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[77] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[78] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[79] +
                        "<br><br><strong>&nbsp Aerial Up B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[80] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[81] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[82] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[83] +
                        "<br><br><strong>&nbsp Grounded Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[84] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[85] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[86] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[87] +
                        "<br><br><strong>&nbsp Aerial Down B:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[88] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[89] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[90] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[91] +
                        "<br><br><strong>&nbsp Standing Grab:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[92] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[93] + 
                        "<br><br><strong>&nbsp Dash Grab:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[94] + 
                        "<br> &nbsp Total Frames: " + characters[index].values[95] + 
                        "<br><br><strong>&nbsp Forward Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[96] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[97] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[98] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[99] +  
                        "<br><br><strong>&nbsp Back Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[100] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[101] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[102] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[103] + 
                        "<br><br><strong>&nbsp Down Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[104] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[105] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[106] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[107] +
                        "<br><br><strong>&nbsp Up Throw:</strong>" + 
                        "<br> &nbsp Damage: " + characters[index].values[108] + "%" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[109] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[110] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[111] +
                        "<br><br><strong>&nbsp Spot Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[112] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[113] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[114] +
                        "<br><br><strong>&nbsp Backwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[115] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[116] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[117] +
                        "<br><br><strong>&nbsp Forwards Roll:</strong>" +
                        "<br> &nbsp Startup Frames: " + characters[index].values[118] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[119] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[120] +
                        "<br><br><strong>&nbsp Air Dodge:</strong>" + 
                        "<br> &nbsp Startup Frames: " + characters[index].values[121] + 
                        "<br> &nbsp Active Frames: " + characters[index].values[122] + 
                        "<br> &nbsp Ending Frames: " + characters[index].values[123] +
                        "<br> &nbsp Special Land Lag (Frames): " + characters[index].values[124] +
                        "<br><br><strong>&nbsp Weight:</strong> " + 
                        characters[index].values[125] +
                        "<br><br><strong>&nbsp Fast Fall Speed:</strong> " + 
                        characters[index].values[126] +
                        "<br><br><strong>&nbsp Dash Speed:</strong> " + 
                        characters[index].values[127] +
                        "<br><br><strong>&nbsp Run Speed:</strong> " + 
                        characters[index].values[128] +
                        "<br><br><strong>&nbsp Wavedash Length (rank/26):</strong> " + 
                        characters[index].values[129] +
                        "<br><br><strong>&nbsp PLDIF (Perfect Ledgedash Intangibility Frames):</strong> " + 
                        characters[index].values[130] +
                        "<br><br><strong>&nbsp Jump Squat Frames:</strong> " + 
                        characters[index].values[131] +
                        "<br><br><strong>&nbsp Wall Jump:</strong> " ;  

                        
                        if (characters[index].values[132] == 1){
                            compareText += " Yes <br><br>"; 
                        }
                        else compareText += " No <br><br>"; 
                            
                        compareText += "</center>"; 



                        textPaneIndiv.setText(compareText); 
                        textPaneIndiv.select(0, 0); 
                    
                        selection = ""; 
                    }
                });       
            
    

                
                textPaneIndiv.setContentType("text/html");
                JScrollPane scrollPaneIndiv = new JScrollPane(textPaneIndiv, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                textPaneIndiv.setBackground(Color.LIGHT_GRAY); 
                textPaneIndiv.setText("<center><br>Select a character from the dropdown menu: </center>"); 

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
    

        JMenuItem charMoves = new JMenuItem("Damaging Moves"); 
        charMoves.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JTextPane movePane = new JTextPane(); 
                JScrollPane moveScroll = new JScrollPane(movePane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                movePane.setContentType("text/html"); 
                movePane.setBackground(Color.LIGHT_GRAY); 
                movePane.setText("<br><center><b> Select the category that you would like to rank: <br><br><br> Select the move that you would like to rank:</center>"); 
                JComboBox<String> rankOptions = new JComboBox<>(rankingOptions); 
                rankOptions.setBounds((frame.getContentPane().getWidth() / 2 ) - 65, 45, 130, 30); 
                JComboBox<String> moveOptions = new JComboBox<>(damagingMoves); 
                moveOptions.setBounds((frame.getContentPane().getWidth() / 2) - 65, 105, 130, 30); 
                movePane.add(rankOptions); 
                movePane.add(moveOptions); 
                movePane.setEditable(false);
                selection = ""; 
                selection2 = ""; 
                index = 0; 
                index2 = 0; 
                whichAttribute = 0; 

                
                rankOptions.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        selection = rankOptions.getSelectedItem().toString(); 
                        for (int i = 0; i < 4; i++){  
                            if (selection.equals(rankingOptions[i])){
                                index = i;  // represents how many extra should be added to the original move.
                                break;  
                            }
                        }
                    
                      
                        float tempFloat; 
                        int tempInt; 
                        



                        if (selection2.length() > 1){
                            
                            whichAttribute = index + index2; 

                            int count = 0; 
                            for (int i = 0; i < 26; i++){
                                if (characters[i].values[whichAttribute] != -1) count++; 
                            }
                           
                            float[] charVals2 = new float[count]; 
                            int[] charIndices2 = new int[count]; 
                            int j = 0; 
                            for (int i = 0; i < 26; i++){
                                if (characters[i].values[whichAttribute] != -1){
                                    charVals2[j] = characters[i].values[whichAttribute]; 
                                    charIndices2[j] = i; 
                                    j++; 
                                }
                            }
                            for (int i = 0; i < count; i++){
                                for (int x = 0; x < count - 1; x++){
                                    if (index == 0 || index == 2){
                                        if (charVals2[x] <= charVals2[x+1]){
                                            tempFloat = charVals2[x]; 
                                            charVals2[x] = charVals2[x+1]; 
                                            charVals2[x+1] = tempFloat; 
    
                                            tempInt = charIndices2[x]; 
                                            charIndices2[x] = charIndices2[x+1]; 
                                            charIndices2[x+1] = tempInt; 
                                        }
                                    }
                                    else{
                                        if (charVals2[x] >= charVals2[x+1]){
                                            tempFloat = charVals2[x]; 
                                            charVals2[x] = charVals2[x+1]; 
                                            charVals2[x+1] = tempFloat; 
    
                                            tempInt = charIndices2[x]; 
                                            charIndices2[x] = charIndices2[x+1]; 
                                            charIndices2[x+1] = tempInt; 
                                        }
                                    }
                                    
                                }
                            }
  
                            String tempImage = ""; 
                            String ranking = "<br><br><br><br><br><br><br><br><center>" 
                            + "Ranking <b>" + selection + "</b> of <b>" + selection2 + "</b><br><br>"; 

                            for (int i = 0; i < count; i++){
                                for (int x = 0; x < 26; x++){
                                    if (characters[charIndices2[i]].charName.equals(charOptions[x])){
                                        tempImage = imageSourcesTwo[x]; 
                                        break; 
                                    }
                                }
                                if (selection.equals("Damage")) ranking += "#" + (i+1) + "<b>&nbsp&nbsp" + tempImage + "&nbsp" + "<i>" + characters[charIndices2[i]].charName + "</i></b>: " + charVals2[i] + "% <br>"; 
                                else ranking += "#" + (i+1) + "<b>&nbsp&nbsp" + tempImage + "&nbsp" + "<i>" + characters[charIndices2[i]].charName + "</i></b>: " + charVals2[i] + "<br>"; 
                                
                            }
                    
                            ranking += "</center>"; 


                            movePane.setText(ranking); 

                            movePane.select(0, 0);
                        }
                        
                    }
                });
                moveOptions.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        selection2 = moveOptions.getSelectedItem().toString(); 
                        for (int i = 0; i < 28; i++){  
                            if (selection2 == damagingMoves[i]){
                                index2 = i; 
                                break; 
                            }
                        }
                        index2 *= 4; 

                        if (index2 >= 92){
                            index2 += 4; 
                        } 

                       
                        
                       
                        float tempFloat = 0; 
                        int tempInt = 0; 
                    
                            
                        if (selection.length() > 1){
                            whichAttribute = index + index2; 
              
                            int count = 0; 
                            for (int i = 0; i < 26; i++){
                                if (characters[i].values[whichAttribute] != -1) count++; 
                            }
                            
                            float[] charVals2 = new float[count]; 
                            int[] charIndices2 = new int[count]; 
                            int j = 0; 
                            for (int i = 0; i < 26; i++){
                                if (characters[i].values[whichAttribute] != -1){
                                    charVals2[j] = characters[i].values[whichAttribute]; 
                                    charIndices2[j] = i; 
                                    j++; 
                                }
                            }
                            for (int i = 0; i < count; i++){
                                for (int x = 0; x < count - 1; x++){
                                    if (index == 0 || index == 2){
                                        if (charVals2[x] <= charVals2[x+1]){
                                            tempFloat = charVals2[x]; 
                                            charVals2[x] = charVals2[x+1]; 
                                            charVals2[x+1] = tempFloat; 
    
                                            tempInt = charIndices2[x]; 
                                            charIndices2[x] = charIndices2[x+1]; 
                                            charIndices2[x+1] = tempInt; 
                                        }
                                    }
                                    else{
                                        if (charVals2[x] >= charVals2[x+1]){
                                            tempFloat = charVals2[x]; 
                                            charVals2[x] = charVals2[x+1]; 
                                            charVals2[x+1] = tempFloat; 
    
                                            tempInt = charIndices2[x]; 
                                            charIndices2[x] = charIndices2[x+1]; 
                                            charIndices2[x+1] = tempInt; 
                                        }
                                    }
                                    
                                }
                            }
  
                            String tempImage = ""; 
                            String ranking = "<br><br><br><br><br><br><br><br><center>" 
                            + "Ranking <b>" + selection + "</b> of <b>" + selection2 + "</b><br><br>"; 

                            for (int i = 0; i < count; i++){
                                for (int x = 0; x < 26; x++){
                                    if (characters[charIndices2[i]].charName.equals(charOptions[x])){
                                        tempImage = imageSourcesTwo[x]; 
                                        break; 
                                    }
                                }
                                if (selection.equals("Damage")) ranking += "#" + (i+1) + "<b>&nbsp&nbsp" + tempImage + "&nbsp" + "<i>" + characters[charIndices2[i]].charName + "</i></b>: " + charVals2[i] + "% <br>"; 
                                else ranking += "#" + (i+1) + "<b>&nbsp&nbsp" + tempImage + "&nbsp" + "<i>" + characters[charIndices2[i]].charName + "</i></b>: " + charVals2[i] + "<br>"; 
                                
                            }
                    
                            ranking += "</center>"; 
                            movePane.setText(ranking); 

                            movePane.select(0, 0);
                            
                        }
                        
                    }
                    
                }); 

                frame.getContentPane().removeAll(); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar);
                frame.getContentPane().add(BorderLayout.CENTER, moveScroll);  
                frame.setVisible(true); 
   
            }
        }); 

        JMenuItem charAttributes = new JMenuItem("Attributes & Non-Damaging Moves"); 
        charAttributes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JTextPane attributePane = new JTextPane(); 
                attributePane.setContentType("text/html"); 
                attributePane.setBackground(Color.LIGHT_GRAY); 
                attributePane.setEditable(false); 
                attributePane.setText("<center><b><br><br>Please select the character attribute you would like to rank.</b> </center>"); 
                JScrollPane attributeScroll = new JScrollPane(attributePane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                attributeScroll.getVerticalScrollBar().setValue(0);
                JComboBox<String> attributeCombo = new JComboBox<>(attributesList); 

                attributeCombo.setBounds((frame.getContentPane().getWidth() / 2 ) - 128, 85, 250, 30); 

                attributePane.add(attributeCombo);

                attributeCombo.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){

                        attributeCombo.setBounds((frame.getContentPane().getWidth() / 2 ) - 128, 25, 250, 30); 
                        selection += attributeCombo.getSelectedItem().toString();
                        
                        switch(selection){
                            case "Weight": whichAttribute = 125; break;
                            case "Fast Fall Speed": whichAttribute = 126; break;
                            case "Dash Speed": whichAttribute = 127; break; 
                            case "Run Speed":  whichAttribute = 128; break; 
                            case "Wavedash Length (rank/26)": whichAttribute = 129; break; 
                            case "Perfect Ledgedash Intangibility Frames": whichAttribute = 130; break; 
                            case "Jump Squat": whichAttribute = 131; break; 
                            case "Wall Jump":  whichAttribute = 132; break; 
                            case "Standing Grab Startup Frames":  whichAttribute = 92; break; 
                            case "Standing Grab Total Frames":  whichAttribute = 93; break; 
                            case "Dash Grab Startup Frames": whichAttribute = 94; break; 
                            case "Dash Grab Total Frames":    whichAttribute = 95; break; 
                            case "Spotdodge Startup Frames":  whichAttribute = 112; break; 
                            case "Spotdodge Active Frames":   whichAttribute = 113; break; 
                            case "Spotdodge Ending Frames":  whichAttribute = 114; break; 
                            case "Back Roll Startup Frames": whichAttribute = 115; break; 
                            case "Back Roll Active Frames":  whichAttribute = 116; break; 
                            case "Back Roll Ending Frames":  whichAttribute = 117; break; 
                            case "Forward Roll Startup Frames": whichAttribute = 118; break; 
                            case "Forward Roll Active Frames": whichAttribute = 119; break; 
                            case "Forward Roll Ending Frames": whichAttribute = 120; break; 
                            case "Air Dodge Startup Frames":  whichAttribute = 121; break; 
                            case "Air Dodge Active Frames":  whichAttribute = 122; break; 
                            case "Air Dodge Ending Frames": whichAttribute = 123; break; 
                            case "Air Dodge Special Land Lag": whichAttribute = 124; break;
                        }

                        float tempFloat = 0; 
                        int tempInt = 0; 
                        float[] attributeArray = new float[26]; 

                        for (int i = 0; i < 26; i++){
                            attributeArray[i] = characters[i].values[whichAttribute]; 
                        }

                       
                        if (whichAttribute == 113 || whichAttribute == 116 || whichAttribute == 119 || whichAttribute == 122 ||
                        whichAttribute == 125 || whichAttribute == 126 || whichAttribute == 127 || whichAttribute == 128 ||
                        whichAttribute == 130 || whichAttribute == 132){
                            for (int i = 0; i < 25; i++){
                                for (int x = 0; x < 25; x++){
                                    if (attributeArray[x] < attributeArray[x+1]){
                                        tempFloat = attributeArray[x]; 
                                        attributeArray[x] = attributeArray[x+1]; 
                                        attributeArray[x+1] = tempFloat; 
        
                                        tempInt = charIndices[x]; 
                                        charIndices[x] = charIndices[x+1]; 
                                        charIndices[x+1] = tempInt; 
                                    }
                                }
                            }
                            
                        }
                        else {
                            for (int i = 0; i < 25; i++){
                                for (int x = 0; x < 25; x++){ 
                                    if (attributeArray[x] > attributeArray[x+1]){
                                        tempFloat = attributeArray[x]; 
                                        attributeArray[x] = attributeArray[x+1]; 
                                        attributeArray[x+1] = tempFloat; 
        
                                        tempInt = charIndices[x]; 
                                        charIndices[x] = charIndices[x+1]; 
                                        charIndices[x+1] = tempInt; 
                                    }   
                                }     
                            }
                        }
         

                        String ranking = "<center><br><br><br>";  
                        String tempImage = ""; 
                        for (int i = 0; i < 26; i++){
                            
                            for (int x = 0; x < 26; x++){
                                if (characters[charIndices[i]].charName.equals(charOptions[x])){
                                    tempImage = imageSourcesTwo[x]; 
                                    break;
                                }
                            }


                            String walljump = ""; 
                            if (whichAttribute == 132){
                                if (attributeArray[i] == 1){
                                    walljump = "Yes"; 
                                }
                                else{
                                    walljump = "No"; 
                                }
                                ranking += "#" + (i+1) + "<b>&nbsp&nbsp" + tempImage + "&nbsp" + "<i>" + characters[charIndices[i]].charName + "</i></b>: " + walljump + "<br>";  
                            } 
                            else{
                                ranking += "#" + (i+1) + "<b>&nbsp&nbsp" + tempImage + "&nbsp" + "<i>" + characters[charIndices[i]].charName + "</i></b>: " + attributeArray[i] + "<br>"; 
                            }
                        }


                        ranking += "</center><br>"; 
                        attributePane.setText(ranking); 

                        for (int i = 0; i < 26; i++){
                            charIndices[i] = i; 
                            // loop to reset this array for other use. 
                        }

                        attributePane.select(0, 0);   // ABSOLUTE GODSEND
                        selection = ""; 
                    }
                }); 
                
                attributeScroll.getVerticalScrollBar().setValue(0);
                frame.getContentPane().removeAll(); 
                frame.getContentPane().add(BorderLayout.NORTH, menuBar); 
                frame.getContentPane().add(BorderLayout.CENTER, attributeScroll); 
                frame.setVisible(true); 
            }
        }); 


        rank.add(charMoves); 
        rank.add(charAttributes); 

        JMenuItem howToUse = new JMenuItem ("How To Use"); 
        howToUse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                
                JTextPane howPane = new JTextPane(); 
                JScrollPane howScroll = new JScrollPane(howPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
                
                howPane.setContentType("text/html"); // **FIX ME** need to update this for new features
                howPane.setBackground(Color.LIGHT_GRAY); 
                howPane.setEditable(false);
                howPane.setText("<center><b><u>HOW TO USE</u></b></center>" + "" + 
                "<center><b><i>Compare Tab</i></b></center><br>" + "<b>vs Characters</b> <br> To use this option, simply select the " +
                "characters you want to compare from the dropdown menu. You can do this by clicking, or typing" + 
                "the characters name. If you misclick or mistype, you can re-select from the dropdown menu.<br>" +
                "<br><b>vs Averages </b> <br> On the left side of this tab, you will see a dropdown menu, with the average values on the right side." + 
                "After selecting a character, you can compare the traits of each move of the character you picked to the averages. <br><br>" + 
                "<center><b><i>View Tab</i></b></center><br>" + "<b>Tier List </b> <br> Press this to view the tier list. Character icons are ordered within the tiers.<br>" + 
                "<br><b> Individual Character Data </b><br>" + "To use this option, simply select a character from the dropdown menu by scrolling and clicking on" + 
                "a character or typing their name. You can re-select a character if you misclick or mistype." + "<br><br>" +
                "<center><b><i>Rank</i></b></center> <br>" + "<b> Moves </b> <br>" +
                "First, select the attribute of the move you would like to compare, then the program will bring you to another menu where you can select a move.<br><br>" +
                "<b>Attributes</b><br>" + 
                "In this case, simply select an attribute from the dropdown menu, and data will appear. You can re-select if you misclick or mistype"
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
        defaultTP.setBackground(Color.LIGHT_GRAY); 
        defaultTP.setEditable(false);
        
        
        defaultTP.setText("\n\n\n\nWelcome to SSBM Comparator\nSelect a menu option at the top to get started"); 
        defaultTP.setFont(defaultFont); 
        StyledDocument doc = defaultTP.getStyledDocument(); 
        SimpleAttributeSet center = new SimpleAttributeSet(); 
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false); 

      

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, defaultTP);
        frame.setVisible(true);
        
    }

}

class Character {
    String charName; 
    float[] values = new float[133]; 

    static void readFile (Character[] characters){
        int index = 0; 
        try{
            File file = new File ("./src/charData.txt"); 
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){  

                if (index == 1 || index == 2 || index == 3 || index == 7 || index == 24){  
                    characters[index].charName = fileReader.next(); 
                    characters[index].charName = characters[index].charName.concat(" "); 
                    characters[index].charName = characters[index].charName.concat(fileReader.next()); 
                }
                else if (index == 14){
                    characters[index].charName = fileReader.next(); 
                    characters[index].charName = characters[index].charName.concat(" "); 
                    characters[index].charName = characters[index].charName.concat(fileReader.next()); 
                    characters[index].charName = characters[index].charName.concat(" "); 
                    characters[index].charName = characters[index].charName.concat(fileReader.next()); 
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
            System.out.println("File was unable to be read"); 
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