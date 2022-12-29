package src.ui; 

import src.Character; 

import java.util.ArrayList; 
import java.io.IOException; 
import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel; 
import javax.swing.ImageIcon;


import java.awt.Component; 
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

    private JLabel pic; // ?? FIXME

    private String currentSelection; 
    private int currentPathIndex;  // need to set to zero?

    private JPanel infoPanel; 
    private JPanel rankingPanel; 
    private JPanel dataPanel; 

    public SingleCharacterUI(Character[] characters){
        infoPanel = new JPanel(); 
        dataPanel = new JPanel(); 
        rankingPanel = new JPanel(); 
        initializeComboBox(); 
        initializeBufferedImages(); 
    }


    public JPanel basicInfo(){
        pic = new JLabel(new ImageIcon(images[currentPathIndex])); 
        infoPanel.add(pic); 
        pic.setAlignmentX(CENTER_ALIGNMENT); 
        infoPanel.add(names); 
        names.setAlignmentX(CENTER_ALIGNMENT); 
        infoPanel.setBackground(bg); 

        return (infoPanel); 
    }

    public JPanel moveData(){
        JLabel label = new JLabel("Data"); 

        dataPanel.setBackground(bg); 
        dataPanel.add(label); 

        return (dataPanel); 
    }

    public JPanel singleCharRankings(){
        JLabel label = new JLabel("Ranking"); 

        rankingPanel.setBackground(bg);
        rankingPanel.add(label); 

        return (rankingPanel); 
    }






    private void setSelectionAndPath(Character[] characters){

        currentSelection = (String)names.getSelectedItem(); 

        for (int i = 0; i < characters.length; i++){
            if (currentSelection.equals(characters[i].characterName)){
                currentPathIndex = i; 
          //      updateLabel(characters); 
                break; 
            }
        }
    }

    private void updateEverything(){
        




        infoPanel.revalidate(); 
        dataPanel.revalidate(); 
        rankingPanel.revalidate(); 

        infoPanel.repaint(); 
        dataPanel.repaint(); 
        rankingPanel.repaint(); 

    }


    private void initializeComboBox(){
        names = new JComboBox<>(); 
        names.addActionListener(e->setSelectionAndPath(characters));
        names.addItemListener(e->updateEverything()); 
        names.setFont(new Font("Bierdstadt", Font.PLAIN, 12)); 
        names.border(false);
        names.setBackground(Color.WHITE); 
        names.setForeground(Color.BLACK); 
    }

    private void initializeBufferedImages(){
        images = new BufferedImage[26];
        try{
            for (int i = 0; i < characters.length; i++){
                names.addItem(characters[i].characterName); 
                images[i] = ImageIO.read(new File(characters[i].spritePath)); 
            }
        } 
        catch (IOException e){
            System.out.println(e); 
            System.exit(0); 
        }
    }
}
