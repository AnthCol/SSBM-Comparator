package src.ui; 

import src.Character; 

import java.util.ArrayList; 

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel; 
import javax.imageio.ImageIO;

import java.awt.Font; 
import java.awt.Color; 
import java.awt.Paint; 
import java.awt.Dimension; 
import java.awt.Container; 
import java.awt.image.BufferedImage; 

import java.nio.file.FileSystems; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.io.File;


// https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel


public class SingleCharacterUI{

    private Color bg = Color.BLACK;

    private JComboBox <String> names; 
    private BufferedImage[] images; 

    public SingleCharacterUI(Character[] characters){
        names = new JComboBox<>(); 
        images = new BufferedImage[26]; 

        for (int i = 0; i < characters.length; i++){
            names.addItem(characters[i].characterName); 
       //     images[i] = ImageIO.read(new File(characters[i].spritePath)); 
        }
    }


    public JPanel basicInfo(){
        JPanel infoPanel = new JPanel(); 
        infoPanel.add(names); 
        infoPanel.setBackground(bg); 

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
