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
import java.awt.BorderLayout; 
import java.awt.CardLayout; 
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints; 
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
        infoPanel.setLayout(new GridBagLayout()); 
        dataPanel = new JPanel(); 
        rankingPanel = new JPanel(); 
        initializeComboBox(characters); 
        initializeBufferedImages(characters); 
    }


    public JPanel basicInfo(){
        pic = new JLabel(new ImageIcon(images[currentPathIndex])); 
        GridBagConstraints c = new GridBagConstraints(); 
        c.gridx = 0; 
        c.gridy = 0; 
        infoPanel.add(pic, c); 

        c.gridx = 0; 
        c.gridy = 1; 

        // need to find a way to *change* the picture
        // as of right now every time you leave and come back it just adds the picture. 
        // FIXME
        infoPanel.add(names, c); 
     //   names.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT); 
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
                updateEverything(); 
                break; 
            }
        }
    }

    private void updateEverything(){
        
      //  infoPanel.remove(pic); 
      //  pic = new JLabel(new ImageIcon(images[currentPathIndex])); 
      //  infoPanel.add(pic); 


        infoPanel.revalidate(); 
        dataPanel.revalidate(); 
        rankingPanel.revalidate(); 

        infoPanel.repaint(); 
        dataPanel.repaint(); 
        rankingPanel.repaint(); 

    }


    private void initializeComboBox(Character[] characters){
        names = new JComboBox<>(); 
        names.addItemListener(e->setSelectionAndPath(characters)); 
        names.setFont(new Font("Bierdstadt", Font.PLAIN, 12)); 
      //  names.border(false);
        names.setBackground(Color.WHITE); 
        names.setForeground(Color.BLACK); 
    }

    private void initializeBufferedImages(Character[] characters){
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
