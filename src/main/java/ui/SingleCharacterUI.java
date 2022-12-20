package src.ui; 

import javax.swing.JButton; 
import javax.swing.JPanel;
import javax.swing.JLabel; 


import java.awt.Font; 
import java.awt.Color; 
import java.awt.Paint; 
import java.awt.Dimension; 
import java.awt.Container; 

public class SingleCharacterUI{

    private Color bg = Color.BLACK; 


    public JPanel basicInfo(){
        JPanel infoPanel = new JPanel(); 
        JLabel label = new JLabel("Basic"); 
        
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
