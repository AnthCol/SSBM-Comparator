package src; 


/*
 * FIXME
 * 
 * 
 * Maybe make toString() methods here?
 * 
 */

/*
 * FIXME
 * 
 * Make a character screen where you select a character and then show how every single one of their damaging moves
 * ranks amongst the whole cast
 * 
 * Something like:
 * Ness
 * Picture
 * Select: (speed or damage)
 * 
 * Jab: 2nd
 * 
 * 
 * Dtilt: 1st
 * 
 * 
 * type of thing 
 * 
 */



public class Character {

    // FIXME make these private later 
    public String characterName; 
    public int[][] jabs;
    public int[][] tilts;
    public int[] dashAttack;
    public int[][] smashAttacks;
    public int[][] aerials;
    public int[][] specialAttacksGrounded; 
    public int[][] specialAttacksAerial;
    public int[][] grabs; 
    public int[][] grabThrows; 
    public int[][] dodgesRolls; 
    public float[] misc; 


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
