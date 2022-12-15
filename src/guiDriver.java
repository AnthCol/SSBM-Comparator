package src; 

import java.awt.*; 
import javax.swing.*; 

public class guiDriver extends JFrame{
    public static final int WIDTH = 600; 
    public static final int HEIGHT = 500; 

    private Container contentPane; 


    public guiDriver(){
        super(); 
        setDefaults(); 
        setMainContain(); 
        setSize(WIDTH, HEIGHT); 
        pack(); 
    }


    public static void main(String[] args){
        // FIXME
    }


    private void setDefaults(){
        contentPane = getContentPane(); 
        contentPane.setPreferredSize(getPreferredSize(new Dimension(WIDTH, HEIGHT)));
        setSize(WIDTH, HEIGHT); // might not need this if we have preferred size 
        setTitle("SSBM COMPARATOR"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setMainContainer(){
        contentPane = getContentPane(); 
        contentPane.setSize(WIDTH, HEIGHT); 
        contentPane.setLayout(new BorderLayout()); 
        // can do LOADING SCREEN HERE BASICALLY JUST THE STARTING STUFF WHATEVER WE WANT WHEN THE PROGRAM LOADS FIXME
        contentPane.setVisible(true); 
    }

    private JMenuBar createMenu(){
        JMenuBar menubar = new JMenuBar(); 
        /*
         * FIXME
         * add JMenu items here to list them across the top 
         * 
         */
    }
    

}
