package src; 

import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JPanel;
import javax.swing.JMenuBar; 
import javax.swing.JMenu; 
import javax.swing.JMenuItem; 
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;


import java.awt.event.MouseEvent; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseListener; 
import java.awt.Font; 
import java.awt.Color; 
import java.awt.Paint; 
import java.awt.Dimension; 
import java.awt.Container; 
import java.awt.GridLayout; 
import java.awt.BorderLayout; 


public class GUIDriver extends JFrame{
    public static final int WIDTH = 600; 
    public static final int HEIGHT = 500; 

    private Container contentPane; 

    /* MEMBER VARIABLES WILL GO HERE FIXME
     * Class extends JFrame
     * class class = new class(); 
     * then based on buttons, set these classes as the main ones; 
     * 
    */

    private Color buttonBackgroundColour = Color.BLACK; 
    private Color buttonForegroundColour = Color.LIGHT_GRAY.brighter(); 
    private Color buttonHoverColour = Color.LIGHT_GRAY; 
    private Color menuBarColour = Color.BLACK; 
    private Color frameBackgroundColour = Color.BLACK; 


    public GUIDriver(){
        super(); 
        setDefaults(); 
        setMainContainer(); 
        setSize(WIDTH, HEIGHT); 
        pack(); 
    }


    public static void main(String[] args){
        GUIDriver gui = new GUIDriver(); 
        FileReader fr = new FileReader();  
        Character[] characters = new Character[26]; 
        for (int i = 0; i < characters.length; i++) characters[i] = new Character(); 


        fr.readCharData(characters);
        gui.setVisible(true); 
    
    }


    private void setDefaults(){
        contentPane = getContentPane(); 
        contentPane.setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
        contentPane.setBackground(frameBackgroundColour);
        setSize(WIDTH, HEIGHT); // might not need this if we have preferred size 
        setTitle("SSBM COMPARATOR"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setMainContainer(){
        contentPane = getContentPane(); 
        contentPane.setSize(WIDTH, HEIGHT); 
        contentPane.setLayout(new BorderLayout()); 
        
        contentPane.add(createMenu(), BorderLayout.NORTH); 
        // contentPane.add()?

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

        singChar.addActionListener(e->FIXME()); 
        compare.addActionListener(e->FIXME());
        rank.addActionListener(e->FIXME()); 
        tierList.addActionListener(e->FIXME());

        mouseHover(singChar); 
        mouseHover(compare); 
        mouseHover(rank); 
        mouseHover(tierList); 


        return (menubar); 
    }



    private void setMenuBarStyle(JMenuBar mb){
        mb.setBackground(menuBarColour); 

  //      mb.setBorderPainted(false); 
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
    

    private void FIXME(){
        System.out.println("FIXME"); 
        return; 
    }

}
