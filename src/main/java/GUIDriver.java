package src; 

import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.JPanel; 

import java.awt.Dimension; 
import java.awt.Container; 
import java.awt.GridLayout; 
import java.awt.BorderLayout; 

import javax.swing.JMenuBar; 
import javax.swing.JMenu; 
import javax.swing.JMenuItem; 
import javax.swing.JOptionPane;

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
        // FIXME
        Character[] characters = new Character[26]; 
        FileReader fr = new FileReader(); 
        fr.readCharData(characters); 

        GUIDriver gui = new GUIDriver(); 
        gui.setVisible(true); 


        

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



        contentPane.setVisible(true); 
    }
    



    private JMenuBar createMenu(){
        JMenuBar menubar = new JMenuBar(); 
        JMenu singChar = new JMenu("Single Character"); 
        JMenu compare = new JMenu("Compare"); 
        JMenu rank = new JMenu("Rank"); 
        JMenu tierList = new JMenu("Tier List"); 

        menubar.add(singChar); 
        menubar.add(compare); 
        menubar.add(rank); 
        menubar.add(tierList); 


        singChar.addActionListener(e->FIXME()); // FIXME
        compare.addActionListener(e->FIXME());
        rank.addActionListener(e->FIXME()); 
        tierList.addActionListener(e->FIXME());


        return (menubar); 
    }
    
    private void FIXME(){
        return; 
    }

}
