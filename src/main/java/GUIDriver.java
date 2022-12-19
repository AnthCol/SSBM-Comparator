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
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.FontUIResource;

import java.awt.Font; 
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Container; 
import java.awt.GridLayout; 
import java.awt.BorderLayout; 


public class GUIDriver extends JFrame{
    public static final int WIDTH = 600; 
    public static final int HEIGHT = 500; 

    private Container contentPane; 


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

        for (int i = 0; i < 26; i++) characters[i] = new Character(); 

        gui.setVisible(true); 
        fr.readCharData(characters); 
        

    }


    private void setDefaults(){
        contentPane = getContentPane(); 
        contentPane.setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
        setSize(WIDTH, HEIGHT); // might not need this if we have preferred size 
        setTitle("SSBM COMPARATOR"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setMainContainer(){
        contentPane = getContentPane(); 
        contentPane.setSize(WIDTH, HEIGHT); 
        contentPane.setLayout(new BorderLayout()); 
        
        contentPane.add(createMenu(), BorderLayout.NORTH); 


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


        return (menubar); 
    }

    private void setMenuBarStyle(JMenuBar mb){
        mb.setBackground(Color.GREEN.darker().darker().darker().darker()); 
    }

    private void setButtonStyle(JButton b){
        // change these to RGB values later and make it pretty 
        b.setBackground(Color.GREEN.darker().darker().darker().darker()); 
        b.setForeground(Color.LIGHT_GRAY.brighter());
        b.setFocusPainted(false); 
        b.setFont(new Font("Bierstadt", Font.PLAIN, 12)); 
    }
    
    private void FIXME(){
        System.out.println("FIXME"); 
        return; 
    }

}
