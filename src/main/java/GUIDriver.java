package src; 

import src.ui.TierListUI; 
import src.ui.CompareUI; 
import src.ui.SingleCharacterUI; 
import src.ui.RankUI; 

import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JPanel;
import javax.swing.JMenuBar; 
import javax.swing.JMenu; 
import javax.swing.JMenuItem; 

import java.awt.event.MouseEvent; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseListener; 
import java.awt.Font; 
import java.awt.Color; 
import java.awt.Paint;  // might be able to remove this 
import java.awt.Dimension; 
import java.awt.Container; 
import java.awt.BorderLayout; 
import java.awt.image.BufferedImage; 


/* TODO:
 * add sprite paths to the charData.txt file so that they can read into character objects
 * 
 */


public class GUIDriver extends JFrame{
    private static final int WIDTH = 700; 
    private static final int HEIGHT = 500; 

    private Container contentPane; 
    private Character[] characters; 

    private SingleCharacterUI scui; 
    private CompareUI cui; 
    private RankUI rui; 
    private TierListUI tlui; 

    private Color buttonBackgroundColour = Color.BLACK; 
    private Color buttonForegroundColour = Color.LIGHT_GRAY.brighter(); 
    private Color buttonHoverColour = Color.LIGHT_GRAY; 
    private Color menuBarColour = Color.BLACK; 
    private Color frameBackgroundColour = Color.BLACK; 

   public GUIDriver(){
        super(); 
        FileReader fr = new FileReader(); 
        characters = new Character[26]; 
        for (int i = 0; i < characters.length; i++) characters[i] = new Character(); 
        fr.readCharData(characters); 
        fr = null; // garbage collector 
        scui = new SingleCharacterUI(characters); 
        cui = new CompareUI(characters); 
        rui = new RankUI(characters); 
        tlui = new TierListUI(characters); 
        setDefaults(); 
        setMainContainer(); 
        setSize(WIDTH, HEIGHT); 
        pack(); 
    }


    public static void main(String[] args){
        GUIDriver gui = new GUIDriver(); 
        gui.setVisible(true); 
    }


    private void setDefaults(){
        contentPane = getContentPane(); 
        contentPane.setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
        contentPane.setBackground(frameBackgroundColour);

        // the default here will be single character FIXME

        setSize(WIDTH, HEIGHT); // might not need this if we have preferred size 
        contentPane.setFont(new Font("Bierstadt", Font.PLAIN, 12)); 
        setTitle("SSBM COMPARATOR"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setMainContainer(){
        contentPane = getContentPane(); 
        contentPane.setSize(WIDTH, HEIGHT); 

        contentPane.setLayout(new BorderLayout()); 
        contentPane.add(createMenu(), BorderLayout.NORTH); 
        contentPane.add(scui.basicInfo(), BorderLayout.WEST); 
        contentPane.add(scui.moveData(), BorderLayout.CENTER); 
        contentPane.add(scui.singleCharRankings(), BorderLayout.EAST); 
        
        contentPane.setVisible(true); 

    }

    private JMenuBar createMenu(){
        JMenuBar menubar = new JMenuBar(); 
        JButton singChar = new JButton("Single Character"); 
        JButton compare = new JButton("Compare"); 
        JButton rank = new JButton("Rank"); 
        JButton tierList = new JButton("Tier List"); 

        setMenuBarStyle(menubar); 

        setButtonStyle(singChar); 
        setButtonStyle(compare); 
        setButtonStyle(rank); 
        setButtonStyle(tierList); 
    
        menubar.add(singChar); 
        menubar.add(compare); 
        menubar.add(rank); 
        menubar.add(tierList); 

        singChar.addActionListener(e->singCharDisplay()); 
        compare.addActionListener(e->compareDisplay());
        rank.addActionListener(e->rankDisplay()); 
        tierList.addActionListener(e->tierListDisplay());

        mouseHover(singChar); 
        mouseHover(compare); 
        mouseHover(rank); 
        mouseHover(tierList); 

        return (menubar); 
    }

    private void singCharDisplay(){
        contentPane = getContentPane(); 

        clearLayout(); 
        contentPane.add(scui.basicInfo(), BorderLayout.WEST); 
        contentPane.add(scui.moveData(), BorderLayout.CENTER); 
        contentPane.add(scui.singleCharRankings(), BorderLayout.EAST); 
        contentPane.validate(); 
        contentPane.repaint(); 

    }

    // TODO:
    private void compareDisplay(){
        contentPane = getContentPane(); 
        clearLayout(); 
        contentPane.validate(); 
        contentPane.repaint(); 

    }
    // TODO:
    private void rankDisplay(){
        contentPane = getContentPane(); 
        clearLayout(); 
        contentPane.validate(); 
        contentPane.repaint(); 

   //     contentPane.add(); 
    }
    // TODO:
    private void tierListDisplay(){
        contentPane = getContentPane(); 
        clearLayout(); 
        contentPane.validate(); 
        contentPane.repaint(); 


    //    contentPane.add(); 
    }

    private void clearLayout(){
        contentPane = getContentPane(); 
        contentPane.removeAll(); 
        contentPane.add(createMenu(), BorderLayout.NORTH);
    }


    private void setMenuBarStyle(JMenuBar mb){
        mb.setBackground(menuBarColour); 
        // gradient :( FIXME
     //   mb.setBorderPainted(false); 
    }
    
    private void setButtonStyle(JButton b){
        // change to RGB values later to make it pretty 
        b.setBackground(buttonBackgroundColour); 
        b.setForeground(buttonForegroundColour);
        b.setFocusPainted(false); 
        b.setBorderPainted(false); 
        b.setFont(new Font("Bierstadt", Font.PLAIN, 12)); 
    }

    private void mouseHover(JButton b){
        b.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered (MouseEvent e){
                b.setBackground(buttonHoverColour); 
            }
            @Override
            public void mouseExited (MouseEvent e){
                b.setBackground(buttonBackgroundColour); 
            } 
        }); 
    }
    

}
