package src.ui; 

import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JPanel;


import java.awt.image.BufferedImage; 

public class CompareUI {
    private ArrayList<String> charNames; 
    private ArrayList<BufferedImage> spritePaths; 

    public CompareUI(ArrayList<String> name, ArrayList<BufferedImage> sprite){
        charNames = name; 
        spritePaths = sprite; 
    }
}
