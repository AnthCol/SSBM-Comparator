package src.ui; 

import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JPanel;


import java.awt.image.BufferedImage; 



public class TierListUI{
    private Character[] characters; 

    public TierListUI(Character[] chars){
        characters = new Character[26]; 
        for (int i = 0; i < characters.length; i++){
            characters[i] = new Character(); 
            characters[i] = chars[i]; 
        }
    }
}
