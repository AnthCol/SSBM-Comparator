package src; 



public class Character {
    private String characterName; 
    private int[][] jabs;
    private int[][] tilts;
    private int[] dashAttack;
    private int[][] smashAttacks;
    private int[][] aerials;
    private int[][] specialAttacksGrounded; 
    private int[][] specialAttacksAerial;
    private int[][] grabs; 
    private int[][] grabThrows; 
    private int[][] dodgesRolls; 
    private float[] misc; 


    public Character(){
        characterName = new String(); 
        jabs = new int[3][4]; 
        tilts = new int[3][4]; 
        dashAttack = new int[4]; 
        smashAttacks = new int[3][4]; 
        aerials = new int[5][4]; 
        specialAttacksGrounded = new int[5][4]; 
        specialAttacksAerial = new int[5][4];
        grabs = new int[2][2];  
        grabThrows = new int[4][3]; 
        dodgesRolls = new int[4][4]; 
        misc = new float[8]; 
    }


    



}
