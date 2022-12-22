package src.ui; 

import java.util.ArrayList; 

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel; 


import java.awt.Font; 
import java.awt.Color; 
import java.awt.Paint; 
import java.awt.Dimension; 
import java.awt.Container; 
import java.awt.image.BufferedImage; 


// https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel


public class SingleCharacterUI{

    private Color bg = Color.BLACK; 

    private ArrayList<String> charNames; 
    private ArrayList<BufferedImage> spritePaths; 

    public SingleCharacterUI(ArrayList<String> name, ArrayList<BufferedImage> sprite){
        charNames = name; 
        spritePaths = sprite; 
    }

    public JPanel basicInfo(){
        JPanel infoPanel = new JPanel(); 
        


        JComboBox comboxbox = new JComboBox(charNames); 

        infoPanel.setBackground(bg); 
        infoPanel.add(label); 

        return (infoPanel); 
    }

    public JPanel moveData(){
        JPanel dataPanel = new JPanel(); 
        JLabel label = new JLabel("Data"); 

        dataPanel.setBackground(bg); 
        dataPanel.add(label); 

        return (dataPanel); 
    }

    public JPanel singleCharRankings(){
        JPanel rankingPanel = new JPanel(); 
        JLabel label = new JLabel("Ranking"); 

        rankingPanel.setBackground(bg);
        rankingPanel.add(label); 

        return (rankingPanel); 
    }


}
